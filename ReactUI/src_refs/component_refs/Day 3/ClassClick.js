import React, { Component } from 'react';
import Button from 'react-bootstrap/Button';
import 'bootstrap/dist/css/bootstrap.min.css';

class ClassClick extends Component {
    clickHandler() {
        console.log('Clicked the button')
    }
    render() {
        return (
            <div>
                <Button variant="primary" onClick={this.clickHandler}>Click Me..!!</Button>
            </div>
        )
    }
}

export default ClassClick
