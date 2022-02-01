import React, { Component } from 'react'
import LifeCycleB from './LifeCycleB'

class lifeCycle_1 extends Component {
    constructor(props) {
        super(props)

        this.state = {
            name: 'Vishwas'
        }
        console.log('LifecycleA constructor')
    }

    static getDerivedStateFromProps(Props, state) {
        console.log('LifecycyleA getDerivedStateFromProps')
        return null
    }

    shouldComponentUpdate() {
        console.log('LifecycleA shouldComponentUpdate')
        return true
    }

    getSnapshotBeforeUpdate(prevProps, prevState) {
        console.log('LifecycleA getSnapshotBeforeUpdate')
        return null
    }

    componentDidUpdate() {
        console.log('LifecycleA componentDidUpdate')
    }

    componentDidMount() {
        console.log('LifecycleA componentDidMount')
    }

    changeState = () => {
        this.setState({
            name: 'Codevolution'
        })
    }

    render() {
        console.log('LifecycleA render')
        return (
            <div>
                <h1>LifecycleA</h1>
                <button onClick={this.changeState}>Change State</button>
                <LifeCycleB />
            </div>
        )
    }
}

export default lifeCycle_1
