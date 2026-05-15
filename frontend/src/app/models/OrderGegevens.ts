import {Product} from './Product';

export interface OrderGegevens {
  orderNumber: number;
  besteldeBoeken: [{
    boek: Product;
    hoeveelheid:number;
  }];
  orderDatum: Date;
  afgehandeld: boolean;
}
