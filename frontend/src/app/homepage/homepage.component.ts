import { Component } from '@angular/core';
import {InfoSectionComponent} from './info-section/info-section.component';
import { ProductListSectionComponent } from './product-list-section/product-list-section.component';

@Component({
  selector: 'app-homepage',
  imports: [
    InfoSectionComponent,
    ProductListSectionComponent
],
  templateUrl: './homepage.component.html',
  styleUrl: './homepage.component.scss'
})
export class HomepageComponent {
}
