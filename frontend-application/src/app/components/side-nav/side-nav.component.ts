import { Component, OnInit, ViewChild, HostListener } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import {UserService} from "../../services/user.service";
@Component({
  selector: 'app-side-nav',
  templateUrl: './side-nav.component.html',
  styleUrls: ['./side-nav.component.css']
})
export class SideNavComponent implements OnInit {
  opened: boolean = true;
  isLoggedIn: boolean = false;
  name: string = "";
  isAdministrator: boolean = false;
  isCoach: boolean = false;
  isStudent: boolean = false;

  @ViewChild('sidenav', {static: true}) sidenav: MatSidenav;

  constructor(private userService : UserService) {
  }

  ngOnInit(): void {
    let user = this.userService.getCurrentUser()
    let role = localStorage.getItem('role')
    console.log(user)
    if (user === null) {
      this.isLoggedIn = false;
      this.opened = false;
    } else{
      this.isLoggedIn = true;
      this.name = user.karateClub.name;
      this.opened = true;
    }
    if (role == "ADMINISTRATOR") {
      this.isAdministrator = true;
    }
    if (role == "COACH") {
      this.isCoach = true;
    }
    if (role == "STUDENT") {
      this.isStudent = true;
    }
    console.log(window.innerWidth)
    if (window.innerWidth < 768) {
      this.sidenav.fixedTopGap = 55;
    } else {
      this.sidenav.fixedTopGap = 55;
    }

  }

  @HostListener('window:resize', ['$event'])
  onResize(event) {
    if (event.target.innerWidth < 768) {
      this.sidenav.fixedTopGap = 55;
    } else {
      this.sidenav.fixedTopGap = 55
    }
  }

  isBiggerScreen() {
    const width = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
    if (width < 768) {
      return true;
    } else {
      return false;
    }

  }
  logout(){
    this.userService.logout();
  }

}
