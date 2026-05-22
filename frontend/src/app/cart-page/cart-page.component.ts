import {Component, inject, Input} from '@angular/core';
import {CartService} from '../services/cart.service';
import {CartProduct} from '../models/CartProduct';
import {UserDataService} from '../services/userData';
import {catchError, throwError} from 'rxjs';
import {ActivatedRoute, Router} from '@angular/router';
import { ChangeDetectorRef } from '@angular/core';
import {TranslatePipe} from '@ngx-translate/core';
import {AuthenticationService} from '../services/authentication.service';

@Component({
  selector: 'app-cart-page',
  imports: [
    TranslatePipe
  ],
  templateUrl: './cart-page.component.html',
  styleUrl: './cart-page.component.scss'
})
export class CartPageComponent {
  private router = inject(Router);
  private authenticationService =  inject(AuthenticationService);
  private cartService = inject(CartService);
  private userDataService = inject(UserDataService);
  private route = inject(ActivatedRoute);
  private cdr = inject(ChangeDetectorRef);
  
  protected ProductOrderList: CartProduct[];
  protected isPayed: boolean = false;

  constructor() {
    this.ProductOrderList = this.cartService.getProducts();

    const savedCart = localStorage.getItem('cart_products');
    if (savedCart) {
      this.ProductOrderList = JSON.parse(savedCart);
    } else {
      this.ProductOrderList = []
    }

    this.route.queryParams.subscribe(params => {
      this.isPayed = params['isPayed'] === 'true';
    });
  }

  public getOrderList(): CartProduct[] {
    return this.ProductOrderList;
  }

  public clearOrderList(): void {
    this.ProductOrderList = [];
    this.cartService.setProducts(this.ProductOrderList);
    this.cartService.updateLocalStorage();
    this.cdr.detectChanges();
  }

  public getTotalPrice(): number {
    let totalPriceCart = 0;
    for (let i = 0; i < this.ProductOrderList.length; i++) {
      let totalPriceProduct = this.ProductOrderList[i].price * this.ProductOrderList[i].amount;
      totalPriceCart += totalPriceProduct;
    }
    return parseFloat(totalPriceCart.toFixed(2));
  }

  public paymentPage(): void {
    this.userDataService.getUserData().pipe(
      catchError(error => {
        if (error.status === 401) {
          this.authenticationService.setErrorType(error.status);
          this.router.navigate(['/login']);
        }
        return throwError(() => error);
      })
    ).subscribe()
    this.router.navigate(['/payment']);
  }

  public createOrder(): void {
    let productData = this.ProductOrderList.map(product => ({
      productID: product.productID,
      amount: product.amount < 1 ? 1 : product.amount
    }));

    this.cartService.createOrder(productData);
    
    this.isPayed = false;
    this.clearOrderList()
    this.router.navigate(['/']);
    alert("Bestelling is geplaatst")
  };
}
