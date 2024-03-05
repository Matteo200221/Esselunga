import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import 'bootstrap/dist/css/bootstrap.min.css';

export const ModalConfermaEliminazione = ( {eliminaAccount} ) => {
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

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
          
          <input type='password'></input> 
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Chiudi
          </Button>
          <Button variant="primary" onClick={eliminaAccount}>Elimina</Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}