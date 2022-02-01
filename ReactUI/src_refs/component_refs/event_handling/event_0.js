import React from 'react';

export default class Event extends React.Component {
    handleText(event) {
        console.log(event.target.value);
    }
    add() {
        alert('Add clicked');
    }
    edit() {
        alert('Edit clicked');
    }
    delete() {
        alert('Delete clicked');
    }
    render() {
        return (
            <>
                <h2>Event Demo</h2>
                <input type="text" onChange={(e) => this.handleText(e)}/>
                <button onClick={() => this.add()}>Add</button>
                <button onClick={() => this.edit()}>Edit</button>
                <button onClick={() => this.delete()}>Delete</button>
            </>
        );
    }
}