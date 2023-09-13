import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {AuthRequest, ChangePassword, User} from "../models/user.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  apiHost: string = 'http://localhost:8091/';
  url = this.apiHost + 'auth/login';
  activate_account_url = this.apiHost + 'auth/activate-account/';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  private user = new User();
  jwt: string = "";
  expiresIn: number = -1;
  constructor(private http: HttpClient) { }

  login(request: AuthRequest) {
    return this.http.post<any>(this.url, request);
  }
  registerUser(user: User) {
    return this.http.post<any>(this.apiHost + 'user/registerUser', user);
  }

  changePassword(password: ChangePassword) {
    return this.http.put<any>(this.apiHost + 'user/changePassword' , password, {headers: this.headers});
  }

  setLoggedUser(data: any) {
    this.user = data.user;
    this.jwt = data.accessToken;
    this.expiresIn = data.expiresIn;
    localStorage.setItem('jwt', this.jwt);
    localStorage.setItem('refreshToken', JSON.stringify(this.expiresIn));
    localStorage.setItem('currentUser', JSON.stringify(this.user));
    localStorage.setItem('role', data.user.authority.name);
    console.log(localStorage.getItem('role'));
    console.log(localStorage.getItem('currentUser'));

  }
  activateAccount(token: string) {
    return this.http.put<any>(this.activate_account_url + token, {headers: this.headers});
  }
  getCurrentUser(): any {
    return JSON.parse(localStorage.getItem('currentUser')!);
  }
  logout() {
    this.jwt = "";
    localStorage.clear();
    window.location.href = '/';
  }
  getUserByEmail(email: string): Observable<User> {
    return this.http.get<User>(this.apiHost + 'user/getUserByEmail/' + email, {headers: this.headers});
  }
  getUserById(userId: string): Observable<User> {
    return this.http.get<User>(this.apiHost + 'user/getUserById/' + userId, {headers: this.headers});
  }
  getStudentsInGroup(groupId: string): Observable<User> {
    return this.http.get<User>(this.apiHost + 'user/getStudentsInGroup/' + groupId, {headers: this.headers});
  }
  updateUser(user: any): Observable<any> {
    return this.http.put<any>(this.apiHost + 'user/update' , user, {headers: this.headers});
  }

  getAllCoaches() {
    return this.http.get<User[]>(this.apiHost + "user/getAllCoaches", {headers: this.headers});
  }
  getAllStudents() {
    return this.http.get<User[]>(this.apiHost + "user/getAllStudents", {headers: this.headers});
  }

  getAllClubCoaches(clubId: string) {
    return this.http.get<User[]>(this.apiHost + "user/getAllClubCoaches/" + clubId, {headers: this.headers});
  }
  getAllClubStudents(clubId: string) {
    return this.http.get<User[]>(this.apiHost + "user/getAllClubStudents/" + clubId, {headers: this.headers});
  }

}
