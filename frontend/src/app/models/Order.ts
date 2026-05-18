export interface Order {
  finished: boolean;
  orderItemList: [] | null;
  orderDate: Date;
  orderID: number;
}
