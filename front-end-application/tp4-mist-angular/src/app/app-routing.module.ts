import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthComponent } from './_pages/auth/auth.component';
import { DashboardComponent } from './_pages/dashboard/dashboard.component';
import { Error404Component } from './_pages/error404/error404.component';
import { HomeComponent } from './_pages/home/home.component';

const routes: Routes = [
  {path:"", redirectTo:"home", pathMatch:"full"},
  {path:"home", component:HomeComponent},
  {path:"dashboard", component:DashboardComponent},
  {path:"auth", component:AuthComponent},
  {path:"error", component:Error404Component},
  {path:"**", redirectTo:"error"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
