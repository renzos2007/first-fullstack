import {Component, OnInit} from '@angular/core';
import {Difficulty} from '../../models/Difficulty';
import {FilterService} from '../../services/filter.service';
import {ActivatedRoute, RouterLink} from '@angular/router';
import {NgIf} from '@angular/common';
import {ProductItemsComponent} from '../product-items/product-items.component';
import {TranslatePipe} from "@ngx-translate/core";
import {Product} from '../../models/Product';

@Component({
  selector: 'app-products-niveau',
  imports: [
    NgIf,
    ProductItemsComponent,
    TranslatePipe,
    RouterLink
  ],
  templateUrl: './products-niveau.component.html',
  styleUrl: './products-niveau.component.scss'
})
export class ProductsNiveauComponent implements OnInit {
  private filterId!: number;
  protected filter!: Difficulty;

  protected currentPage: number = 1;
  protected itemsPerPage: number = 10;

  constructor(private route: ActivatedRoute, private filterService: FilterService) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.filterId = +params['id'];
      this.loadFilterData(this.filterId);
    });
  }

  public loadFilterData(id: number): void {
    this.filterService.getProductsByNiveau(id).subscribe(difficulty => {
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
