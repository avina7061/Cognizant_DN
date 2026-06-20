$(document).ready(function () {
  // Click Event

  $("#registerBtn").click(function () {
    alert("Successfully Registered!");
  });

  // fadeOut()

  $("#hideBtn").click(function () {
    $(".event-card").fadeOut();
  });

  // fadeIn()

  $("#showBtn").click(function () {
    $(".event-card").fadeIn();
  });

  // Framework Benefit

  $("#frameworkBenefit").text(
    "React and Vue make UI development easier through reusable components and better state management.",
  );
});
