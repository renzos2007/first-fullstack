import {RouterModule, Routes} from '@angular/router';
import {HomepageComponent} from './homepage/homepage.component';
import {ProductDetailsComponent} from './product-details/product-details.component';
import {NgModule} from '@angular/core';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './login/register/register.component';
import { DifficultyListComponent } from './difficulty-list/difficulty-list.component';
import { ProductAllDifficultyListComponent } from './difficulty-list/product-all-difficulty-list/product-all-difficulty-list';
import { ProductsDifficultyListComponent } from './difficulty-list/product-difficulty-list/product-difficulty-list.component';
import { UserDataComponent } from './userData/user-data.component';
import { CartPageComponent } from './cart-page/cart-page.component';
import { PaymentPageComponent } from './cart-page/payment-page/payment-page.component';

export const routes: Routes = [
  {
    path: '',
    component: HomepageComponent,
  },
  {
    path:'cart',
    component: CartPageComponent,
  },
  {
    path:'product/:id',
    component: ProductDetailsComponent,
  },
  {
    path:'difficulty',
    component: DifficultyListComponent,
  },
  {
    path:'difficulty/:id',
    component: ProductsDifficultyListComponent,
  },
  {
    path:'difficulty/product/all',
    component: ProductAllDifficultyListComponent,
  },
  {
    path:'user',
    component: UserDataComponent,
  },
  {
    path:'login',
    component: LoginComponent,
  },
  {
    path:'register',
    component: RegisterComponent,
  },
  {
    path: 'payment',
    component: PaymentPageComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
