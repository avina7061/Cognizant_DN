// Event Data

const events = [
  {
    name: "Tech Meetup",
    category: "Technology",
    seats: 20,
  },

  {
    name: "Music Night",
    category: "Music",
    seats: 15,
  },

  {
    name: "Community Cleanup",
    category: "Social",
    seats: 10,
  },
];

// DOM References

const container = document.getElementById("eventContainer");

const categoryFilter = document.getElementById("categoryFilter");

const searchBox = document.getElementById("searchBox");

// Render Events

function renderEvents(eventList) {
  container.innerHTML = "";

  eventList.forEach((event) => {
    const card = document.createElement("div");

    card.className = "event-card";

    card.innerHTML = `

            <h2>${event.name}</h2>

            <p>
                Category:
                ${event.category}
            </p>

            <p>
                Seats:
                ${event.seats}
            </p>

            <button
                onclick="register('${event.name}')">

                Register

            </button>

        `;

    container.appendChild(card);
  });
}

// onclick

function register(eventName) {
  alert(`Registered for ${eventName}`);
}

// onchange

categoryFilter.onchange = function () {
  const selected = this.value;

  if (selected === "All") {
    renderEvents(events);

    return;
  }

  const filtered = events.filter((event) => event.category === selected);

  renderEvents(filtered);
};

// keydown

searchBox.addEventListener(
  "keydown",

  () => {
    const keyword = searchBox.value.toLowerCase();

    const filtered = events.filter((event) =>
      event.name.toLowerCase().includes(keyword),
    );

    renderEvents(filtered);
  },
);

// Initial Load

renderEvents(events);
