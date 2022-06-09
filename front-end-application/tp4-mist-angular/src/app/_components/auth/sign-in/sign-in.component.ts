import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/_services/auth.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit {

  signInForm!: FormGroup;

  constructor(
    private router: Router,
    private authService: AuthService
  ) {
    this.signInForm = new FormGroup({
      email: new FormControl(null, [Validators.required, Validators.email]),
      password: new FormControl(null, Validators.required)
    });
  }

  ngOnInit(): void {
  }

  onSignIn(): void {
    if (this.signInForm.valid) {
      this.authService.signIn(this.signInForm.value);
      this.router.navigate(['']);
    } else {
      console.log('Invalid form');
    }
  }

  onSignUp(): void {
    this.router.navigate(['auth', 'sign-up']);
  }

}
