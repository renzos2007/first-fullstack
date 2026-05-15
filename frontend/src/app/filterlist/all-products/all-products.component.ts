import {Component, OnInit} from '@angular/core';
import {Product} from '../../models/Product';
import {ProductService} from '../../services/product.service';
import {ProductItemsComponent} from '../product-items/product-items.component';
import {TranslatePipe} from '@ngx-translate/core';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-all-products',
  imports: [
    ProductItemsComponent,
    TranslatePipe,
    RouterLink
  ],
  templateUrl: './all-products.component.html',
  styleUrl: './all-products.component.scss'
})
export class AllProductsComponent implements OnInit {
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
