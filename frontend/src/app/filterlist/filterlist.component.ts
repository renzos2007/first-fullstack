import {Component, OnInit} from '@angular/core';
import {Filter} from '../models/Difficulty';
import {FilterService} from '../services/filter.service';
import {RouterLink} from '@angular/router';
import {TranslatePipe} from "@ngx-translate/core";

@Component({
  selector: 'app-filterlist',
    imports: [
        RouterLink,
        TranslatePipe
    ],
  templateUrl: './filterlist.component.html',
  styleUrl: './filterlist.component.scss'
})
export class FilterlistComponent implements OnInit {
  protected filterlist: Filter[] = [];

  constructor(private filterService: FilterService) {}

  ngOnInit():void {
    this.filterService.getNiveaus().subscribe(filters => {this.filterlist = filters})
  }

  public getFilterByID(filter: Filter): number {
    return filter.niveauID
  }

}
