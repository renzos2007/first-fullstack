import {Component, EventEmitter, Input, Output} from '@angular/core';
import {CartService} from '../services/cart.service';
import {Product} from '../models/Product';
import {FormsModule} from '@angular/forms';
import {TranslatePipe} from '@ngx-translate/core';

@Component({
  selector: 'app-add-cart',
  imports: [
    FormsModule,
    TranslatePipe
  ],
  templateUrl: './add-cart.component.html',
  styleUrl: './add-cart.component.scss'
})
export class AddCartComponent {
  @Output() cancel = new EventEmitter<void>();
  @Input() product!: Product;

  protected hoeveelheidItem: number = 1;


  constructor(private cartService: CartService) {
  }

  public onAdd(): void {
    this.hoeveelheidItem += 1;
  }

  public onMinus(): void {
    if (this.hoeveelheidItem > 1) {
      this.hoeveelheidItem -= 1;
    }
  }

  public onCancel(): void {
    this.hoeveelheidItem = 0;
    this.cancel.emit();
  }

  public onSubmit(event: Event): void {
    event.preventDefault();
    this.cartService.addProduct(this.product, this.hoeveelheidItem);
    this.cancel.emit();
  }
}
