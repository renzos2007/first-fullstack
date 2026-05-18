import {Component, OnInit} from '@angular/core';
import {Difficulty} from '../../models/Difficulty';
import {DifficultyService} from '../../services/difficulty.service';
import {ActivatedRoute, RouterLink} from '@angular/router';
import {NgIf} from '@angular/common';
import {TranslatePipe} from "@ngx-translate/core";
import {Product} from '../../models/Product';
import { ProductDifficultyItemComponent } from '../product-difficulty-item/product-difficulty-item.component';

@Component({
  selector: 'app-products-difficulty',
  imports: [
    NgIf,
    ProductDifficultyItemComponent,
    TranslatePipe,
    RouterLink
  ],
  templateUrl: './product-difficulty-list.component.html',
  styleUrl: './product-difficulty-list.component.scss'
})
export class ProductsDifficultyListComponent implements OnInit {
  private filterId!: number;
  protected filter!: Difficulty;

  protected currentPage: number = 1;
  protected itemsPerPage: number = 10;

  constructor(private route: ActivatedRoute, private difficultyService: DifficultyService) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.filterId = +params['id'];
      this.loadFilterData(this.filterId);
    });
  }

  public loadFilterData(id: number): void {
    this.difficultyService.getProductsByDifficulty(id).subscribe(difficulty => {
      this.filter = difficulty;
    });
  }

  public get paginatedProducts(): Product[] {
    if (!this.filter || !this.filter.difficulty) {
      return [];
    }
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    return this.filter.productList.slice(startIndex, startIndex + this.itemsPerPage);
  }

  public nextPage(): void {
    if (this.currentPage * this.itemsPerPage < this.filter.difficulty.length) {
      this.currentPage++;
    }
  }

  public previousPage(): void {
    if (this.currentPage > 1) {
      this.currentPage--;
    }
  }

  public get totalPages(): number {
    return Math.ceil(this.filter?.difficulty.length / this.itemsPerPage);
  }
}
