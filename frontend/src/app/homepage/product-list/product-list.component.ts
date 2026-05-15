import {Component, OnInit} from '@angular/core';
import {ProductComponent} from './product/product.component';
import {ProductService} from '../../services/product.service';
import {Product} from '../../models/Product';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-product-list',
  imports: [
    ProductComponent,
    CommonModule,
  ],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.scss'
})
export class ProductListComponent implements OnInit {
  protected products: Product[] = [];

  constructor(private productService: ProductService) { }

  public get limitedProducts(): Product[] {
    return this.products.slice(0, 6);
  }

  ngOnInit(): void {
    this.productService.getProducts().subscribe(products => {this.products = products})
  }


}

