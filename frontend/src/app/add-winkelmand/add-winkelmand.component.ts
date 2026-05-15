import {Component, EventEmitter, Input, Output} from '@angular/core';
import {WinkelmandService} from '../services/winkelmand.service';
import {Product} from '../models/Product';
import {FormsModule} from '@angular/forms';
import {TranslatePipe} from '@ngx-translate/core';

@Component({
  selector: 'app-add-winkelmand',
  imports: [
    FormsModule,
    TranslatePipe
  ],
  templateUrl: './add-winkelmand.component.html',
  styleUrl: './add-winkelmand.component.scss'
})
export class AddWinkelmandComponent {
  @Output() cancel = new EventEmitter<void>();
  @Input() product!: Product;

  protected hoeveelheidItem: number = 1;


  constructor(private winkelmandService: WinkelmandService) {
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
    this.winkelmandService.addProduct(this.product, this.hoeveelheidItem);
    this.cancel.emit();
  }
}
