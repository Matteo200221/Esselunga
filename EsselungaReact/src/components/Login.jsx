import { useState } from "react"
import { useHistory } from "react-router-dom"
import { pathUtenteLogin } from "../utility/urls"
import { funzione } from "./funzioni"
import * as Costanti from "./costanti"

const Login = () => {

    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')

    const history = useHistory()

    const login = async () => {

      /*   try {

            const response = await axios.get(pathUtenteLogin + email + '/' + password)
            console.log(response)
            
        } catch (ex) {
            
            alert('Dati errati')
        }
         */

        const data = { 
            
            email : email,
            password : password 
        
        }

        const response = await funzione(pathUtenteLogin, Costanti.POST, data)

        console.log(response)
        if(response.status === 200) {
            history.push('/')
        } else {
            alert("credenziali errate")
        }

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