import Alert from 'react-bootstrap/Alert';
 
function AlertSucces({testo, show, setShow}) {

  return (
    <>
        <Alert show={show} key={'success'} variant='success' dismissible onClose={(e)=>setShow(false)}>
          {testo}
        </Alert>
    </>
  );
}

export default AlertSucces;