import {Component, Input} from '@angular/core';
import {AddCartComponent} from '../../../add-cart/add-cart.component';

import { Product } from '../../../models/Product';
import {RouterLink} from '@angular/router';
import {TranslatePipe} from "@ngx-translate/core";
import {filter} from 'rxjs';

@Component({
  selector: 'app-product-item-section',
    imports: [
        AddCartComponent,
        RouterLink,
        TranslatePipe
    ],
  templateUrl: './product-item-section.component.html',
  styleUrl: './product-item-section.component.scss'
})
export class ProductItemSectionComponent {
  @Input({required:true}) product!: Product;
  protected isAddingItem = false;

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
