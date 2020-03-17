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
    new SalesPerson("Ramar", "Frenco", "email2@email.com", 100000),
    new SalesPerson("Jamar", "Frinco", "email3@email.com", 4000),
    new SalesPerson("Tamar", "Fronco", "email4@email.com", 100),
    new SalesPerson("Zamar", "Frunco", "email5@email.com", 498940)
  ];

  constructor() {}

  ngOnInit() {}
}
