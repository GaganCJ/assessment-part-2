import { Component } from 'react';
import { Row, Col, Button } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faAngleRight } from '@fortawesome/free-solid-svg-icons';
import { Behaviour } from './behaviour/Behaviour';
import { Technical } from './technical/Technical';

export class Register extends Component {
    constructor() {
        super();
        this.state = {changeForm :
            (<><Row><Col>
                <Button type="button" variant="primary" className="mt-2 md-2" onClick={this.changeTechState}>
                    <h5>Technical Assessment Registration <FontAwesomeIcon icon={faAngleRight} /></h5>
                </Button>
            </Col></Row><Row><Col>
                <Button type="button" variant="primary" className="mt-2 md-2" onClick={this.changeBehvState}>
                    <h5>Behavioral Assessment Registration <FontAwesomeIcon icon={faAngleRight} /></h5>
                </Button>
            </Col></Row></>)
        };
    }
    changeTechState = () => {
        this.setState({changeForm : (<Technical />)})
    }
    changeBehvState = () => {
        this.setState({changeForm : (<Behaviour />)})
    }
    render() {
        return (<div>
            {this.state.changeForm}
        </div>
        );
    }
}

export default Register;
