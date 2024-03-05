import { useContext } from "react"
import { EsselungaContext } from "../Context"
import { useHistory } from "react-router-dom"

const Carrello = () => {

    const history = useHistory()

    const context = useContext(EsselungaContext)

    const rimuoviProdotto = (e, prodotto) => {
        var carrelloAppoggio = [...context.carrello]
        for(var i = 0; i < carrelloAppoggio.length; i++){
            if(carrelloAppoggio[i] === prodotto){
                carrelloAppoggio.splice(i, 1)
                break;
            }
        }
        context.setCarrello(carrelloAppoggio)
        console.log(context.carrello)
    }

    
    return(
        <>
            <h1>Carrello</h1>
            {context.carrello.length > 0 ?
            <table>
                <thead>
                    <th>Nome</th>
                    <th>Prezzo</th>
                    <th>Rimuovi</th>
                </thead>
                <tbody>
                    {context.carrello?.map(prodotto => (
                        <tr>
                           <td>{prodotto.nome}</td>
                           <td>{prodotto.prezzo} €</td>
                           <td><button onClick={(e) => rimuoviProdotto(e, prodotto)}>-</button></td>
                        </tr>
                    ))}
                </tbody>
            </table> :
            <p>carrello vuoto</p>}
            <button>Indietro</button>
        </>
    )
}

export default Carrello