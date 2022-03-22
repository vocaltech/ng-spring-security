import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { environment as env} from '../../environments/environment'

@Injectable({
  providedIn: 'root'
})

export class AuthService {
  private urlDashboard = env.url_server + '/dashboard';

  constructor(
    private http: HttpClient
  ) {}

  login = (username: string, password: string): Observable<Object> => {
    const base64Encoded = btoa(`${username}:${password}`)
    const headers = new HttpHeaders({ Authorization: 'Basic ' + base64Encoded})

    return this.http.get(this.urlDashboard, { headers })
  }
}
