import {Component, inject, OnInit} from '@angular/core';
import {Difficulty} from '../../models/Difficulty';
import {DifficultyService} from '../../services/difficulty.service';
import {ActivatedRoute, RouterLink} from '@angular/router';
import {TranslatePipe} from "@ngx-translate/core";
import {Product} from '../../models/Product';
import { ProductDifficultyItemComponent } from '../product-difficulty-item/product-difficulty-item.component';

@Component({
  selector: 'app-products-difficulty',
  imports: [
    ProductDifficultyItemComponent,
    TranslatePipe,
    RouterLink
  ],
  templateUrl: './product-difficulty-list.component.html',
  styleUrl: './product-difficulty-list.component.scss'
})
export class ProductsDifficultyListComponent implements OnInit {
private route = inject(ActivatedRoute);
private difficultyService = inject(DifficultyService);

  private difficultyID!: number;
  protected difficulty!: Difficulty;
  protected currentPage: number = 1;
  protected itemsPerPage: number = 10;

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.difficultyID = +params['id'];
      this.loadFilterData(this.difficultyID);
    });
  }

  public loadFilterData(id: number): void {
    this.difficultyService.getProductsByDifficulty(id).subscribe(difficulty => {
      this.difficulty = difficulty;
    });
  }

  public get paginatedProducts(): Product[] {
    if (!this.difficulty || !this.difficulty.difficulty) {
      return [];
    }
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    return this.difficulty.productList.slice(startIndex, startIndex + this.itemsPerPage);
  }

  public nextPage(): void {
    if (this.currentPage * this.itemsPerPage < this.difficulty.difficulty.length) {
      this.currentPage++;
    }
  }

  public previousPage(): void {
    if (this.currentPage > 1) {
      this.currentPage--;
    }
  }

  public get totalPages(): number {
    return Math.ceil(this.difficulty?.productList.length / this.itemsPerPage);
  }
}
