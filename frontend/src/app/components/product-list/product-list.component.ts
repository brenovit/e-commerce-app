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
  currentCategoryId: number = 1;
  previousCategoryId: number = 1;
  currentCategoryName: string;
  searchMode: boolean = false;

  thePageNumber: number = 1;
  thePageSize: number = 8;
  theTotalElements: number = 0;

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe(() => {
      this.listProducts();
    });
  }

  public listProducts() {
    const searchProduct: Product = this.filterRouteParametersToProduct();

    if (this.currentCategoryId != this.previousCategoryId) {
      this.thePageNumber = 1;
    }

    this.previousCategoryId = this.currentCategoryId;

    this.handleListProduct(
      this.thePageSize,
      this.thePageNumber - 1,
      searchProduct
    );
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
      .subscribe(this.processResult());
  }

  private processResult() {
    return data => {
      this.products = data.content;
      this.page = data.page;
      this.thePageNumber = data.page.number + 1;
      this.thePageSize = data.page.size;
      this.theTotalElements = data.page.totalElements;
    };
  }
}
