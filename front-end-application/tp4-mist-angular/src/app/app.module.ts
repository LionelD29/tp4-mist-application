import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './_components/header/header.component';
import { FooterComponent } from './_components/footer/footer.component';
import { NavbarComponent } from './_components/navbar/navbar.component';
import { CategoryCardComponent } from './_components/game/category-card/category-card.component';
import { GameCardComponent } from './_components/game/game-card/game-card.component';
import { PromoCardComponent } from './_components/game/promo-card/promo-card.component';
import { GameCardListComponent } from './_components/game/game-card-list/game-card-list.component';
import { CategoryCardListComponent } from './_components/game/category-card-list/category-card-list.component';
import { PromoCardListComponent } from './_components/game/promo-card-list/promo-card-list.component';
import { HomeComponent } from './_pages/home/home.component';
import { DashboardComponent } from './_pages/dashboard/dashboard.component';
import { Error404Component } from './_pages/error404/error404.component';
import { AuthComponent } from './_pages/auth/auth.component';
import { SignInComponent } from './_components/auth/sign-in/sign-in.component';
import { SignUpComponent } from './_components/auth/sign-up/sign-up.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { JwtInterceptor } from './_helpers/interceptors/jwt.interceptor';
import { CardGameDetailsComponent } from './_components/game/card-game-details/card-game-details.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavbarComponent,
    CategoryCardComponent,
    GameCardComponent,
    PromoCardComponent,
    GameCardListComponent,
    CategoryCardListComponent,
    PromoCardListComponent,
    HomeComponent,
    DashboardComponent,
    Error404Component,
    AuthComponent,
    SignInComponent,
    SignUpComponent,
    CardGameDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: JwtInterceptor,
    multi: true
  }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
