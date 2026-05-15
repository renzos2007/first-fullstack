import { Component } from '@angular/core';
import {ProductListComponent} from './product-list/product-list.component';
import {InfoHomepage} from './info-homepage/info-homepage';

@Component({
  selector: 'app-homepage',
  imports: [
    ProductListComponent,
    InfoHomepage
  ],
  templateUrl: './homepage.component.html',
  styleUrl: './homepage.component.scss'
})
export class HomepageComponent {

}
