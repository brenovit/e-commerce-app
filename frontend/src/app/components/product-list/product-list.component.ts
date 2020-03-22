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
    const searchProduct: Product = new Product();
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has("id");
    const hasSearchKeyword: boolean = this.route.snapshot.paramMap.has(
      "keyword"
    );

    if (hasSearchKeyword) {
      const keyword = this.route.snapshot.paramMap.get("keyword");
      searchProduct.name = keyword;
    } else if (hasCategoryId) {
      this.currentCategoryId = +this.route.snapshot.paramMap.get("id");
      this.currentCategoryName = this.route.snapshot.paramMap.get("name");
      searchProduct.categoryId = this.currentCategoryId;
    }

    this.productService.getProducts(searchProduct).subscribe(data => {
      this.products = data.content;
      this.page = data.page;
    });
  }
}
