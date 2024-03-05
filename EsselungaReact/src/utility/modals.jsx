import { useContext, useState } from 'react';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import 'bootstrap/dist/css/bootstrap.min.css';
import { EsselungaContext } from '../Context';
import { funzione } from "../utility/funzioni"
import { pathUtenteDelete, pathUtenteUpdate } from "../utility/urls"
import * as Costanti from '../utility/costanti'
import AlertErrore from './Alert';
import { useHistory } from 'react-router-dom';
import Update from '../components/Update';

export const ModalConfermaEliminazione = () => {
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  const user = useContext(EsselungaContext)

  const history = useHistory()

  const [password, setPassword] = useState()
  const [controllo, setControllo] = useState(false)

  const eliminaAccount = async () => {

    if (password === user.utente.password) {
      const response = await funzione(pathUtenteDelete, Costanti.DELETE, user.utente)
      
      if(response.status === 204) {

        history.push('/')
      } else if (response.status === 500) {

        alert('Operazione non andata a buon fine')
      }

    } else {
      
      console.log(user.utente.password)
      setControllo(true)
      console.log(password)
      
    }
  }

  return(
    <>
      <Button variant="primary" onClick={handleShow}>
        Elimina account
      </Button>

      <Modal
        show={show}
        onHide={handleClose}
        backdrop="static"
        keyboard={false}
      >
        <Modal.Header closeButton>
          <Modal.Title>Conferma elimina account</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <label>Password</label>
          
          <br/>
          
          <input type='password' onChange={(e) => setPassword(e.target.value)}></input> 

          <AlertErrore controllo = {controllo} setControllo = {setControllo}></AlertErrore>

        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Chiudi
          </Button>
          <Button variant="primary" onClick={() => (eliminaAccount())}>Elimina</Button>
        </Modal.Footer>
      </Modal>

    </>
  );
}

export const ModalUpdate = () => {

  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  const user = useContext(EsselungaContext)

  const [nome, setNome] = useState()
  const [cognome, setCognome] = useState()
  const [email, setEmail] = useState()
  const [password, setPassword] = useState()

  const utenteAggiornato = {

    id : user.utente.id,
    nome : nome === '' ? user.utente.nome : nome,
    cognome : cognome === '' ? user.utente.cognome : cognome,
    email : email === '' ? user.utente.email : email,
    password : password === '' ? user.utente.password : password
  }

  const aggiornaDati = async () => {

    const response = await funzione(pathUtenteUpdate, Costanti.PUT, utenteAggiornato)
    console.log(response)

    if (response.status === 201) {

      user.setUtente(utenteAggiornato)
      handleClose()

    } else if (response.status === 500) {

      alert('Errore!')
    }
    
  }

  return(
  <>
      <Button variant="primary" onClick={handleShow}>
        Aggiorna Dati
      </Button>

      <Modal
        show={show}
        onHide={handleClose}
        backdrop="static"
        keyboard={false}
      >
        <Modal.Header closeButton>
          <Modal.Title>Modal title</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Update setNome={setNome} 
                  setCognome={setCognome}
                  setEmail={setEmail}
                  setPassword={setPassword}>          
          </Update>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Chiudi
          </Button>
          <Button variant="primary" onClick={() => (aggiornaDati())}>Aggiorna</Button>
        </Modal.Footer>
      </Modal>
    </>
  );

}