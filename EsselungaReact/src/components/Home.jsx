import { useHistory } from "react-router-dom"

const Home = () => {

    const history = useHistory()

    const vaiAPagina = (route) => {
        history.push(route)
    }
    return(
        <>
            <h1>Home</h1>
            <button className="button button-green border-radius-50" onClick={(e) => vaiAPagina('/account')}>Account</button>
            <button className="button button-green border-radius-50" onClick={(e) => vaiAPagina('/menu')}>Menù</button>
            <button className="button button-green border-radius-50" onClick={(e) => vaiAPagina('/login')}>Indietro</button>
        </>
    )
}

export default Home