// DOM References

const form = document.getElementById("registrationForm");

const message = document.getElementById("message");

// Form Submission

form.addEventListener(
  "submit",

  function (event) {
    event.preventDefault();

    const userData = {
      name: document.getElementById("name").value,

      email: document.getElementById("email").value,

      selectedEvent: document.getElementById("event").value,
    };

    // Loading Message

    message.className = "loading";

    message.textContent = "Submitting registration...";

    // Simulate Delay

    setTimeout(() => {
      sendRegistration(userData);
    }, 2000);
  },
);

// Fetch POST Request

function sendRegistration(userData) {
  fetch(
    "https://jsonplaceholder.typicode.com/posts",

    {
      method: "POST",

      headers: {
        "Content-Type": "application/json",
      },

      body: JSON.stringify(userData),
    },
  )
    .then((response) => {
      if (!response.ok) {
        throw new Error("Server Error");
      }

      return response.json();
    })

    .then((data) => {
      console.log(data);

      message.className = "success";

      message.textContent = "Registration Submitted Successfully!";
    })

    .catch((error) => {
      console.error(error);

      message.className = "error";

      message.textContent = "Registration Failed.";
    });
}
