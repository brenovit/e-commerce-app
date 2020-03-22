import { element } from "protractor";
import { Page } from "./../../common/page";
import { Component, OnInit, Input, AfterViewInit } from "@angular/core";

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
    if (this.page === undefined) {
      return 0;
    }
    return this.page.number + 1;
  }

  get lastItemNumber() {
    if (this.page === undefined) {
      return 0;
    }
    return (this.page.number + 1) * this.page.size;
  }

  get totalItens() {
    if (this.page === undefined) {
      return 0;
    }
    return this.page.totalElements;
  }
}
