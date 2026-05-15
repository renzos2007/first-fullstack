import {Component, OnInit} from '@angular/core';
import {RouterLink} from '@angular/router';
import {ProductService} from '../../services/product.service';
import {Product} from '../../models/Product';
import {NgIf} from '@angular/common';
import {TranslatePipe} from '@ngx-translate/core';

@Component({
  selector: 'app-info-homepage',
  imports: [RouterLink, NgIf, TranslatePipe],
  templateUrl: './info-homepage.html',
  styleUrl: './info-homepage.scss'
})
export class InfoHomepage implements OnInit {

  private products: Product[] = [];
  protected bestSellers: Product[] = [];
  protected index: number = 0;


  constructor(private productService: ProductService) {
  }

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
