import { Component } from 'react';
import { Button, Form, InputGroup } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faHandPointRight } from '@fortawesome/free-solid-svg-icons';

export class Behaviour extends Component {
    render() {
        return (<><h3>Behavioural Assessment Registration</h3>
        <Form className="w-50">
            <InputGroup className="mb-3">
                <InputGroup.Text>User ID</InputGroup.Text>
                <Form.Control type="text" disabled />
            </InputGroup>
            <InputGroup className="mb-3">
                <InputGroup.Text>Assessment</InputGroup.Text>
                <Form.Select>
                    <option selected disabled>Select an assessment</option>
                    <option>Step Plus</option>
                    <option>Email Etiquette</option>
                    <option>Learning Agility</option>
                </Form.Select>
            </InputGroup>
            <InputGroup className="mb-3">
                <InputGroup.Text>Date</InputGroup.Text>
                <Form.Control type="date" id="dateof" />
            </InputGroup>
            <Button type="submit" variant="primary">
                <FontAwesomeIcon icon={faHandPointRight} /> Register
            </Button>
        </Form></>);
    }
}

export default Behaviour;
