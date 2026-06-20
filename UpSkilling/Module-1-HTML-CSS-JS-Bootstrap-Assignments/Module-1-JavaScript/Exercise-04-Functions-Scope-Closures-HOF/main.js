// Event Storage

const events = [];

// addEvent()

function addEvent(name, category, seats) {
  events.push({
    name,
    category,
    seats,
  });

  console.log(`Event Added: ${name}`);
}

// registerUser()

function registerUser(eventName) {
  const event = events.find((e) => e.name === eventName);

  if (!event) {
    console.log(`Event "${eventName}" not found`);

    return;
  }

  if (event.seats <= 0) {
    console.log(`No seats available for ${eventName}`);

    return;
  }

  event.seats--;

  console.log(`Successfully registered for ${eventName}`);
}

// filterEventsByCategory()

function filterEventsByCategory(category) {
  return events.filter((event) => event.category === category);
}

// Closure
// Tracks registrations per category

function registrationTracker(category) {
  let totalRegistrations = 0;

  return function () {
    totalRegistrations++;

    console.log(`${category} Registrations: ${totalRegistrations}`);
  };
}

// Higher Order Function
// Callback Based Search

function searchEvents(callback) {
  const result = callback(events);

  console.log("\nSearch Results:");

  result.forEach((event) => {
    console.log(`${event.name} (${event.category})`);
  });
}

// Add Events

addEvent("Tech Meetup", "Technology", 20);

addEvent("AI Workshop", "Technology", 15);

addEvent("Community Cleanup", "Social", 10);

// Registration

registerUser("Tech Meetup");

registerUser("AI Workshop");

// Closure Demo

const techTracker = registrationTracker("Technology");

techTracker();

techTracker();

techTracker();

// Category Filter Demo

console.log("\nTechnology Events:");

const techEvents = filterEventsByCategory("Technology");

techEvents.forEach((event) => {
  console.log(event.name);
});

// Callback Demo

searchEvents((events) => {
  return events.filter((event) => event.seats >= 15);
});
