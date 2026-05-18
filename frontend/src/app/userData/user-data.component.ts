import {Component, OnInit} from '@angular/core';
import {UserData} from '../models/UserData';
import {UserDataService} from '../services/userData';
import {of} from 'rxjs';
import {CurrencyPipe, DatePipe, NgForOf, NgIf, ViewportScroller} from '@angular/common';
import {TranslatePipe} from '@ngx-translate/core';
import {LoginService} from '../services/login.service';
import {Router} from '@angular/router';
import {OrderData} from '../models/OrderData';

@Component({
  selector: 'app-user-data',
  imports: [
    NgForOf,
    DatePipe,
    TranslatePipe,
  ],
  templateUrl: './user-data.component.html',
  styleUrl: './user-data.component.scss'
})
export class UserDataComponent implements OnInit {
  protected userData?: UserData;
  protected currentPage: number = 1;
  protected itemsPerPage: number = 10;

  constructor(private userDataService: UserDataService, protected loginService: LoginService, private viewportScroller: ViewportScroller, private router: Router) {
  }

  ngOnInit(): void {
    if (!this.loginService.isLoggedIn()) {
      this.router.navigate(['/login']);
    }

    this.userDataService.getUserData().subscribe(userData => {
      this.userData = userData;
    })
  }
  public get paginatedOrders(): OrderData[] {
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    return this.userData?.orderData.slice(startIndex, startIndex + this.itemsPerPage) || [];
  }

  public nextPage(): void {
    if (this.userData && this.userData.orderData &&
      (this.currentPage * this.itemsPerPage < this.userData.orderData.length)) {
      this.currentPage++;
      this.viewportScroller.scrollToPosition([0, 0]);
    }
  }

  public previousPage(): void {
    if (this.currentPage > 1) {
      this.currentPage--;
      this.viewportScroller.scrollToPosition([0, 0]);
    }
  }


  public get totalPages(): number {
    const orderDataLength = this.userData?.orderData?.length || 0;
    return Math.ceil(orderDataLength / this.itemsPerPage);
  }

  public calculateTotalPrice(order: any): number {
    let totalPrice = 0;
    for (const product of order.orderItemList) {
      totalPrice += product.product.price * product.amount;
    }
    return parseFloat(totalPrice.toFixed(2));
  }
}

