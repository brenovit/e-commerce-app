import { Rectangle } from "./Rectangle";
import { Circle } from "./Circle";
import { Shape } from "./Shape";

let listShape: Shape[] = [];

listShape.push(new Circle(0, 0, 5));
listShape.push(new Rectangle(10, 10, 20, 30));

listShape.forEach(shape => {
  console.log(shape.getInfo());
  console.log(shape.calculateArea());
});
