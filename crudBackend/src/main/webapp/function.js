const BASE_URL = window.location.origin + "/api/user";
// CREATE USER
function createUser() {

    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const age = document.getElementById("age").value;

    fetch(BASE_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            name: name,
            email: email,
            age: parseInt(age)
        })
    })
    .then(response => response.json())
    .then(data => {
        alert(data.message);
        clearForm();
    })
    .catch(error => console.error("Error:", error));
}


// GET USER
function getUser() {

    const id = document.getElementById("getId").value;

    fetch(`${BASE_URL}?id=${id}`)
    .then(response => response.json())
    .then(data => {
        document.getElementById("result").innerText =
            JSON.stringify(data, null, 4);
    })
    .catch(error => console.error("Error:", error));
}


// UPDATE USER
function updateUser() {

    const id = document.getElementById("userId").value;
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const age = document.getElementById("age").value;

    fetch(`${BASE_URL}?id=${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            name: name,
            email: email,
            age: parseInt(age)
        })
    })
    .then(response => response.json())
    .then(data => {
        alert(data.message);
        clearForm();
    })
    .catch(error => console.error("Error:", error));
}


// DELETE USER
function deleteUser() {

    const id = document.getElementById("deleteId").value;

    fetch(`${BASE_URL}?id=${id}`, {
        method: "DELETE"
    })
    .then(response => response.json())
    .then(data => {
        alert(data.message);
    })
    .catch(error => console.error("Error:", error));
}


// CLEAR FORM
function clearForm() {
    document.getElementById("userId").value = "";
    document.getElementById("name").value = "";
    document.getElementById("email").value = "";
    document.getElementById("age").value = "";
}
