import {Component, OnInit} from '@angular/core';
import {ProductItemSectionComponent} from './product-item-section/product-item-section.component';
import {ProductService} from '../../services/product.service';
import {Product} from '../../models/Product';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-product-list-section',
  imports: [
    ProductItemSectionComponent,
    CommonModule,
  ],
  templateUrl: './product-list-section.component.html',
  styleUrl: './product-list-section.component.scss'
})
export class ProductListSectionComponent implements OnInit {
  protected products: Product[] = [];

  constructor(private productService: ProductService) { }

  public get limitedProducts(): Product[] {
    return this.products.slice(0, 6);
  }

  ngOnInit(): void {
    this.productService.getProducts().subscribe(products => {this.products = products})
  }


}

