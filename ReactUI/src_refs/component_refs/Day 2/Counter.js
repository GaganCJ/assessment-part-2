import React, {Component} from 'react'

class Counter extends Component {

    constructor(props) {
        super(props)

        this.state = {
            count: 0
        }
    }

    increment() {
        // this.setState({
        //     count: this.state.count + 1
        // }, () => {console.log('Callback Value', this.state.count)}) //Async - dos
        //this.state.count = this.state.count + 1

        this.setState((prevState, props) => ({
            count: prevState.count + 1
        }))
        console.log(this.state.count) //Sync function call - don'ts
    }


    render() {
        return (
            <div>
                <h4>count - {this.state.count}</h4>
                <button onClick={() => this.increment()}>Increment</button>
            </div>
        )
    }
}

export default Counter