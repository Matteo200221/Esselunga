import Alert from 'react-bootstrap/Alert';

function AlertErrore({controllo, setControllo}) {
  

    return (
      <Alert variant="danger" show={controllo} onClose={() => setControllo(false)} dismissible>
        <Alert.Heading>Error!</Alert.Heading>
        <p>
          Dati errati
        </p>
      </Alert>
    );
  
}

export default AlertErrore;