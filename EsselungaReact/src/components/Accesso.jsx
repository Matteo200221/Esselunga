import { useHistory } from "react-router-dom/cjs/react-router-dom.min"

const Accesso = () => {
    const history = useHistory()

    const vaiAPagina = (route) => {
        history.push(route)
    }

    return(
        <>
            <h3>Accesso</h3>
            <button onClick={(e) => vaiAPagina('/registrazione')}>Registrazione</button>
            <button onClick={(e) => vaiAPagina('/login')}>Login</button>
        </>
    )
}

export default Accesso