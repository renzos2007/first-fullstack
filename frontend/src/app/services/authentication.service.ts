import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private errorType: number | null = null;

  public setErrorType(errorType: number): void {
    this.errorType = errorType;
  }

  public getErrorType(): number | null {
    return this.errorType;
  }

  public clearErrorType(): void {
    this.errorType = null;
  }
}
