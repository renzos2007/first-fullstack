import {OrderGegevens} from './OrderGegevens';

export interface GebruikersGegevens {
  gebruikerID: number;
  gebruikerNaam: string;
  wachtwoord: string;
  email: string;
  isAdmin: boolean;
  woonplaats: string | null;
  postcode: string | null;
  straatnaam: string | null;
  huisnummer: string | null;
  orderGegevens: OrderGegevens[];
  recensieGegevens: any;
}
