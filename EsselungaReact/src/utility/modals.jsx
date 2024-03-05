import { useContext, useState } from 'react';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import 'bootstrap/dist/css/bootstrap.min.css';
import { EsselungaContext } from '../Context';
import { funzione } from "../utility/funzioni"
import { pathUtenteDelete } from "../utility/urls"
import * as Costanti from '../utility/costanti'
import AlertErrore from './Alert';

export const ModalConfermaEliminazione = () => {
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  const user = useContext(EsselungaContext)

  const [password, setPassword] = useState()

  const [controllo, setControllo] = useState(false)

  const eliminaAccount = async () => {

    if (password === user.utente.password) {
      const response = await funzione(pathUtenteDelete, Costanti.DELETE, user.utente)
      console.log(response)
      console.log('delete')
    } else {
      
      console.log(user.utente.password)
      setControllo(true)
      console.log(password)
      
    }
  }

  return (
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