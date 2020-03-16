"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Rectangle_1 = require("./Rectangle");
var Circle_1 = require("./Circle");
var listShape = [];
listShape.push(new Circle_1.Circle(0, 0, 5));
listShape.push(new Rectangle_1.Rectangle(10, 10, 20, 30));
listShape.forEach(function (shape) {
    console.log(shape.getInfo());
    console.log(shape.calculateArea());
});
