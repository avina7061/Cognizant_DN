// DOM References

const form = document.getElementById("registrationForm");

const message = document.getElementById("message");

// Form Submission

form.addEventListener(
  "submit",

  function (event) {
    // Prevent Page Refresh

    event.preventDefault();

    // Collect Form Data

    const userData = {
      name: document.getElementById("name").value,

      email: document.getElementById("email").value,

      selectedEvent: document.getElementById("event").value,
    };

    // Debug Logs

    console.log("Form Submitted");

    console.log("User Data:", userData);

    // Loading Message

    message.className = "loading";

    message.textContent = "Submitting registration...";

    // Simulate Server Delay

    setTimeout(() => {
      console.log("Sending POST Request...");

      sendRegistration(userData);
    }, 2000);
  },
);

// Send Registration Data Using Fetch API

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
      console.log("Response Status:", response.status);

      if (!response.ok) {
        throw new Error("Server Error");
      }

      return response.json();
    })

    .then((data) => {
      console.log("Response Received");

      console.log("Response Data:", data);

      message.className = "success";

      message.textContent = "Registration Submitted Successfully!";
    })

    .catch((error) => {
      console.error("Fetch Error:", error);

      message.className = "error";

      message.textContent = "Registration Failed.";
    });
}
