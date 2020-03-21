import { element } from "protractor";
import { Page } from "./../../common/page";
import { Component, OnInit, Input } from "@angular/core";

@Component({
  selector: "app-footer-pagination",
  templateUrl: "./footer-pagination.component.html",
  styleUrls: ["./footer-pagination.component.css"]
})
export class FooterPaginationComponent implements OnInit {
  @Input() page: Page;
  constructor() {}

  ngOnInit() {}

  get firstItemNumber() {
    return this.page.number + 1;
  }

  get lastItemNumber() {
    return (this.page.number + 1) * this.page.size;
  }

  get totalItens() {
    return this.page.totalElements;
  }
}
