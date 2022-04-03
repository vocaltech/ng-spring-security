import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})

export class DashboardComponent implements OnInit {
  isLoggedIn = false;
  profile: any;

  constructor(
    private auth: AuthService
  ) {}

  ngOnInit(): void {
    this.profile = this.auth.getProfile()
  }
}
