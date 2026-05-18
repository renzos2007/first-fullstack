import { Genre } from "./Genre";
import { Publisher } from "./Publisher";
import { Review } from "./Review";
import { Writer } from "./Writer";

export interface Product {
  productID: number;
  name: string;
  type: string;
  price: number;
  genreList: Genre[];
  summary: string;
  language: string;
  pages: number;
  writer: Writer;
  publisher: Publisher;
  cover: string;
  stock: number;
  review: Review[];
  image: string;
  bestSeller: boolean;
}
