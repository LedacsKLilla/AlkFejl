import { Component, OnInit, Input } from '@angular/core';
import { Recipe } from '../core/recipe';

@Component({
  selector: 'app-recipe-detail',
  templateUrl: './recipe-detail.component.html',
  styleUrls: ['./recipe-detail.component.scss']
})
export class RecipeDetailComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  @Input() recipe: Recipe;

}
