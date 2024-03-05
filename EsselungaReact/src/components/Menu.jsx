import { useContext, useEffect, useState } from "react"
import { pathProdottoGetMenu } from "../utility/urls"
import axios from 'axios'
import { useHistory } from "react-router-dom"
import { EsselungaContext } from "../Context"

const Menu = () => {
    
    const [menu, setMenu] = useState([])

    const history = useHistory()

    const context = useContext(EsselungaContext)

    const vaiAPagina = (route) => {
        history.push(route)
    }

    useEffect(() => {
        getMenu()
        // eslint-disable-next-line
    }, [])

    const getMenu = async () => {
        try{
            var response = await axios.get(pathProdottoGetMenu)
            console.log(response)
            if(response.status === 200){
                setMenu(response.data)
                console.log(menu)
            }
        } catch(ex){
            console.log(ex)
        }  
    }

    const aggiungiAlCarrello = (e, prodotto) => {
        var carrelloAppoggio = [...context.carrello]
        carrelloAppoggio.push(prodotto)
        context.setCarrello(carrelloAppoggio)
        console.log(context.carrello)
        alert('prodotto aggiunto!')
    }
    return(
        <>
            <h1>Menù</h1>
            {menu.length > 0 ? 
            <table>
                <thead>
                    <tr>
                    <th>Nome</th>
                    <th>Prezzo</th>
                    <th>Aggiungi</th>
                    </tr>
                </thead>
                <tbody>
                    {menu?.map(prodotto => (
                        <tr key={prodotto.id}>
                            <td>{prodotto.nome}</td>
                            <td>{prodotto.prezzo} €</td>
                            <td><button onClick={(e) => aggiungiAlCarrello(e, prodotto)}>+</button></td>
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

export default Menu