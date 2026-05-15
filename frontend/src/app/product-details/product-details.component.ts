import {Component, OnInit} from '@angular/core';
import  {ActivatedRoute} from '@angular/router';
import {Product} from '../models/Product';
import {ProductService} from '../services/product.service';
import {catchError, of} from 'rxjs';
import {AddWinkelmandComponent} from '../add-winkelmand/add-winkelmand.component';
import {NgForOf, NgIf} from '@angular/common';
import {TranslatePipe} from "@ngx-translate/core";


@Component({
  selector: 'app-product-details',
    imports: [
        AddWinkelmandComponent,
        NgForOf,
        NgIf,
        TranslatePipe
    ],
  templateUrl: './product-details.component.html',
  styleUrl: './product-details.component.scss'
})
export class ProductDetailsComponent  implements OnInit {
  protected boekID: number | null = null;
  protected product: Product | null = null;

  protected isAddingItem = false;

  constructor(private route: ActivatedRoute, private productService: ProductService) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id = params.get('id');
      this.boekID = id ? Number(id) : null;

      if (this.boekID !== null) {
        this.productService.getProductByID(this.boekID).pipe(
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
