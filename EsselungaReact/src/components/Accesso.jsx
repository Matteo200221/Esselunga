import { useHistory } from "react-router-dom/cjs/react-router-dom.min"

const Accesso = () => {
    const history = useHistory()

    const vaiAPagina = (route) => {
        history.push(route)
    }

    return(
        <>
            <h3>Accesso</h3>
            <button className="button button-green border-radius-50" onClick={(e) => vaiAPagina('/registrazione')}>Registrazione</button>
            <button className="button button-green border-radius-50" onClick={(e) => vaiAPagina('/login')}>Login</button>
        </>
    )
}

export default Accesso