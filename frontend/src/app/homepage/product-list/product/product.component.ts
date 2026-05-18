import {Component, Input} from '@angular/core';
import {AddCartComponent} from '../../../add-cart/add-cart.component';

import { Product } from '../../../models/Product';
import {RouterLink} from '@angular/router';
import {TranslatePipe} from "@ngx-translate/core";
import {filter} from 'rxjs';

@Component({
  selector: 'app-product',
    imports: [
        AddCartComponent,
        RouterLink,
        TranslatePipe
    ],
  templateUrl: './product.component.html',
  styleUrl: './product.component.scss'
})
export class ProductComponent {
  @Input({required:true}) product!: Product;
  protected isAddingItem = false;

  constructor() {}

  public onStartAddItem($event: MouseEvent): void{
    $event.preventDefault();
    $event.stopPropagation();
    this.isAddingItem = true;
  }

  public onCancelAddItem(): void{
    this.isAddingItem = false;
  }

  public getProductID(): number {
    return this.product.productID;
  }
}
