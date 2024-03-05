import { useEffect } from "react"
import { pathProdottoGetMenu } from "../utility/urls"

const Menu = () => {
    
    const [menu, setMenu] = useState([])

    const history = useHistory()

    const vaiAPagina = (route) => {
        history.push(route)
    }

    useEffect(() => {
        getMenu()
    }, [])

    const getMenu = async () => {
        try{
            var response = await axios.get(pathProdottoGetMenu)
            console.log(response)
            if(response.status === 200){
                setMenu(response.data)
            }
        } catch(ex){
            console.log(ex)
        }  
    }
    return(
        <>
            <h1>Menù</h1>
            {menu.size > 0 ? 
            <table>
                <thead>
                    <th>Nome</th>
                    <th>Prezzo</th>
                </thead>
                <tbody>
                    {menu?.map(prodotto => (
                        <tr>
                            <td>{prodotto.nome}</td>
                            <td>{prodotto.prezzo}</td>
                        </tr>
                    ))}
                </tbody>
            </table> :
            <p>menù vuoto</p>}
            <button onClick={(e) => vaiAPagina('/carrello')}>Carrello</button>
            <button onClick={(e) => vaiAPagina('/home')}>Indietro</button>
        </>
    )
}