import {Component, inject, OnInit} from '@angular/core';
import {RouterLink} from '@angular/router';
import {ProductService} from '../../services/product.service';
import {Product} from '../../models/Product';
import {TranslatePipe} from '@ngx-translate/core';

@Component({
  selector: 'app-info-section',
  imports: [
    RouterLink,
    TranslatePipe
  ],
  templateUrl: './info-section.component.html',
  styleUrl: './info-section.component.scss'
})
export class InfoSectionComponent implements OnInit {
  private productService = inject(ProductService);

  private products: Product[] = [];
  protected bestSellers: Product[] = [];
  protected index: number = 0;

  ngOnInit(): void {
    this.productService.getProducts().subscribe(products => {
      this.products = products;

      this.bestSellers = [];
      for (let product of this.products) {
        if (product.bestSeller === true) {
          this.bestSellers.push(product);
        }
      }
    });
  }

  public previousBestSeller():void {
    if (this.bestSellers.length > 0) {
      this.index = (this.index - 1 + this.bestSellers.length) % this.bestSellers.length;
    }
  }

  public nextBestSeller(): void {
    if (this.bestSellers.length > 0) {
      this.index = (this.index + 1) % this.bestSellers.length;
    }
  }
}
