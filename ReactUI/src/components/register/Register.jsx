import React, { Component } from 'react';
import { Nav, Row, Col, Button } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faAngleRight } from '@fortawesome/free-solid-svg-icons';

export class Register extends Component {
    render() {
        return (<div>
            <Row><Col>
            <Button type="button" variant="primary" className="mt-2 md-2">
                <h5>Technical Assessment Registration <FontAwesomeIcon icon={faAngleRight} /></h5>
            </Button>
            </Col></Row>
            <Row><Col>
            <Button type="button" variant="primary" className="mt-2 md-2">
                <h5>Behavioral Assessment Registration <FontAwesomeIcon icon={faAngleRight} /></h5>
            </Button>
            </Col></Row>

        </div>
        );
    }
}

export default Register;

function Logout() {
    return () => {
        <Row>
            <Nav className="col-sm-2">
                <Nav.Link href="/getOut">Logout</Nav.Link>
            </Nav>
        </Row>
    };
}
