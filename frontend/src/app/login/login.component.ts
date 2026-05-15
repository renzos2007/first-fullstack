import {Component, inject, OnInit} from '@angular/core';
import {Router, RouterLink} from '@angular/router';
import {LoginService} from '../services/login.service';
import {FormsModule} from '@angular/forms';
import {TranslatePipe} from "@ngx-translate/core";
import {AuthenticatieService} from '../services/authenticatie.service';

@Component({
  selector: 'app-login',
  imports: [
    FormsModule,
    RouterLink,
    TranslatePipe,
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent implements OnInit {
  protected email: string = "";
  protected wachtwoord: string = "";
  protected errorType: number | null = null;

  private loginService = inject(LoginService);
  private router = inject(Router);
  private authenticatieService =  inject(AuthenticatieService);

  ngOnInit(): void {
    console.log("ngOnInit is aangeroepen");
    this.errorType = this.authenticatieService.getErrorType();
    console.log("ErrorType in ngOnInit:", this.errorType);
    this.authenticatieService.clearErrorType();
  }

  protected login(): void{
    const loginData = {email: this.email, wachtwoord: this.wachtwoord}

    this.loginService.login(loginData).subscribe({
      next: (responseData) => {
        this.router.navigate(['/gebruiker']);
      },
      error: (error) => {
        this.errorType = error.error;
      }
    })
  }
}
