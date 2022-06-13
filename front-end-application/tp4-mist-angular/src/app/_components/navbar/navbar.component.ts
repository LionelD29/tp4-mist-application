import { Component, HostListener, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/_services/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  @HostListener('window:scroll') 
  onScroll(e: Event): void {
    var navbar = document.getElementById("navbar");
    if(window.scrollY > 300){ 
      if(navbar){
        navbar.style.backgroundColor = "#292929";
        navbar.style.transition = 'background .5s';
      }
    }else{
      if(navbar){
        navbar.style.backgroundColor = "transparent";
      }
    }
  }
  // @HostListener('window:resize')
  // mobilemenu(e: Event):void{
  //   console.log(window.innerWidth);
  //   var cpt = 0;
  //   const navbar = document.getElementById("navbar");
  //   const elem = document.createElement("div");
  //   if(window.screenX < 1000){
  //     elem.classList.add("mobile-menu");  
      
  //     if(navbar && cpt === 0){
  //       cpt++;
  //       navbar.appendChild(elem);
  //     }
  //   }else{
  //     navbar?.removeChild(elem);
  //   }
  // }
  constructor(
    public authService: AuthService,
    private router: Router
  ) { }
  
  ngOnInit(): void {
  }

  onClick(event: any): void {
    this.router.navigate([event.target.id]);
  }

  onSignIn(): void {
    this.router.navigate(['auth', 'sign-in']);
  }
  onSignUp(): void {
    this.router.navigate(['auth', 'sign-up']);
  }

  onSignOut(): void {
    this.authService.signOut();
  }
  
  openMenu(){
    const btn = document.getElementById("menuu")
    if(btn)
      btn.classList.toggle('opened');
  }

}
