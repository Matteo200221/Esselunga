import { useHistory } from "react-router-dom"
import { utenteInsert } from "../urls"
import { useState } from "react"
import axios from 'axios'

const Registrazione = () => {
    const [nome, setNome] = useState('')
    const [cognome, setCognome] = useState('')
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')

    const history = useHistory()

    const vaiAPagina = (route) => {
        history.push(route)
    }

    const inserisciUtente = async () => {
        if(nome !== ''
        && cognome !== ''
        && email !== ''
        && password !== ''){
            try{
                var response = await axios.post(utenteInsert, {
                    nome,
                    cognome,
                    email,
                    password
                })
                console.log(response)
                if(response.status === 201){
                    alert("registrazione avvenuta")
                    vaiAPagina('login')
                }
            } catch(e){
                alert('errore')
                console.log(e)
            }
        } else {
            alert('campi obbligatori')
        }
    }

    return(
        <>
            <h3>Registrazione</h3>
            <label>Nome</label>
            <input type="text" onChange={(e) => setNome(e.target.value)}/>
            <br/>
            <label>Cognome</label>
            <input type="text" onChange={(e) => setCognome(e.target.value)}/>
            <br/>
            <label>Email</label>
            <input type="text" onChange={(e) => setEmail(e.target.value)}/>
            <br/>
            <label>Password</label>
            <input type="text" onChange={(e) => setPassword(e.target.value)}/>
            <br/>
            <button onClick={(e) => inserisciUtente()}>Invio</button>
            <br/>
            <button onClick={(e) => vaiAPagina('/')}>Indietro</button>
        </>
    )
}

export default Registrazione