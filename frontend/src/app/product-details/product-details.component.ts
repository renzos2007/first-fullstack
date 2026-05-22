import {Component, inject, OnInit} from '@angular/core';
import  {ActivatedRoute} from '@angular/router';
import {Product} from '../models/Product';
import {ProductService} from '../services/product.service';
import {catchError, of} from 'rxjs';
import {AddCartComponent} from '../add-cart/add-cart.component';
import {NgForOf, NgIf} from '@angular/common';
import {TranslatePipe} from "@ngx-translate/core";


@Component({
  selector: 'app-product-details',
    imports: [
        AddCartComponent,
        NgForOf,
        NgIf,
        TranslatePipe
    ],
  templateUrl: './product-details.component.html',
  styleUrl: './product-details.component.scss'
})
export class ProductDetailsComponent  implements OnInit {
  private route = inject(ActivatedRoute);
  private productService = inject(ProductService);

  protected productID: number | null = null;
  protected product: Product | null = null;
  protected isAddingItem = false;

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id = params.get('id');
      this.productID = id ? Number(id) : null;

      if (this.productID !== null) {
        this.productService.getProductByID(this.productID).pipe(
          catchError(error => {
            console.log(error);
            return of(null);
          })
        ).subscribe(product => {
          this.product = product;
        });
      } else {
        console.error('Invalid ID:', id);
      }
    });
  }

  public onStartAddItem(): void{
    this.isAddingItem = true;
  }

  public onCancelAddItem(): void{
    this.isAddingItem = false;
  }
}
