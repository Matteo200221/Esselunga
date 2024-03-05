import { useContext } from "react"
import { EsselungaContext } from "../Context"
import { ModalConfermaEliminazione } from "../utility/modals"


const Utente = () => {

    const user = useContext(EsselungaContext)

    const eliminaAccount = () => {

        console.log('ciao')
    }

    return(
        <>

            <p>Nome</p> 
            
            <label>{user.utente.nome}</label>
            
            <br/>
            <br/>

            <p>Cognome</p>

            <label>{user.utente.cognome}</label>

            <br/>
            <br/>

            <p>Email</p>

            <label>{user.utente.email}</label>

            <br/>
            <br/>

            <ModalConfermaEliminazione eliminaAccount = {eliminaAccount}></ModalConfermaEliminazione>
        </>
    )
}

export default Utente