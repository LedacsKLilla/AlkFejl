import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './core/auth.guard';
import { LoginComponent } from './login/login.component';
import { NewRecipeComponent } from './new-recipe/new-recipe.component';
import { RecipeComponent } from './recipe/recipe.component';
import { StorageComponent } from './storage/storage.component';

const routes: Routes = [
  {
    path: 'recipe',
    component: RecipeComponent,
    //canActivate: [AuthGuard],
  },
  {
    path: 'storage',
    component: StorageComponent,
    //canActivate: [AuthGuard],
  },
  {
    path: 'new-recipe',
    component: NewRecipeComponent,
    //canActivate: [AuthGuard],
  },  
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: '**',
    redirectTo: 'recipe',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
