import { Component, OnInit } from '@angular/core';
import { UserInfoDetail } from 'src/app/_models/user.model';
import { AuthService } from 'src/app/_services/auth.service';
import { UserService } from 'src/app/_services/user.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  user!: UserInfoDetail;
  constructor(
    private service: UserService
    ) { }

  ngOnInit(): void {
    this.service.getInformation().subscribe(x =>{
      this.user = x;
      const email = localStorage.getItem("email");
      const username = localStorage.getItem("username");
      if(email && username){
        this.user.email = email;
        this.user.username = username;
      }
    });
  }

}
