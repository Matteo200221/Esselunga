

const Update = ({setNome, setCognome, setEmail, setPassword}) => {

    return(
        <>

        <p>Nome</p>

        <input type='text' onChange={(e) => setNome(e.target.value)}/>

        <p>Cognome</p>

        <input type='text' onChange={(e) => setCognome(e.target.value)}/>

        <p>Email</p>

        <input type='text' onChange={(e) => setEmail(e.target.value)}/>

        <p>Password</p>

        <input type='password' onChange={(e) => setPassword(e.target.value)}/>
        </>
    )
}

export default Update