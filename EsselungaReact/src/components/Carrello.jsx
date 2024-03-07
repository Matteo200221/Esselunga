import { useContext, useEffect, useState } from "react"
import { EsselungaContext } from "../Context"
import { useHistory } from "react-router-dom"

const Carrello = () => {

    const history = useHistory()

    const context = useContext(EsselungaContext)

    const [totale, setTotale] = useState(0)

    useEffect(() => {
        calcolaTotale()
        // eslint-disable-next-line
    }, [context.carrello])

    const calcolaTotale = () => {
        var totaleAppoggio = 0
        for(var i = 0; i < context.carrello.length; i++){
            totaleAppoggio += context.carrello[i].prezzo
        }
        setTotale(totaleAppoggio)
    }

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

    const vaiAPagina = (route) => {
        history.push(route)
    }

    
    return(
        <>
            <h1>Carrello</h1>
            {context.carrello.length > 0 ?
            <>
                <table className="centerTable">
                    <thead>
                        <tr>
                        <th>Nome</th>
                        <th>Prezzo</th>
                        <th>Rimuovi</th>
                        </tr>
                    </thead>
                    <tbody>
                        {context.carrello?.map((prodotto, index) => (
                            <tr key={index}>
                            <td>{prodotto.nome}</td>
                            <td>{prodotto.prezzo} €</td>
                            <td><button className="button button-green border-radius-50" onClick={(e) => rimuoviProdotto(e, prodotto)}>-</button></td>
                            </tr>
                        ))}
                    </tbody>
                </table>
                <p>Totale: {totale} €</p>
            </> :
            <p>carrello vuoto</p>}
            <button className="button button-green border-radius-50" onClick={(e) => vaiAPagina('/menu')}>Indietro</button>
        </>
    )
}

export default Carrello