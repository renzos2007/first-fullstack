import {Component, EventEmitter, inject, OnInit, Output} from '@angular/core';
import {WinkelmandProduct} from '../../models/WinkelmandProduct';
import {WinkelmandService} from '../../services/winkelmand.service';
import {FormsModule} from '@angular/forms';
import {NgIf} from '@angular/common';
import {Router} from '@angular/router';
import {TranslatePipe} from '@ngx-translate/core';
import {LoginService} from '../../services/login.service';

@Component({
  selector: 'app-betalen',
  imports: [
    FormsModule,
    NgIf,
    TranslatePipe
  ],
  templateUrl: './betalen.component.html',
  styleUrl: './betalen.component.scss'
})
export class BetalenComponent implements OnInit {
  private router = inject(Router);
  protected boekenBestelList: WinkelmandProduct[] = [];
  protected gekozenBetaalmethode: string = '';
  protected betaalmethodeGekozen: boolean = false;
  protected isBetaald: boolean = false;


  constructor(private winkelmandService: WinkelmandService, private loginService: LoginService) {}

  ngOnInit(): void {
    if (!this.loginService.isLoggedIn()) {
      this.router.navigate(['/']);
    }

    this.boekenBestelList = this.winkelmandService.getBoeken();

    if (this.boekenBestelList.length <= 0) {
      this.router.navigate(['/winkelmand']);
    }

    const savedWinkelmand = localStorage.getItem('winkelmand_producten');
    if (savedWinkelmand) {
      this.boekenBestelList = JSON.parse(savedWinkelmand);
    } else {
      this.boekenBestelList = [];
    }
  }

  public getTotalePrijs(): number {
    let totaalPrijsWinkelwagen = 0;
    for (let i = 0; i < this.boekenBestelList.length; i++) {
      let totaalPrijsProduct = this.boekenBestelList[i].prijs * this.boekenBestelList[i].hoeveelheid;
      totaalPrijsWinkelwagen += totaalPrijsProduct;
    }
    return parseFloat(totaalPrijsWinkelwagen.toFixed(2));
  }

  public verwerkBetaling(): void {
    if (this.gekozenBetaalmethode) {
      console.log(`Betaling verwerkt met ${this.gekozenBetaalmethode}`);
      this.betaalmethodeGekozen = true;
      this.isBetaald = true;
      this.router.navigate(['/winkelmand'], { queryParams: { isBetaald: this.isBetaald } });
    } else {
      this.betaalmethodeGekozen = false;
    }
  }

  public annuleren(): void {
    this.gekozenBetaalmethode = '';
    this.betaalmethodeGekozen = false;
    this.isBetaald = false;
    this.router.navigate(['/winkelmand'], { queryParams: { isBetaald: this.isBetaald } });
  }
}
