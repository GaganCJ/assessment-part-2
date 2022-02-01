import React, { Component } from 'react';
import { Table } from 'react-bootstrap';

export class Admin extends Component {
  render() {
    return(<Table striped bordered hover>
      <thead>
        <tr>
          <th>#</th>
          <th>User Name</th>
          <th>Skill Name</th>
          <th>DoE</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th>{{userId}}</th>
          <th>{{userName}}</th>
          <th>{{skillTaken}}</th>
          <th>{{date}}</th>
        </tr>
      </tbody>
    </Table>);
  }
}
