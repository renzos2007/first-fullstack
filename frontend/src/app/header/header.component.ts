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
export class HeaderComponent implements OnInit {

  protected loginService = inject(LoginService);
  constructor(private translate: TranslateService) {
    this.translate.addLangs(['de', 'en']);
    this.translate.setDefaultLang('en');
    this.translate.use(this.translate.getBrowserLang() || "en");
  }

  ngOnInit(): void {
    this.updateLoginStatus()
  }

  public updateLoginStatus(): void {
    this.loginService.isLoggedIn();
  }

  public useLanguage(language: string): void {
    this.translate.use(language);
  }
}
