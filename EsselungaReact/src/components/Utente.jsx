import { useContext } from "react"
import { EsselungaContext } from "../Context"
import { ModalConfermaEliminazione } from "../utility/modals"


const Utente = () => {

    const user = useContext(EsselungaContext)

    const eliminaAccount = () => {

    }

    return(
        <>

            <p>Nome</p> 
            
            <br/>

            <p>{user.utente.nome}</p>
            
            <br/>

            <p>Cognome</p>

            <br/>

            <p>{user.utente.cognome}</p>

            <br/>

            <p>Email</p>

            <br/>

            <p>{user.utente.email}</p>

            <br/>

            <ModalConfermaEliminazione eliminaAccount = {eliminaAccount}></ModalConfermaEliminazione>


            
        
        </>
    )
}

export default Utente