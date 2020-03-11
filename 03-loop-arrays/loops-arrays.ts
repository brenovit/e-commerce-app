let reviews: number[] = [5, 4, 6, 5.6, 9, 3];
let total: number = 0;
for (let i = 0; i < reviews.length; i++) {
    console.log(reviews[i]);
    total += reviews[i];
}
let average: number = total / reviews.length;
console.log("Reviews average: " + average);

let sports: string[] = ["Golf", "Soccer", "Tennis"];
for (let sport of sports) {
    console.log(sport);
}

let sportsTwo: string[] = ["Golf", "Cricket"];

sportsTwo.push("Baseballl");
sportsTwo.push("Soccer");
for (const sport of sportsTwo) {
    console.log(sport);
}