import {Component, Input} from '@angular/core';
import {Product} from '../../models/Product';
import {AddWinkelmandComponent} from '../../add-winkelmand/add-winkelmand.component';
import {RouterLink} from '@angular/router';
import {TranslatePipe} from "@ngx-translate/core";

@Component({
  selector: 'app-product-items',
    imports: [
        AddWinkelmandComponent,
        RouterLink,
        TranslatePipe
    ],
  templateUrl: './product-items.component.html',
  styleUrl: './product-items.component.scss'
})
export class ProductItemsComponent {
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
    return this.product.boekID;
  }
}
