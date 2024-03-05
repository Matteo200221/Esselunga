import { useContext } from "react"
import { EsselungaContext } from "../Context"
import { ModalConfermaEliminazione } from "../utility/modals"



const Utente = () => {

    const user = useContext(EsselungaContext)

    

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

            <ModalConfermaEliminazione></ModalConfermaEliminazione>

            
        </>
    )
}

export default Utente