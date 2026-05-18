import {Component, inject, OnInit} from '@angular/core';
import {Router, RouterLink} from '@angular/router';
import {LoginService} from '../services/login.service';
import {FormsModule} from '@angular/forms';
import {TranslatePipe} from "@ngx-translate/core";
import {AuthenticationService} from '../services/authentication.service';

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
  protected password: string = "";
  protected errorType: number | null = null;

  private loginService = inject(LoginService);
  private router = inject(Router);
  private authenticationService =  inject(AuthenticationService);

  ngOnInit(): void {
    console.log("ngOnInit is aangeroepen");
    this.errorType = this.authenticationService.getErrorType();
    console.log("ErrorType in ngOnInit:", this.errorType);
    this.authenticationService.clearErrorType();
  }

  protected login(): void{
    const loginData = {email: this.email, password: this.password}

    this.loginService.login(loginData).subscribe({
      next: (responseData) => {
        this.router.navigate(['/user']);
      },
      error: (error) => {
        this.errorType = error.error;
      }
    })
  }
}
