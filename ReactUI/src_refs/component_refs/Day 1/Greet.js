import React from 'react'

{/*function Greet() {
    return <h1>Hello World..!!</h1>
}*/}

//export const Greet = () => <h1>Hello World</h1>

//const Greet = () => <h1>Hello World</h1>

//const Greet = ({name}) => {
//    return(
//        <div>
//            <h1>Hello {name}</h1>
//        </div>
//    )
//}

//const Greet = props => {
//    const {name} = props
//    return(
//        <div>
//            <h1>Hello {name}</h1>
//        </div>
//    )
//}

const Greet = props => {
    return(
        <div>
            <h1>Hello {props.name}</h1>
        </div>
    )
    //return React.createElement('div', {id : 'hello', className: 'dummyClass'}, 'Hello World')
}

export default Greet