// Community Events Array

const events = [
  {
    name: "Music Night",
    category: "Music",
  },

  {
    name: "Baking",
    category: "Workshop",
  },

  {
    name: "Tech Meetup",
    category: "Technology",
  },
];

// Add New Events Using push()

events.push({
  name: "Classical Concert",
  category: "Music",
});

events.push({
  name: "Photography Workshop",
  category: "Workshop",
});

console.log("All Events");
console.log("----------");

events.forEach((event) => {
  console.log(`${event.name} (${event.category})`);
});

// Filter Music Events

const musicEvents = events.filter((event) => event.category === "Music");

console.log("\nMusic Events");
console.log("------------");

musicEvents.forEach((event) => {
  console.log(event.name);
});

// Format Display Cards Using map()

const displayCards = events.map((event) => {
  if (event.category === "Workshop") {
    return `Workshop on ${event.name}`;
  }

  return `${event.name} Event`;
});

console.log("\nFormatted Display Cards");
console.log("-----------------------");

displayCards.forEach((card) => {
  console.log(card);
});
