import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignInComponent } from './_components/auth/sign-in/sign-in.component';
import { SignUpComponent } from './_components/auth/sign-up/sign-up.component';
import { CardGameDetailsComponent } from './_components/game/card-game-details/card-game-details.component';
import { AuthComponent } from './_pages/auth/auth.component';
import { CategoryPageComponent } from './_pages/category-page/category-page.component';
import { DashboardComponent } from './_pages/dashboard/dashboard.component';
import { Error404Component } from './_pages/error404/error404.component';
import { HomeComponent } from './_pages/home/home.component';

const routes: Routes = [
  {path:"", redirectTo:"home", pathMatch:"full"},
  {path:"home", component:HomeComponent},
  {path:"dashboard", component:DashboardComponent},
  {path:"auth", component:AuthComponent, pathMatch: "full"},
  {path:"auth/sign-in", component:SignInComponent},
  {path:"auth/sign-up", component:SignUpComponent},
  {path:"error", component:Error404Component},
  {path:"details/:reference", component:CardGameDetailsComponent},
  {path:"genre/:genre", component: CategoryPageComponent},
  {path:"**", redirectTo:"error"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
