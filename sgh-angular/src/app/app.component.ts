import {Component, OnInit} from '@angular/core';
import {AuthGuardService} from './guards/auth.guard.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  nome: string;

  constructor(private authService: AuthGuardService) { }

  ngOnInit(): void {
  }

  onLogout(): void {
    this.authService.logout();
  }

  getNome(): string {
    return localStorage.getItem('nome');
  }

  isLoggedIn(): boolean {
     if (localStorage.getItem('email') === null){
       return false;
     }
     return true;
  }
}
