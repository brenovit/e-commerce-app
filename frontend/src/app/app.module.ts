import { AuthService } from "src/app/services/auth.service";
import { AuthInterceptorProviders } from "./_helpers/auth.interceptor";
import { RegisterComponent } from "./components/register/register.component";
import { LoginComponent } from "./components/login/login.component";
import { ProductDetailsComponent } from "./components/product-details/product-details.component";
import { ProductSearchComponent } from "./components/product-search/product-search.component";
import { ProductMenuComponent } from "./components/product-menu/product-menu.component";
import { ProductCategoryComponent } from "./components/product-category/product-category.component";
import { ProductCategoryService } from "./services/product-category.service";
import { FooterPaginationComponent } from "./components/footer-pagination/footer-pagination.component";
import { ProductListItemComponent } from "./components/product-list-item/product-list-item.component";
import { ProductService } from "./services/product.service";
import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";

import { AppComponent } from "./app.component";
import { ProductListComponent } from "./components/product-list/product-list.component";
import { HttpClientModule } from "@angular/common/http";
import { Routes, RouterModule } from "@angular/router";
import { TokenStorageService } from "./services/token-storage.service";

const routes: Routes = [
  { path: "category/:id/:name", component: ProductListComponent },
  { path: "login", component: LoginComponent },
  { path: "register", component: RegisterComponent },
  { path: "category", component: ProductListComponent },
  { path: "products", component: ProductListComponent },
  { path: "products/:id", component: ProductDetailsComponent },
  { path: "search/:keyword", component: ProductListComponent },
  { path: "", redirectTo: "/products", pathMatch: "full" },
  { path: "**", redirectTo: "/products", pathMatch: "full" }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    ProductListComponent,
    ProductListItemComponent,
    ProductDetailsComponent,
    ProductMenuComponent,
    ProductCategoryComponent,
    ProductSearchComponent,
    FooterPaginationComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    AuthService,
    ProductService,
    ProductCategoryService,
    TokenStorageService,
    AuthInterceptorProviders
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
