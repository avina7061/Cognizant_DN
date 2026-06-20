// Event Class

class Event {
  constructor(name, category, date, seats) {
    this.name = name;
    this.category = category;
    this.date = date;
    this.seats = seats;
  }
}

// Prototype Method

Event.prototype.checkAvailability = function () {
  if (this.seats > 0) {
    return `Seats Available: ${this.seats}`;
  }

  return "Event Full";
};

// Create Event Objects

const event1 = new Event("Tech Meetup", "Technology", "15 July 2026", 20);

const event2 = new Event("Community Cleanup", "Social", "20 July 2026", 0);

// Check Availability

console.log("Event Availability");
console.log("------------------");

console.log(`${event1.name}: ${event1.checkAvailability()}`);

console.log(`${event2.name}: ${event2.checkAvailability()}`);

// Object.entries()

console.log("\nEvent 1 Details");
console.log("----------------");

Object.entries(event1).forEach(([key, value]) => {
  console.log(`${key}: ${value}`);
});
