import React from 'react';
import Button from 'react-bootstrap/Button';
import 'bootstrap/dist/css/bootstrap.min.css';

function FunctionClick() {

    function clickHandler() { //clickHandler(A Event Handler) is a function, not a function call
        console.log('Button clicked')
    }
    return (
        <div>
            <Button variant="primary" onClick={clickHandler}>Click</Button>
        </div>
    )
}

export default FunctionClick
