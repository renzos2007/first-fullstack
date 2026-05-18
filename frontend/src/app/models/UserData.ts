import {OrderData} from './OrderData';

export interface UserData  {
  userID: number;
  userName: string;
  password: string;
  email: string;
  city: string | null;
  postalCode: string | null;
  streetName: string | null;
  houseNumber: string | null;
  orderData: OrderData[];
  reviewData: any;
}
