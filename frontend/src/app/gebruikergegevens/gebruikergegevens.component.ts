import {Component, OnInit} from '@angular/core';
import {GebruikersGegevens} from '../models/UserData';
import {GebruikersGegevensService} from '../services/gebruikers-gegevens.service';
import {of} from 'rxjs';
import {CurrencyPipe, DatePipe, NgForOf, NgIf, ViewportScroller} from '@angular/common';
import {TranslatePipe} from '@ngx-translate/core';
import {LoginService} from '../services/login.service';
import {Router} from '@angular/router';
import {OrderGegevens} from '../models/OrderGegevens';

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
  protected gebruikersGegevens?: GebruikersGegevens;
  protected currentPage: number = 1;
  protected itemsPerPage: number = 10;

  constructor(private gebruikersGegevensService: GebruikersGegevensService, protected loginService: LoginService, private viewportScroller: ViewportScroller, private router: Router) {
  }

  ngOnInit(): void {
    if (!this.loginService.isLoggedIn()) {
      this.router.navigate(['/login']);
    }

    this.gebruikersGegevensService.getGebruikersGegevens().subscribe(gebruikersGegevens => {
      this.gebruikersGegevens = gebruikersGegevens;
    })
  }
  public get paginatedOrders(): OrderGegevens[] {
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    return this.gebruikersGegevens?.orderGegevens.slice(startIndex, startIndex + this.itemsPerPage) || [];
  }

  public nextPage(): void {
    if (this.gebruikersGegevens && this.gebruikersGegevens.orderGegevens &&
      (this.currentPage * this.itemsPerPage < this.gebruikersGegevens.orderGegevens.length)) {
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
    const orderGegevensLength = this.gebruikersGegevens?.orderGegevens?.length || 0;
    return Math.ceil(orderGegevensLength / this.itemsPerPage);
  }

  public berekenTotalePrijs(order: any): number {
    let totalePrijs = 0;
    for (const boek of order.besteldeBoeken) {
      totalePrijs += boek.boek.prijs * boek.hoeveelheid;
    }
    return parseFloat(totalePrijs.toFixed(2));
  }
}

