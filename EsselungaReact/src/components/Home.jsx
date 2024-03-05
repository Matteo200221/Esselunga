import { useHistory } from "react-router-dom"

const Home = () => {

    const history = useHistory()

    const vaiAPagina = (route) => {
        history.push(route)
    }
    return(
        <>
            <h1>Home</h1>
            <button onClick={(e) => vaiAPagina('/account')}>Account</button>
            <button onClick={(e) => vaiAPagina('/menu')}>Menù</button>
            <button onClick={(e) => vaiAPagina('/login')}>Indietro</button>
        </>
    )
}

export default Home