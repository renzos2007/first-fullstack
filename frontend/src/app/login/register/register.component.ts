import {Component, inject} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {LoginService} from '../../services/login.service';
import {Router} from '@angular/router';
import {TranslatePipe} from "@ngx-translate/core";

@Component({
  selector: 'app-register',
    imports: [
        ReactiveFormsModule,
        TranslatePipe
    ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss'
})
export class RegisterComponent {
  protected error: number|null = null;
  protected registerForm = new FormGroup({
    "gebruikersnaam": new FormControl("", [Validators.required]),
    "email": new FormControl("", [Validators.required, Validators.email]),
    "wachtwoord": new FormControl("", [Validators.required, Validators.minLength(8),
      Validators.pattern(/[A-Z]/),
      Validators.pattern(/[0-9]/),
      Validators.pattern(/[!@#$%^&*(),.?":{}|<>]/),
      Validators.pattern(/^\S*$/)]),
    "woonplaats": new FormControl("", [Validators.required]),
    "postcode": new FormControl("", [Validators.required]),
    "staatnaam": new FormControl("", [Validators.required]),
    "huisnummer": new FormControl("", [Validators.required]),
  })

  private loginService = inject(LoginService);
  private router = inject(Router);

  protected register(): void {
    const registerData = {
      gebruikersnaam: this.registerForm.get('gebruikersnaam')!.value!,
      email: this.registerForm.get('email')!.value!,
      wachtwoord: this.registerForm.get('wachtwoord')!.value!,
      woonplaats: this.registerForm.get('woonplaats')!.value!,
      postcode: this.registerForm.get('postcode')!.value!,
      straatnaam: this.registerForm.get('staatnaam')!.value!,
      huisnummer: this.registerForm.get('huisnummer')!.value!
    }

    this.loginService.registerAccount(registerData).subscribe({
      next: (responseData) => {
        this.router.navigate(['/gebruiker']);
      },
      error: (error) => {
        console.log(error)
        this.error = error;
      }
    })
  }
}
