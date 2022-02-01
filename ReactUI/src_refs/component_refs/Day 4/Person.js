import React from 'react'

function Person({person, index}) {
    return (
        <div>
            <li>{index}. I am {person.name}. I am {person.age} years old. I know {person.skill}</li>
        </div>
    )
}

export default Person
