import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { Recipe } from '../core/recipe';

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.scss'],
})
export class RecipeListComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}

  @Input() recipes: Recipe[];

  @Output() selectedRecipe = new EventEmitter<Recipe>();

  onChanged(recipe: Recipe): void {
    this.selectedRecipe.emit(recipe);
  }
}
