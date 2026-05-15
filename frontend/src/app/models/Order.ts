export interface Order {
  afgehandeld: boolean;
  besteldeBoeken: [] | null;
  orderDatum: Date;
  orderNumber: number;
}
