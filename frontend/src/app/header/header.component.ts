import {Component, inject, OnInit} from '@angular/core';
import {RouterLink} from '@angular/router';
import {LoginService} from '../services/login.service';
import {TranslatePipe, TranslateService} from '@ngx-translate/core';

@Component({
  selector: 'app-header',
  imports: [
    RouterLink,
    TranslatePipe
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {
  private loginService = inject(LoginService);
  private translate = inject(TranslateService);

  constructor() {
    this.translate.addLangs(['nl', 'en']);

    const browserLang = this.translate.getBrowserLang();
    this.translate.use(browserLang?.match(/nl|en/) ? browserLang : 'en');
  }

  protected checkLoginStatus(): boolean {
    const isLoggedIn = this.loginService.isLoggedIn();
    return isLoggedIn;
  }

  protected useLanguage(language: string): void {
    this.translate.use(language);
  }
}
