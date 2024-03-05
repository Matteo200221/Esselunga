import axios from "axios"
import * as Costanti from "./costanti"

 export async function funzione (path, metodo, oggetto) {

    switch (metodo) {

        case Costanti.GET : 
                return await axios.get(path)
        case Costanti.POST :
                return await axios.post(path, oggetto)
        case Costanti.DELETE:
                return await axios.post(path, oggetto)
        case Costanti.PUT:
                return await axios.put(path, oggetto)            

    }
    

}

