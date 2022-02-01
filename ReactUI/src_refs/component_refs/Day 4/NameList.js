import React from "react";
//import Person from "./Person";

function NameList() {
  const names = ['Bruce', 'Clark', 'Diana', 'Bruce']
  /*const listPerson = [
    {
      id: 1,
      name: "Bruce",
      age: 30,
      skill: "React",
    },
    {
      id: 2,
      name: "Clark",
      age: 25,
      skill: "Angular",
    },
    {
      id: 3,
      name: "Diana",
      age: 28,
      skill: "Vue",
    }
  ];*/
  //const listRender = listPerson.map((person) => <Person index={person.id} person={person}/>);
  const nameList = names.map((name, index) => <h2 key={index}>{index} {name}</h2>) //item add at top ends up at bottom
  // Index as key anti-pattern
  //return <div>{listRender}</div>;
  return <div>{nameList}</div>
}

export default NameList;

// props deconstruction here

//1. the items in your list do not have a unique id
//2. the list is a static list and will not change
//3. the list will never be reordered or filtered