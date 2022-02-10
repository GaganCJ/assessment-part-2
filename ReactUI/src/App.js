import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Container, Navbar } from 'react-bootstrap';
import Login from './components/login/Login';
import Register from './components/register/Register';
import { Component } from 'react';

class App extends Component{
  componentWillMount() {
    document.title = "Assessment";
  }
  render() {
    return (<div>
      <Navbar className="App-header">
        <Container>
          <Navbar.Brand href="https://reactjs.org">
            <img src={logo} className="d-inline-block align-top App-logo" alt="logo" width="50" height="50" />
          </Navbar.Brand>
        </Container>
      </Navbar>
      <Container fluid>
        <Login />
        <Register />
      </Container>
    </div>
    );
  }
}

export default App;