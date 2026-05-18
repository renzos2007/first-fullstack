import {Component, OnInit} from '@angular/core';
import {Difficulty} from '../models/Difficulty';
import {DifficultyService} from '../services/difficulty.service';
import {RouterLink} from '@angular/router';
import {TranslatePipe} from "@ngx-translate/core";

@Component({
  selector: 'app-difficulty-list',
    imports: [
        RouterLink,
        TranslatePipe
    ],
  templateUrl: './difficulty-list.component.html',
  styleUrl: './difficulty-list.component.scss'
})
export class DifficultyListComponent implements OnInit {
  protected difficultylist: Difficulty[] = [];

  constructor(private difficultyService: DifficultyService) {}

  ngOnInit():void {
    this.difficultyService.getDifficultiyList().subscribe(filters => {this.difficultylist = filters})
  }

  public getDifficultyByID(difficulty: Difficulty): number {
    return difficulty.difficultyID;
  }

}
