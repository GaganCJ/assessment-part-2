import React, { Component } from 'react';
import { Button, Form } from 'react-bootstrap';

export class Behaviour extends Component {
  render() {
    return (<Form>
        <Form.Group>
            <Form.Label className="col-md-3">User ID</Form.Label>
            <div className="col-md-9">
                <input type="text" className="form-control" disabled />
            </div>
        </Form.Group>
        <Form.Group>
            <Form.Label className="col-md-3">Assessment</Form.Label>
            <div className="col-md-9">
                <select className="form-control">
                    <option selected disabled>Select an assessment</option>
                    <option>Step Plus</option>
                    <option>Email Etiquette</option>
                    <option>Learning Agility</option>
                </select>
            </div>
        </Form.Group>
        <Form.Group>
            <Form.Label className="col-md-3">Date</Form.Label>
            <div className="col-md-9">
                <input type="date" id="dateof" className="form-control" placeholder="Select a Date" />
            </div>
        </Form.Group>
        <Form.Group>
            <div className="col-md-offset-3 col-md-9">
                <Button type="submit" className="btn btn-info">
                    <i className="icon-hand-right"></i>Register
                </Button>
            </div>
        </Form.Group>
    </Form>);
  }
}

export default Behaviour;
