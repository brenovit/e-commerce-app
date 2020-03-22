import { Page } from "./../../common/page";
import { Component, OnInit } from "@angular/core";
import { Product } from "src/app/common/product";
import { ProductService } from "src/app/services/product.service";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-product-list",
  templateUrl: "./product-list.component.html",
  styleUrls: ["./product-list.component.css"]
})
export class ProductListComponent implements OnInit {
  products: Product[];
  page: Page;
  currentCategoryId: number;
  currentCategoryName: string;

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe(() => {
      this.listProducts();
    });
  }

  listProducts() {
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has("id");
    if (hasCategoryId) {
      this.currentCategoryId = +this.route.snapshot.paramMap.get("id");
      this.currentCategoryName = this.route.snapshot.paramMap.get("name");
      this.productService
        .getProductListByCategoryId(this.currentCategoryId)
        .subscribe(data => {
          this.products = data.content;
          this.page = data.page;
        });
    } else {
      this.productService.getProductList().subscribe(data => {
        this.products = data.content;
        this.page = data.page;
      });
    }
  }
}
