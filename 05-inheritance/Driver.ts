import { Rectangle } from "./Rectangle";
import { Circle } from "./Circle";
import { Shape } from "./Shape";

let myShape = new Shape(10, 15);
console.log(myShape.getInfo());

let myCircle = new Circle(0, 0, 5);
console.log(myCircle.getInfo());

let myRectangle = new Rectangle(10, 10, 20, 30);
console.log(myRectangle.getInfo());
