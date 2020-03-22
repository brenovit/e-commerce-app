import { ProductList } from "./../common/product-list";
import { Page } from "./../common/page";
import { Observable } from "rxjs";
import { Product } from "../common/product";
import { map } from "rxjs/operators";
import { ApiService } from "./api-service";

export class ProductService extends ApiService {
  getProductList(): Observable<ProductList> {
    return this.httpClient
      .get<GetResponse>(this.getUrl("v1/products?page=1&size=8"))
      .pipe(map(response => response));
  }

  getProductListByCategoryId(categoryId: number): Observable<ProductList> {
    return this.httpClient
      .get<GetResponse>(
        this.getUrl(`v1/products?page=1&size=8&categoryId=${categoryId}`)
      )
      .pipe(map(response => response));
  }
}

interface GetResponse {
  content: Product[];
  page: Page;
}
