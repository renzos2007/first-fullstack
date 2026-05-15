import {RouterModule, Routes} from '@angular/router';
import {HomepageComponent} from './homepage/homepage.component';
import {WinkelmandComponent} from './winkelmand/winkelmand.component';
import {ProductDetailsComponent} from './product-details/product-details.component';
import {FilterlistComponent} from './filterlist/filterlist.component';
import {ProductsNiveauComponent} from './filterlist/products-niveau/products-niveau.component';
import {AllProductsComponent} from './filterlist/all-products/all-products.component';
import {NgModule} from '@angular/core';
import {GebruikergegevensComponent} from './gebruikergegevens/gebruikergegevens.component';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './login/register/register.component';
import {BetalenComponent} from './winkelmand/betalen/betalen.component';

export const routes: Routes = [
  {
    path: '',
    component: HomepageComponent,
  },
  {
    path:'winkelmand',
    component: WinkelmandComponent,
  },
  {
    path:'product/:id',
    component: ProductDetailsComponent,
  },
  {
    path:'niveau',
    component: FilterlistComponent,
  },
  {
    path:'niveau/:id',
    component: ProductsNiveauComponent,
  },
  {
    path:'niveau/boeken/alles',
    component: AllProductsComponent,
  },
  {
    path:'gebruiker',
    component: GebruikergegevensComponent,
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
    path: 'betalen',
    component: BetalenComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
