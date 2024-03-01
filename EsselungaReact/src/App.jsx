import { BrowserRouter, Switch, Route } from 'react-router-dom';
import './App.css';
import { EsselungaContext } from  './Context'
import Accesso from './components/Accesso';
import Registrazione from './components/Registrazione';
import Login from './components/Login';
import { useState } from 'react';

function App() {

  const [utente,setUtente] = useState(null)

  const contextValue = {utente, setUtente}

  return (
    <BrowserRouter>
      <div className="App">
      <header className="App-header">
        <h1>Esselunga</h1>
      </header>
      <div>
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
        </Switch>
        </EsselungaContext.Provider>
      </div>
      <footer>
        <h6>Sviluppato da M&M</h6>
      </footer>
    </div>
    </BrowserRouter>
  );
}

export default App;
