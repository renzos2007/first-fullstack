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
    "userName": new FormControl("", [Validators.required]),
    "email": new FormControl("", [Validators.required, Validators.email]),
    "password": new FormControl("", [Validators.required, Validators.minLength(8),
      Validators.pattern(/[A-Z]/),
      Validators.pattern(/[0-9]/),
      Validators.pattern(/[!@#$%^&*(),.?":{}|<>]/),
      Validators.pattern(/^\S*$/)]),
    "city": new FormControl("", [Validators.required]),
    "postalCode": new FormControl("", [Validators.required]),
    "streetName": new FormControl("", [Validators.required]),
    "houseNumber": new FormControl("", [Validators.required]),
  })

  private loginService = inject(LoginService);
  private router = inject(Router);

  protected register(): void {
    const registerData = {
      userName: this.registerForm.get('userName')!.value!,
      email: this.registerForm.get('email')!.value!,
      password: this.registerForm.get('password')!.value!,
      city: this.registerForm.get('city')!.value!,
      postalCode: this.registerForm.get('postalCode')!.value!,
      streetName: this.registerForm.get('streetName')!.value!,
      houseNumber: this.registerForm.get('houseNumber')!.value!,
    }

    this.loginService.registerAccount(registerData).subscribe({
      next: (responseData) => {
        this.router.navigate(['/user']);
      },
      error: (error) => {
        console.log(error)
        this.error = error;
      }
    })
  }
}
