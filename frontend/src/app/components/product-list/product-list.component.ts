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

  private listProducts() {
    const searchProduct: Product = this.filterRouteParametersToProduct();
    let size: number = 8;
    if (this.route.snapshot.queryParamMap.has("size")) {
      size = +this.route.snapshot.queryParamMap.get("size");
    }
    let page: number = 0;
    if (this.route.snapshot.queryParamMap.has("page")) {
      page = +this.route.snapshot.queryParamMap.get("page");
    }
    this.handleListProduct(size, page, searchProduct);
  }

  private filterRouteParametersToProduct(): Product {
    let searchProduct: Product = new Product();
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
    return searchProduct;
  }

  private handleListProduct(
    size: number,
    page: number,
    searchProduct: Product
  ) {
    this.productService
      .getProducts(size, page, searchProduct)
      .subscribe(data => {
        this.products = data.content;
        this.page = data.page;
      });
  }
}
