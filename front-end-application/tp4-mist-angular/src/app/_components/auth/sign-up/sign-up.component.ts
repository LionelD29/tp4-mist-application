import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/_services/auth.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {

  signUpForm!: FormGroup;

  constructor(
    private authService: AuthService,
    private router: Router
  ) {
    this.signUpForm = new FormGroup({
      firstName: new FormControl(null, [Validators.required, Validators.maxLength(30)]),
      lastName: new FormControl(null, [Validators.required, Validators.maxLength(30)]),
      birthDate: new FormControl(null, [Validators.required]),
      email: new FormControl(null, [Validators.required, Validators.email]),
      phoneNumber: new FormControl(null, [Validators.required]),
      username: new FormControl(null, [Validators.required, Validators.maxLength(30)]),
      password: new FormControl(null, [Validators.required])
    });
  }

  ngOnInit(): void {
  }

  onSignUp(): void {
    if (this.signUpForm.valid) {
      this.authService.signUp(this.signUpForm.value);
      this.router.navigate(['']);
    } else {
      alert('Invalid form');
    }
  }

}
