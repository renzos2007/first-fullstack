import {RouterModule, Routes} from '@angular/router';
import {HomepageComponent} from './homepage/homepage.component';
import {WinkelmandComponent} from './winkelmand/winkelmand.component';
import {ProductDetailsComponent} from './product-details/product-details.component';
import {NgModule} from '@angular/core';
import {GebruikergegevensComponent} from './gebruikergegevens/gebruikergegevens.component';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './login/register/register.component';
import {BetalenComponent} from './winkelmand/betalen/betalen.component';
import { DifficultyListComponent } from './difficulty-list/difficulty-list.component';
import { ProductAllDifficultyListComponent } from './difficulty-list/product-all-difficulty-list/product-all-difficulty-list';
import { ProductsDifficultyListComponent } from './difficulty-list/product-difficulty-list/product-difficulty-list.component';

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
