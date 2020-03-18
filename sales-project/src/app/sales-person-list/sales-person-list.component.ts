import { Component, OnInit } from "@angular/core";
import { SalesPerson } from "./sales-person";

@Component({
  selector: "app-sales-person-list",
  templateUrl: "./sales-person-list.component.html",
  styleUrls: ["./sales-person-list.component.css"]
})
export class SalesPersonListComponent implements OnInit {
  salesPersonList: SalesPerson[] = [
    new SalesPerson("Lamar", "Franco", "email1@email.com", 50000),
    new SalesPerson("Xavier", "Eyed", "email2@email.com", 100000),
    new SalesPerson("Juanda", "Murphy", "email3@email.com", 4000),
    new SalesPerson("Patricia", "Lutiela", "email4@email.com", 100),
    new SalesPerson("Lucio", "Djaka", "email5@email.com", 498940)
  ];

  constructor() {}

  ngOnInit() {}
}
