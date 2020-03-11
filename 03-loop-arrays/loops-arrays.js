var reviews = [5, 4, 6, 5.6, 9, 3];
var total = 0;
for (var i = 0; i < reviews.length; i++) {
    console.log(reviews[i]);
    total += reviews[i];
}
var average = total / reviews.length;
console.log("Reviews average: " + average);
var sports = ["Golf", "Soccer", "Tennis"];
for (var _i = 0, sports_1 = sports; _i < sports_1.length; _i++) {
    var sport = sports_1[_i];
    console.log(sport);
}
var sportsTwo = ["Golf", "Cricket"];
sportsTwo.push("Baseballl");
sportsTwo.push("Soccer");
for (var _a = 0, sportsTwo_1 = sportsTwo; _a < sportsTwo_1.length; _a++) {
    var sport = sportsTwo_1[_a];
    console.log(sport);
}
