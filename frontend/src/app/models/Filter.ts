import {Product} from './Product';

export interface Filter {
  niveauID: number;
  niveau: string;
  niveaus: Product[];
}
