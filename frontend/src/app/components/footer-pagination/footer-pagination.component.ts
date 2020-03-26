import { Router } from "@angular/router";
import { Page } from "./../../common/page";
import { Component, OnInit, Input, AfterViewInit } from "@angular/core";

@Component({
  selector: "app-footer-pagination",
  templateUrl: "./footer-pagination.component.html",
  styleUrls: ["./footer-pagination.component.css"]
})
export class FooterPaginationComponent implements OnInit {
  @Input() page: Page;
  @Input() context: string;
  itensPerPageSize: number[];
  currentSize: number;

  constructor(private router: Router) {
    this.itensPerPageSize = [8, 16, 24, 32];
  }

  ngOnInit() {
    this.currentSize = this.page.size;
  }

  refreshItemPerPageValue() {
    this.router.navigateByUrl("/", { skipLocationChange: true }).then(() =>
      this.router.navigate([`/${this.context}`], {
        queryParams: { size: this.currentSize }
      })
    );
  }

  get previousPage() {
    if (this.page.number > 0) {
      return this.page.number - 1;
    }

    return 0;
  }

  get nextPage() {
    if (this.page.number < this.page.totalPages) {
      return this.page.number + 1;
    }

    return this.page.totalPages;
  }

  get firstItemNumber() {
    if (this.page === undefined) {
      return 0;
    }
    return this.lastItemNumber - this.page.size + 1;
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
