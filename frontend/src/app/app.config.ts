import {ApplicationConfig, importProvidersFrom, provideZoneChangeDetection} from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import {HttpClient, provideHttpClient, withInterceptors} from '@angular/common/http';
import {authInterceptor} from './config/interceptors';
import {TranslateModule, TranslateLoader, provideTranslateService} from "@ngx-translate/core";
import {provideTranslateHttpLoader, TranslateHttpLoader} from '@ngx-translate/http-loader';

// const httpLoaderFactory: (http: HttpClient) => TranslateHttpLoader = (http: HttpClient) =>
//   new TranslateHttpLoader(http, './i18n/', '.json');

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideHttpClient(withInterceptors([authInterceptor])),
    provideTranslateService({
      defaultLanguage: 'nl',
      loader: provideTranslateHttpLoader({
        prefix: './i18n/',
        suffix: '.json'
      })
    })
  ],
};
