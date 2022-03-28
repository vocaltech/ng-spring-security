import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  isLoading = false

  // This will give us access to the form
  @ViewChild("loginform", { static: false }) 
  loginForm!: NgForm;

  constructor(
    private router: Router,
    private auth: AuthService
  ) { }

  ngOnInit(): void {

  }

  onLoginSubmit = async () => {
    const _username = this.loginForm.value.username;
    const _password = this.loginForm.value.password;

    // -------------------------
    // --- update UI ---
    // -------------------------
    this.isLoading = true

    // simulate a delay when sending data to server
    await this.delay(500);

    this.isLoading = false

    // -------------------------
    // --- post data to server ---
    // -------------------------
    this.auth.login(_username, _password).subscribe(
      data => {
          console.log(data)
          this.router.navigate(['dashboard'])
      },
      error => {
        const errorUrl = error.url as string
        if (errorUrl.endsWith('/login') && error.ok === false) {
          console.log('Invalid credentials (username/password)...')
        }

        // TODO: clean the text fields after submit

      },
      () => {}
    )}

  delay = (delayMs: number): Promise<void> => {
    return new Promise((resolve, reject) => {
      setTimeout(resolve, delayMs)
    })
  }
}
