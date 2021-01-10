import { Injectable } from '@angular/core';
import { Message } from './message';
import { HttpClient } from '@angular/common/http';
import { Recipe } from './recipe';

@Injectable({
  providedIn: 'root',
})
export class RecipeService {
  constructor(private httpClient: HttpClient) {}

  async getRecipes(): Promise<Recipe[]> {
    const recipes = await this.httpClient.get<Recipe[]>('/recipe').toPromise();
    return recipes;
  }

  //KELL az ID
  async getRecipe(recipeName: string): Promise<Recipe> {
    const recipe = await this.httpClient
      .get<Recipe>(`/recipe/${recipeName}`)
      .toPromise();
    return recipe;
  }

  async createRecipe(recipe: Recipe): Promise<Recipe> {
    const createdRecipe = await this.httpClient
      .post<Recipe>('recipe', recipe)
      .toPromise();
    return createdRecipe;
  }

  //KELL
  async editRecipe(recipeName: string, recipe: Recipe): Promise<Recipe> {
    const modifiedRecipe = this.httpClient
      .put<Recipe>(`/api/issues/${recipeName}`, recipe)
      .toPromise();
    return modifiedRecipe;
  }

  //KELL
  async deleteIssue(issue: Recipe): Promise<void> {
    await this.httpClient.delete(`/api/issues/${issue.Name}`).toPromise();
  }
}
