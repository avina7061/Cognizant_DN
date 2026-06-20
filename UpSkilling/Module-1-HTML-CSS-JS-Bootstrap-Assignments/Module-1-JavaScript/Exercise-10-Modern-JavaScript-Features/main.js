// Event List

const events = [
  {
    id: 1,
    name: "Tech Meetup",
    category: "Technology",
    seats: 20,
  },

  {
    id: 2,
    name: "Music Night",
    category: "Music",
    seats: 15,
  },

  {
    id: 3,
    name: "Community Cleanup",
    category: "Social",
    seats: 10,
  },
];

// Default Parameters

function registerUser(userName = "Guest", eventName = "Unknown Event") {
  console.log(`${userName} registered for ${eventName}`);
}

// Destructuring

console.log("Event Details");
console.log("-------------");

events.forEach((event) => {
  const { id, name, category, seats } = event;

  console.log(
    `ID: ${id}
Name: ${name}
Category: ${category}
Seats: ${seats}
`,
  );
});

// Spread Operator

const clonedEvents = [...events];

const technologyEvents = clonedEvents.filter(
  (event) => event.category === "Technology",
);

// Function Calls

console.log("\nRegistrations");
console.log("-------------");

registerUser("Amishhh", "Tech Meetup");

registerUser();

// Filtered Events

console.log("\nTechnology Events");
console.log("-----------------");

technologyEvents.forEach(({ name, seats }) => {
  console.log(`${name} | Seats: ${seats}`);
});
