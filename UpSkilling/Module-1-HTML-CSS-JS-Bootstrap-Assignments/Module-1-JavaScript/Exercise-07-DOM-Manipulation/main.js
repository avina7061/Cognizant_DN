// Event Data

const events = [
  {
    name: "Tech Meetup",
    seats: 20,
  },

  {
    name: "Music Night",
    seats: 15,
  },

  {
    name: "Community Cleanup",
    seats: 10,
  },
];

// DOM Access

const container = document.querySelector("#eventContainer");

// Render Events

function renderEvents() {
  container.innerHTML = "";

  events.forEach((event) => {
    const card = document.createElement("div");

    card.classList.add("event-card");

    card.innerHTML = `

            <h2>${event.name}</h2>

            <p>
                Available Seats:
                <span>${event.seats}</span>
            </p>

            <button class="register-btn">
                Register
            </button>

            <button class="cancel-btn">
                Cancel
            </button>

        `;

    const registerBtn = card.querySelector(".register-btn");

    registerBtn.addEventListener(
      "click",

      () => {
        if (event.seats > 0) {
          event.seats--;

          renderEvents();
        }
      },
    );

    const cancelBtn = card.querySelector(".cancel-btn");

    cancelBtn.addEventListener(
      "click",

      () => {
        event.seats++;

        renderEvents();
      },
    );

    container.appendChild(card);
  });
}

// Initial Render

renderEvents();
