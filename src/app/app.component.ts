import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment as env} from '../environments/environment'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  title = 'ng-spring-security';
  result!: any;

  private urlDashboard = env.url_server + '/dashboard';

  constructor(
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    this.http.get(this.urlDashboard).subscribe(data => {
        this.result = data;
    })
  }
}
