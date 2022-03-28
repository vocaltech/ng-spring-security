import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators'

import { environment as env} from '../../environments/environment'

@Injectable({
  providedIn: 'root'
})

export class AuthService {
  private urlLogin = env.url_server + '/auth';
  private urlDashboard = env.url_server + '/dashboard';

  constructor(
    private http: HttpClient
  ) {}

  login = (username: string, password: string): Observable<Object> => {
    const base64Encoded = btoa(`${username}:${password}`)
    const headers = new HttpHeaders({ 
      'Authorization': 'Basic ' + base64Encoded 
    })

    return this.http.get(this.urlLogin, { headers } )
      .pipe(
        catchError(err => {
          return throwError(err)
        })
      )
  }
}
