import { ProductList } from "./../common/product-list";
import { Page } from "./../common/page";
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Product } from "../common/product";
import { map } from "rxjs/operators";

@Injectable({
  providedIn: "root"
})
export class ProductService {
  private baseUrl = "http://localhost:8181/ecommerce/api/";

  constructor(private httpClient: HttpClient) {}

  private getUrl(endpoint) {
    return `${this.baseUrl}${endpoint}`;
  }

  getProductList(): Observable<ProductList> {
    return this.httpClient
      .get<GetResponse>(this.getUrl("v1/products?page=1&size=8"))
      .pipe(map(response => response));
  }

  getProductListByCategoryId(categoryId: number): Observable<ProductList> {
    return this.httpClient
      .get<GetResponse>(this.getUrl(`v1/products/category/${categoryId}`))
      .pipe(map(response => response));
  }
}

interface GetResponse {
  content: Product[];
  page: Page;
}
