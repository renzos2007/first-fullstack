import {Product} from './Product';

export interface OrderData {
  orderID: number;
  orderItemList: [{
    product: Product;
    amount: number;
  }];
  orderDate: Date;
  finished: boolean;
}
