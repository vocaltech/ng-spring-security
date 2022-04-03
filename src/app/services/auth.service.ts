import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators'

import { environment as env} from '../../environments/environment'

@Injectable({
  providedIn: 'root'
})

export class AuthService {
  private urlLogin = env.url_server + '/auth';

  private _isLoggedIn = false;
  private _username = '';
  private _profile!: any;
  private subject = new Subject<any>();

  constructor(
    private http: HttpClient
  ) {}

  isLoggedIn = () => this._isLoggedIn
  setLoggedIn = (val: boolean) => {
    this._isLoggedIn = val
  }

  getUsername = () => this._username
  setUsername = (val: string) => this._username = val

  getProfile = () => this._profile
  setProfile = (val: any) => {
    this._profile = JSON.parse(val)
  }


  // -------------------------
  // login event - begin
  //
  onLogin = (): Observable<any> => {
    return this.subject.asObservable()
  }

  notifyLoginEvent = () => {
    this.subject.next({
      isLoggedIn: this._isLoggedIn,
      username: this._username
    })
  }
  //
  // login event - end
  // -------------------------

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
