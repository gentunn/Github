import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import {BrowserRouter, Route, Switch, Link} from 'react-router-dom';
import CarList from './CarList.js';
import Home from './Home.js';
import About from './About.js';
import FrontPage from './FrontPage.js';


class App extends Component {
    render() {
        return <div>
            <div className="App">
                <header className="App-header">
                    <h1 className="App-title">My Car Shop</h1>
                </header>
                <BrowserRouter>
                    <div>
                    <Link style={{margin:20}} to="/">Frontpage</Link>
                    <Link style={{margin:20}} to="/home">Home</Link>
                    <Link style={{margin:20}} to="/carList">Cars</Link>
                    <Switch>
                        <Route exact path="/" component={FrontPage}/>
                        <Route path="/home" component={Home}/>
                        <Route path="/about" component={About}/>
                        <Route path="/contact" render={() => <h1>Contact Addresss</h1>}/>
                        <Route path="/carList" component={CarList}/>
                        <Route render={() => <h1>Page not found</h1>}/>
                    </Switch>
                    </div>
                </BrowserRouter>
            </div>
        </div>
    };
}
          export default App;

