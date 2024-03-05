const Home = () => {

    const history = useHistory()

    const vaiAPagina = (route) => {
        history.push(route)
    }
    return(
        <>
            <h1>Home</h1>
            <button onclick={(e) => vaiAPagina('/account')}>Account</button>
            <button onclick={(e) => vaiAPagina('/menu')}>Menù</button>
            <button onclick={(e) => vaiAPagina('/login')}>Indietro</button>
        </>
    )
}

export default Home