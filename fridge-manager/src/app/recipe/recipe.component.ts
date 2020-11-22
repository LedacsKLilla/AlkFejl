import { Component, OnInit } from '@angular/core';
import { unitEnum } from '../ingredient';
import { Recipe } from '../recipe';

@Component({
  selector: 'app-recipe',
  templateUrl: './recipe.component.html',
  styleUrls: ['./recipe.component.scss'],
})
export class RecipeComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}

  recipes: Recipe[] = [
    {
      Name: 'Túrós rétes',
      Ingredients: [
        {
          Name: 'Túró',
          Quantity: 25,
          Unit: unitEnum.dkg,
        },
        {
          Name: 'Liszt',
          Quantity: 30,
          Unit: unitEnum.dkg,
        },
        {
          Name: 'Víz',
          Quantity: 0.2,
          Unit: unitEnum.liter,
        },
      ],
      Preparation:
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ut porttitor purus, sit amet rutrum est. Cras finibus est vitae diam aliquet, ut interdum sem vehicula. Curabitur eget sem eu sapien consequat bibendum in id arcu. Mauris vestibulum vel augue vitae interdum. Pellentesque ornare eu sapien et faucibus. Etiam ut volutpat odio. Nam tristique non orci ut tempor. Vivamus interdum porta arcu quis maximus. Nunc tincidunt mauris et felis iaculis feugiat. Proin a eleifend leo. Morbi eu nunc ullamcorper, tincidunt purus sit amet, finibus turpis. Sed blandit, metus a elementum condimentum, urna dolor vehicula risus, ut ornare ex nibh quis enim. Praesent vel dui pretium, commodo mauris at, interdum turpis.',
    },
    {
      Name: 'Mákos rétes',
      Ingredients: [
        {
          Name: 'Mák',
          Quantity: 15,
          Unit: unitEnum.dkg,
        },
        {
          Name: 'Liszt',
          Quantity: 30,
          Unit: unitEnum.dkg,
        },
        {
          Name: 'Víz',
          Quantity: 0.2,
          Unit: unitEnum.liter,
        },
      ],
      Preparation:
        'Curabitur feugiat cursus orci, a rhoncus ligula dignissim vehicula. Cras et tellus varius erat malesuada malesuada in eu sem. Vestibulum nunc metus, malesuada nec posuere eu, cursus vel mi. Sed vehicula, metus et rhoncus hendrerit, sapien sem consequat diam, vel pharetra diam felis quis diam. Phasellus bibendum pharetra magna, ac molestie risus tincidunt vitae. Vivamus aliquet vel lorem in dapibus. Donec ornare blandit consectetur. Ut id imperdiet erat, sit amet varius est.',
    },

    {
      Name: 'Almás rétes',
      ImagePath: 'https://via.placeholder.com/150',
      Ingredients: [
        {
          Name: 'Alma',
          Quantity: 50,
          Unit: unitEnum.dkg,
        },
        {
          Name: 'Liszt',
          Quantity: 30,
          Unit: unitEnum.dkg,
        },
        {
          Name: 'Víz',
          Quantity: 0.2,
          Unit: unitEnum.liter,
        },
      ],
      Preparation:
        'Maecenas finibus laoreet facilisis. Nam elementum eleifend urna eget molestie. In hac habitasse platea dictumst. Nam tincidunt interdum sapien, sit amet consequat urna. Nullam tempus consequat tortor sed lobortis. Vivamus posuere urna ac nibh bibendum blandit. Quisque volutpat sed felis quis porttitor. Donec blandit diam nec justo posuere, vitae hendrerit ex malesuada. Phasellus at placerat sapien.',
    },
  ];

  recipe: Recipe;

  public onSelectedRecipe(recipe: Recipe): void {
    this.recipe = recipe;
  }
}
