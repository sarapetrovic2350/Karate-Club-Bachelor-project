import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Router } from '@angular/router';
import { AuthGuardService } from './auth-guard.service';

@Injectable({
  providedIn: 'root',
})
export class RoleGuardService {

  constructor(public authGuardService: AuthGuardService, private router: Router) { }
  canActivate(route: ActivatedRouteSnapshot): boolean {
    const expectedRole = route.data['expectedRole'];
    let currentRole;
    currentRole = localStorage.getItem('role')
    const { roles } = route.data;
    console.log("rola je " + currentRole)
    console.log("dozvoljene role " + route.data.roles)

    if (!this.authGuardService.getToken() || roles.indexOf(currentRole) === -1) {
      this.router.navigate(['/forbidden']);
      return false;
    }
    return true;
  }
}
