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
    const navbar = document.getElementById("navbar");
    if(window.scrollY > 300){ 
      if(navbar){
        navbar.style.backgroundColor = "#292929";
      }
    }else{
      if(!this.isOpen){
        if(navbar){
        navbar.style.backgroundColor = "transparent";
        }
      }else{
        if(navbar){
          navbar.style.backgroundColor = "#292929";  
        }
      }    
    }
  }
  @HostListener('window:resize')
  checkSize(e: Event):void{
    const navbar_elem = document.getElementById("navbarContent");
    if(window.innerWidth <= 1000 && !this.isOpen){
      if(navbar_elem){
        if(!navbar_elem.classList.contains("collapser")){
          navbar_elem.classList.add("collapser");
        }
      }
    }else{
      if(navbar_elem){
        navbar_elem.classList.remove("collapser");
      }
    }
  }
  
  isOpen:boolean = false;
  constructor(
    public authService: AuthService,
    private router: Router
  ) { }
  
  ngOnInit(): void {
    this.resizeOnInit();
  }

  onClick(event: any): void {
    this.openMenu();
    this.router.navigate([event.target.id]);
  }

  onSignIn(): void {
    this.openMenu();
    this.router.navigate(['auth', 'sign-in']);
  }
  onSignUp(): void {
    this.openMenu();
    this.router.navigate(['auth', 'sign-up']);
  }

  onSignOut(): void {
    this.openMenu();
    this.authService.signOut();
  }
  
  navbarChanger(){
    const body = document.getElementsByTagName("body")[0];
    const navbar = document.getElementById("navbar");
    const logo = document.getElementById("logo1");
    if(this.isOpen){
      if(navbar && logo){
        if(!navbar.classList.contains("navOpen")){
          navbar.style.backgroundColor = "#292929";
          navbar.classList.add("navbarc");
          navbar.style.left= "0";
          logo.style.left= "0";
          navbar.style.height= "100vh";
          body.style.overflow = "hidden";
        }
      }
    }else{
      if(navbar && logo){
        navbar.style.backgroundColor = "transparent";
        navbar.style.left= "-100%";
        navbar.classList.remove("navbarc");
        navbar.style.height= "80px";
        logo.style.left= "50%";
        
      }
      body.style.overflow = "auto"; 
    }      
  }

  openMenu(){
    if(window.innerWidth < 1000){
      this.isOpen = this.isOpen ? false : true;
      const navbar_elem = document.getElementById("navbarContent");
      const navbar_parent = document.getElementById("parentItem");
      const btn = document.getElementById("menu-btn");
      if(this.isOpen){
        if(navbar_elem && navbar_parent){
          navbar_elem.classList.remove("collapser");
          navbar_elem.classList.add("navbarItems");
          navbar_parent.classList.add("navparent")
        }
      }else{
        if(navbar_elem && navbar_parent){
          navbar_elem.classList.add("collapser");
          navbar_elem.classList.remove("navbarItems");
          navbar_parent.classList.remove("navparent")
        }  
      }
      if(btn)
        btn.classList.toggle('opened'); 
      this.navbarChanger();
    }
  }
  
  resizeOnInit(){
    if(window.innerWidth <= 1000){
      const navbar_elem = document.getElementById("navbarContent");
      if(navbar_elem){
        navbar_elem.classList.add("collapser");
      }
    }
  }
}
