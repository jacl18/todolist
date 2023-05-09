//addTodoForm.addEventListener('submit', (event) => {
//
//    event.preventDefault();
//    const title = document.querySelector('#title').value;
//    const description = document.querySelector('#description').value;
//    const date = document.querySelector('#date').value;
//    console.log(title);
//    console.log(description);
//    console.log(date);
//
//    addTodo(title, description, date);
//
//});//End of addEventListener


addTodoForm.addEventListener('submit', (event) => {

    event.preventDefault();
    const title = document.querySelector('#title').value;
    const description = document.querySelector('#description').value;
    const dateInput = document.querySelector('#date');
    const date = dateInput.value;

    // Set the minimum date to today
    const today = new Date().toISOString().split('T')[0];
    dateInput.setAttribute('min', today);

    // Check if date is valid
    if (date <= today) {
        alert('Please select a future date.');
        return;
    }

    addTodo(title, description, date);

    // Clear the input fields
    document.querySelector('#title').value = '';
    document.querySelector('#description').value = '';
    dateInput.value = '';

});//End of addEventListener