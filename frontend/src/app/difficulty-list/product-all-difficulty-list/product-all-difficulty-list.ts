import {Component, OnInit} from '@angular/core';
import {Product} from '../../models/Product';
import {ProductService} from '../../services/product.service';
import {TranslatePipe} from '@ngx-translate/core';
import {RouterLink} from '@angular/router';
import { ProductDifficultyItemComponent } from '../product-difficulty-item/product-difficulty-item.component';

@Component({
  selector: 'app-all-products',
  imports: [
    ProductDifficultyItemComponent,
    TranslatePipe,
    RouterLink
  ],
  templateUrl: './product-all-difficulty-list.component.html',
  styleUrl: './product-all-difficulty-list.component.scss'
})
export class ProductAllDifficultyListComponent implements OnInit {
  protected products: Product[] = []

  protected currentPage: number = 1;
  protected itemsPerPage: number = 10;

  constructor(private productService: ProductService) {};

  ngOnInit(): void {
    this.productService.getProducts().subscribe(products => {this.products = products})
  }

  public get paginatedProducts(): Product[] {
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    return this.products.slice(startIndex, startIndex + this.itemsPerPage);
  }

  public nextPage(): void {
    if (this.currentPage * this.itemsPerPage < this.products.length) {
      this.currentPage++;
    }
  }

  public previousPage(): void {
    if (this.currentPage > 1) {
      this.currentPage--;
    }
  }

  public get totalPages(): number {
    return Math.ceil(this.products.length / this.itemsPerPage);
  }
}
