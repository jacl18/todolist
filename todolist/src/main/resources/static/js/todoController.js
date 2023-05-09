//development APIs  - global variables
const addAPI= 'http://localhost:8080/todo/add';
const displayAPI = 'http://localhost:8080/todo/all';

let todoController = [];



function displayTask() {

todoController = [];

    fetch(displayAPI)
        .then((resp) => resp.json())
        .then(function(data) {
            console.log("2. received data")

            data.forEach(function(todo, index) {

                const todoObj = {
                    title: todo.title,
                    description: todo.description,
                    date: new Date(todo.date).toLocaleDateString('en-GB')
                };
                todoController.push(todoObj);
            });

            renderTodoPage();
        })
        .catch(function(error) {
            console.log(error);
        });

}//End of displayTask function




function renderTodoPage() {

    let display = "";

    for (let i = 0; i < todoController.length; i++ ) {

        display += `
                <tr>
                   <td>${todoController[i].title}</td>
                   <td>${todoController[i].description}</td>
                   <td>${todoController[i].date}</td>
                </tr>
        `
    }

    document.querySelector("#trow").innerHTML= display;

} //End of renderTodoPage function



function addTodo(title, description, date) {
    /*FormData is an Object provided by the Browser API for us to send the data to the backend. If no object, can use
    json format */

   const formData = new FormData();
   formData.append('title', title);
   formData.append('description', description);
   formData.append('date', date);

  fetch(addAPI, {
        method: 'POST',
        body: formData
        })
        .then(function(response) {
            console.log(response.status); // Will show you the status
            if (response.ok) {
                alert("Successfully Added Task!")
                displayTask();
            }
            else {
               alert("Something went wrong. Please try again")
            }
        })
        .catch((error) => {
            console.error('Error:', error);
            alert("Error adding item to ToDo List")
        });

}//End of addToDo()



