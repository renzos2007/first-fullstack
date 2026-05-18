import {Component, inject, Input} from '@angular/core';
import {WinkelmandService} from '../services/winkelmand.service';
import {WinkelmandProduct} from '../models/WinkelmandProduct';
import {NgFor} from '@angular/common';
import {UserData} from '../models/UserData';
import {GebruikersGegevensService} from '../services/gebruikers-gegevens.service';
import {catchError, throwError} from 'rxjs';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import { ChangeDetectorRef } from '@angular/core';
import {TranslatePipe} from '@ngx-translate/core';
import {AuthenticatieService} from '../services/authenticatie.service';

@Component({
  selector: 'app-winkelmand',
  imports: [
    NgFor,
    TranslatePipe
  ],
  templateUrl: './winkelmand.component.html',
  styleUrl: './winkelmand.component.scss'
})
export class WinkelmandComponent {
  protected boekenBestelList: WinkelmandProduct[];
  private router = inject(Router);
  private authenticatieService =  inject(AuthenticatieService);
  protected isBetaald: boolean = false;

  constructor(private winkelmandService: WinkelmandService, private gebruikersGegevensService: GebruikersGegevensService, private http: HttpClient, private cdr: ChangeDetectorRef, private route: ActivatedRoute
  ) {
    this.boekenBestelList = this.winkelmandService.getBoeken();

    const savedWinkelmand = localStorage.getItem('winkelmand_producten');
    if (savedWinkelmand) {
      this.boekenBestelList = JSON.parse(savedWinkelmand);
    } else {
      this.boekenBestelList = []
    }

    this.route.queryParams.subscribe(params => {
      this.isBetaald = params['isBetaald'] === 'true';
    });
  }

  public getBestelList(): WinkelmandProduct[] {
    return this.boekenBestelList;
  }

  public clearBestelList(): void {
    this.boekenBestelList = [];
    this.winkelmandService.setBoeken(this.boekenBestelList);
    this.winkelmandService.updateLocalStorage();
    this.cdr.detectChanges();
  }

  public getTotalePrijs(): number {
    let totaalPrijsWinkelwagen = 0
    for (let i = 0; i < this.boekenBestelList.length; i++) {
      let totaalPrijsProduct = this.boekenBestelList[i].price * this.boekenBestelList[i].amount;
      totaalPrijsWinkelwagen += totaalPrijsProduct
    }
    return parseFloat(totaalPrijsWinkelwagen.toFixed(2));
  }

  public betaalPage(): void {
    this.gebruikersGegevensService.getGebruikersGegevens().pipe(
      catchError(error => {
        if (error.status === 401) {
          this.authenticatieService.setErrorType(error.status);
          this.router.navigate(['/login']);
        }
        return throwError(error);
      })
    ).subscribe()
    this.router.navigate(['/betalen']);
  }

  public createOrder(): void {
    let nodigeInfo = this.boekenBestelList.map(boek => ({
      boekID: boek.productID,
      hoeveelheid: boek.amount < 1 ? 1 : boek.amount
    }));

    this.http.post(environment.apiUrl + "/order", nodigeInfo).pipe(
      catchError(error => {
        console.error('Er is een fout opgetreden bij het verzenden van de order:', error);
        return throwError(error);
      })
    ).subscribe(response => {
      console.log('Order succesvol verzonden:', response);
    });
    this.isBetaald = false;
    this.clearBestelList()
    this.router.navigate(['/']);
    alert("Bestelling is geplaatst")
  };
}
