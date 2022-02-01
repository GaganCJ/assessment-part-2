import React, {Component} from 'react'

class Message extends Component {
    constructor() {
        super()
        this.state = {
            message: 'Welcome Vistor'
        }
    }

    changeMessage() {
        this.setState({
            message: 'End of the session'
        })
    }

    render() {
        // const {state1, state2} = this.state
        return(
            <div>
                <h1>{this.state.message}</h1>
                <button onClick={() => this.changeMessage()}>Subscribe</button>
            </div>
        )
    }
}

export default Message