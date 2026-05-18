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
  selector: 'app-gebruikergegevens',
  imports: [
    NgForOf,
    DatePipe,
    TranslatePipe,
  ],
  templateUrl: './gebruikergegevens.component.html',
  styleUrl: './gebruikergegevens.component.scss'
})
export class GebruikergegevensComponent implements OnInit {
  protected gebruikersGegevens?: UserData;
  protected currentPage: number = 1;
  protected itemsPerPage: number = 10;

  constructor(private userDataService: UserDataService, protected loginService: LoginService, private viewportScroller: ViewportScroller, private router: Router) {
  }

  ngOnInit(): void {
    if (!this.loginService.isLoggedIn()) {
      this.router.navigate(['/login']);
    }

    this.userDataService.getUserData().subscribe(gebruikersGegevens => {
      this.gebruikersGegevens = gebruikersGegevens;
    })
  }
  public get paginatedOrders(): OrderData[] {
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    return this.gebruikersGegevens?.orderData.slice(startIndex, startIndex + this.itemsPerPage) || [];
  }

  public nextPage(): void {
    if (this.gebruikersGegevens && this.gebruikersGegevens.orderData &&
      (this.currentPage * this.itemsPerPage < this.gebruikersGegevens.orderData.length)) {
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
    const orderDataLength = this.gebruikersGegevens?.orderData?.length || 0;
    return Math.ceil(orderDataLength / this.itemsPerPage);
  }

  public berekenTotalePrijs(order: any): number {
    let totalePrijs = 0;
    for (const boek of order.besteldeBoeken) {
      totalePrijs += boek.boek.prijs * boek.hoeveelheid;
    }
    return parseFloat(totalePrijs.toFixed(2));
  }
}

