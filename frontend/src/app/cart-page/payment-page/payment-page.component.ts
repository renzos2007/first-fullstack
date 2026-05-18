import {Component, EventEmitter, inject, OnInit, Output} from '@angular/core';
import {CartProduct} from '../../models/CartProduct';
import {CartService} from '../../services/cart.service';
import {FormsModule} from '@angular/forms';
import {NgIf} from '@angular/common';
import {Router} from '@angular/router';
import {TranslatePipe} from '@ngx-translate/core';
import {LoginService} from '../../services/login.service';

@Component({
  selector: 'app-payment-page',
  imports: [
    FormsModule,
    NgIf,
    TranslatePipe
  ],
  templateUrl: './payment-page.component.html',
  styleUrl: './payment-page.component.scss'
})
export class PaymentPageComponent implements OnInit {
  private router = inject(Router);
  protected ProductOrderList: CartProduct[] = [];
  protected chosenPaymentMethod: string = '';
  protected paymentMethodChosen: boolean = false;
  protected isPayed: boolean = false;


  constructor(private cartService: CartService, private loginService: LoginService) {}

  ngOnInit(): void {
    if (!this.loginService.isLoggedIn()) {
      this.router.navigate(['/']);
    }

    this.ProductOrderList = this.cartService.getProducts();

    if (this.ProductOrderList.length <= 0) {
      this.router.navigate(['/cart']);
    }

    const savedCart = localStorage.getItem('cart_products');
    if (savedCart) {
      this.ProductOrderList = JSON.parse(savedCart);
    } else {
      this.ProductOrderList = [];
    }
  }

  public getTotalPrice(): number {
    let totaalPrijsWinkelwagen = 0;
    for (let i = 0; i < this.ProductOrderList.length; i++) {
      let totaalPrijsProduct = this.ProductOrderList[i].price * this.ProductOrderList[i].amount;
      totaalPrijsWinkelwagen += totaalPrijsProduct;
    }
    return parseFloat(totaalPrijsWinkelwagen.toFixed(2));
  }

  public verwerkBetaling(): void {
    if (this.chosenPaymentMethod) {
      console.log(`Betaling verwerkt met ${this.chosenPaymentMethod}`);
      this.paymentMethodChosen = true;
      this.isPayed = true;
      this.router.navigate(['/cart'], { queryParams: { isPayed: this.isPayed } });
    } else {
      this.paymentMethodChosen = false;
    }
  }

  public cancelPayment(): void {
    this.chosenPaymentMethod = '';
    this.paymentMethodChosen = false;
    this.isPayed = false;
    this.router.navigate(['/cart'], { queryParams: { isPayed: this.isPayed } });
  }
}
