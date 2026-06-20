// Form Reference

const form = document.getElementById("registrationForm");

// Form Submission

form.addEventListener(
  "submit",

  function (event) {
    // Prevent Default Behavior

    event.preventDefault();

    // Clear Old Errors

    document.getElementById("nameError").textContent = "";

    document.getElementById("emailError").textContent = "";

    document.getElementById("eventError").textContent = "";

    document.getElementById("successMessage").textContent = "";

    // form.elements

    const name = form.elements["name"].value.trim();

    const email = form.elements["email"].value.trim();

    const selectedEvent = form.elements["event"].value;

    let isValid = true;

    // Name Validation

    if (name === "") {
      document.getElementById("nameError").textContent = "Name is required.";

      isValid = false;
    }

    // Email Validation

    if (email === "") {
      document.getElementById("emailError").textContent = "Email is required.";

      isValid = false;
    }

    // Event Validation

    if (selectedEvent === "") {
      document.getElementById("eventError").textContent =
        "Please select an event.";

      isValid = false;
    }

    // Success

    if (isValid) {
      document.getElementById("successMessage").innerHTML = `<p class="success">
                    Registration Successful!
                    <br>
                    Name: ${name}
                    <br>
                    Event: ${selectedEvent}
                </p>`;
    }
  },
);
