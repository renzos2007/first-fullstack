import {HttpErrorResponse, HttpHandlerFn, HttpRequest} from '@angular/common/http';
import {inject} from '@angular/core';
import {LoginService} from '../services/login.service';
import {catchError, throwError} from 'rxjs';

export function authInterceptor(req:HttpRequest<unknown>, next: HttpHandlerFn){
  const loginService = inject(LoginService);
  const authToken = loginService.getToken();

  if (authToken) {
    const newRequest = req.clone({
      headers: req.headers.set("Authorization", `Bearer ${authToken}`),
    });
    return next(newRequest).pipe(
      catchError((error: HttpErrorResponse) => {
        if (error.status === 401) {
          loginService.resetToken();
          loginService.setLoggedIn(false);
        }
        return throwError(error);
      })
    );
  } else {
    loginService.resetToken();
    loginService.setLoggedIn(false);
  }
  return next(req);
}
