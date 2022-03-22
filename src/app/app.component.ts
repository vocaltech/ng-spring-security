import { Component, OnInit } from '@angular/core';

import { environment as env} from '../environments/environment'
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  title = 'ng-spring-security';
  result!: any;

  constructor(
    private auth: AuthService
  ) {}

  ngOnInit(): void {
    this.auth.login("user", "pwd").subscribe(data => {
      console.log(data)
    })
  }
}
