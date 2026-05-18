import {Product} from './Product';

export interface Difficulty {
  difficultyID: number;
  difficulty: string;
  productList: Product[];
}
