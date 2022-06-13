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
    const btn = document.getElementById("menu-btn");
    const navbar = document.getElementById("navbar");
    const checkbtn = document.getElementById("checkbtn") as HTMLInputElement | null; 
    if(btn && checkbtn)
      btn.classList.toggle('opened');
      if(checkbtn){
        checkbtn.checked = checkbtn.checked ? false : true;
        if(checkbtn.checked){
          navbar?.classList.add("navbarc");
        }else{
          navbar?.classList.remove("navbarc");

        }
      }
        
  }

}
