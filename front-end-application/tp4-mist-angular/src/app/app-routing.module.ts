import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignInComponent } from './_components/auth/sign-in/sign-in.component';
import { SignUpComponent } from './_components/auth/sign-up/sign-up.component';
import { GameCardComponent } from './_components/game/game-card/game-card.component';
import { AuthComponent } from './_pages/auth/auth.component';
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
  {path:"**", redirectTo:"error"},
  {path: "game/:id", component: GameCardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
