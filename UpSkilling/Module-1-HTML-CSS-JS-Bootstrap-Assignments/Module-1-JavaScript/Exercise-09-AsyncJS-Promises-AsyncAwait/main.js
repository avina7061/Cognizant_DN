// DOM References

const loading = document.getElementById("loading");

const container = document.getElementById("eventContainer");

// Render Function

function renderEvents(events) {
  container.innerHTML = "";

  events.forEach((event) => {
    const card = document.createElement("div");

    card.className = "event-card";

    card.innerHTML = `

            <h2>${event.title}</h2>

            <p>
                Event ID: ${event.id}
            </p>

        `;

    container.appendChild(card);
  });
}

// Promise (.then .catch)

fetch("https://jsonplaceholder.typicode.com/posts?_limit=3")
  .then((response) => {
    return response.json();
  })

  .then((data) => {
    console.log("Using .then()");

    console.log(data);
  })

  .catch((error) => {
    console.log("Fetch Error:", error);
  });

// Async Await

async function fetchEvents() {
  try {
    loading.style.display = "block";

    const response = await fetch(
      "https://jsonplaceholder.typicode.com/posts?_limit=5",
    );

    const data = await response.json();

    renderEvents(data);
  } catch (error) {
    container.innerHTML = "<h2>Error Loading Events</h2>";

    console.log(error);
  } finally {
    loading.style.display = "none";
  }
}

fetchEvents();
