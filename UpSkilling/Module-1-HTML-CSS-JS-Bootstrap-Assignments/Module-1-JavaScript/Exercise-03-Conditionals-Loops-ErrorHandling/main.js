// Event List

const events = [
  {
    name: "Tech Meetup",
    seats: 20,
    isUpcoming: true,
  },

  {
    name: "AI Conference",
    seats: 0,
    isUpcoming: true,
  },

  {
    name: "Web Development Workshop",
    seats: 15,
    isUpcoming: false,
  },

  {
    name: "Community Cleanup Drive",
    seats: 10,
    isUpcoming: true,
  },
];

console.log("Upcoming Events With Available Seats");
console.log("-----------------------------------");

// Loop Through Events

events.forEach((event) => {
  // Condition Check

  if (event.isUpcoming && event.seats > 0) {
    console.log(`${event.name} | Seats Available: ${event.seats}`);
  } else {
    console.log(`${event.name} is hidden (Past Event or No Seats Available)`);
  }
});

console.log("\nRegistration Process");
console.log("--------------------");

// Registration Logic

function registerUser(event) {
  try {
    if (!event.isUpcoming) {
      throw new Error("Cannot register for a past event.");
    }

    if (event.seats <= 0) {
      throw new Error("No seats available.");
    }

    event.seats--;

    console.log(`Successfully registered for ${event.name}`);

    console.log(`Remaining Seats: ${event.seats}`);
  } catch (error) {
    console.log(`Registration Failed: ${error.message}`);
  }
}

// Test Cases

registerUser(events[0]); // Success

registerUser(events[1]); // No seats

registerUser(events[2]); // Past event
