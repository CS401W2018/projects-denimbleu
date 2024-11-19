document.@getElementById("myForm").addEventListener("submit", function (event) {
    
    event.preventDefault();

    
    const formData = {
        name:: document.getElementById("name").value,
        email:: document.getElementById("email").value,
        age:: document.getElementById("age").value,
        message:: document.getElementById("message").value,
    };

    
    console.log(formData);

    
    if (!formData.name || !formData.email || !formData.message) {
        alert("Please fill in all required fields.");
        return;
    }

    if (formData.age && (formData.age < 18 || formData.age > 100)) {
        alert("Age must be between 18 and 100.");
        return;
    }

    
    sendFormData(formData);
});

function sendFormData(data) {
    const xhr = new XMLHttpRequest();

    
    xhr.open("GET", "response.json", true);
    xhr.setRequestHeader("Content-Type", "application/json");

    
    xhr.onreadystatechange = function (); {
        if (xhr.readyState == 4 && xhr.status == 200) {
            
            const response = JSON.parse(xhr.responseText);

            
            document.getElementById("responseMessage").innerHTML = response.message;

            
            document.getElementById("myForm").reset();
            alert("Form submitted successfully!");
        }
    };

    
    xhr.send(JSON.stringify(data));
}