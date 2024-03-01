import axios from "axios"
import { useState } from "react"
import { useHistory } from "react-router-dom"
import { utenteLogin } from "../urls"

const Login = () => {

    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')

    const history = useHistory()

    const login = async () => {

        try {

            const response = await axios.get(utenteLogin + email + '/' + password)
            console.log(response)
            
        } catch (ex) {
            
            alert('Si è verificato un errore')
        }
        

    }

    const vaiAPagina = (route) => {
        history.push(route)
    }

    return(
        <>
            <h3>Registrazione</h3>
            <label>Email</label>
            <input type="text" onChange={(e) => setEmail(e.target.value)}/>
            <br/>
            <label>Password</label>
            <input type="password" onChange={(e) => setPassword(e.target.value)}/>
            <br/>
            <h3>Login</h3>
            <button onClick={(e) => login()}>login</button>
        </>
    )
}

export default Login