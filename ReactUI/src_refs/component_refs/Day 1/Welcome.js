import React, { Component } from 'react'

class Welcome extends Component {
    render() {
        return (
            <h1>Class Component {this.props.name}</h1>
        )
    }
}

//class Welcome extends Component {
//    render() {
//        const {name} = this.props
//        return (
//            <h1>Class Component {name}</h1>
//        )
//    }
//}

export default Welcome