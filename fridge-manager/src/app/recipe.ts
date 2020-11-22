import { Ingredient } from './ingredient';

export interface Recipe {
    Name: String;
    Ingredients: Ingredient[];
    Preparation: String;
    ImagePath?:String;
}

