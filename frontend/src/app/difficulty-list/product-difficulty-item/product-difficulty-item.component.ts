import {Component, Input} from '@angular/core';
import {Product} from '../../models/Product';
import {AddCartComponent} from '../../add-cart/add-cart.component';
import {RouterLink} from '@angular/router';
import {TranslatePipe} from "@ngx-translate/core";

@Component({
  selector: 'app-product-difficulty-item',
    imports: [
        AddCartComponent,
        RouterLink,
        TranslatePipe
    ],
  templateUrl: './product-difficulty-item.component.html',
  styleUrl: './product-difficulty-item.component.scss'
})
export class ProductDifficultyItemComponent {
  @Input({required: true}) product!: Product;
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
