import { BrowserRouter, Switch, Route } from 'react-router-dom';
import './App.css';
import { EsselungaContext } from  './Context'
import Accesso from './components/Accesso';
import Registrazione from './components/Registrazione';
import Login from './components/Login';
import { useState } from 'react';
import Utente from './components/Utente';
import Menu from './components/Menu';
import Home from './components/Home';
import Carrello from './components/Carrello';


function App() {

  const [utente,setUtente] = useState(null)
  const [carrello, setCarrello] = useState([])

  const contextValue = {utente, setUtente, carrello, setCarrello}

  return (
    <>

        <header className="App-header">
          <h1>Esselunga</h1>
        </header>

        <body className='App-body'>
          <BrowserRouter>
            <EsselungaContext.Provider value={contextValue}>
              <Switch>
                <Route exact path={'/'}>
                  <Accesso/>
                </Route>
                <Route exact path={'/registrazione'}>
                  <Registrazione/>
                </Route>
                <Route exact path={'/login'}>
                  <Login/>
                </Route>
                <Route exact path={'/account'}>
                  <Utente/>
                </Route>
                <Route exact path={'/menu'}>
                <Menu />
                </Route>
                <Route exact path={'/home'}>
                <Home />
                </Route>
                <Route exact path={'/carrello'}>
                <Carrello />
                </Route>
              </Switch>
            </EsselungaContext.Provider>
          </BrowserRouter>
        </body>

      <div>
        <footer className='App-footer'>
          <h6>Sviluppato da M&M</h6>
        </footer>
      </div>

    </>
  );
}

export default App;
