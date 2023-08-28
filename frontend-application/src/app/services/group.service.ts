import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {User} from "../models/user.model";
import {Group} from "../models/group.model";

@Injectable({
  providedIn: 'root'
})
export class GroupService {
  apiHost: string = 'http://localhost:8091/group';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }
  getAllGroups(clubId: string) {
    return this.http.get<Group[]>(this.apiHost + "/getAllClubGroups/" + clubId, {headers: this.headers});
  }
  getAllGroupsWithoutCoach() {
    return this.http.get<Group[]>(this.apiHost + "/getAllGroupsWithoutCoach", {headers: this.headers});
  }
  createGroup(group: Group) {
    return this.http.post<Group>(this.apiHost + '/createGroup', group);
  }
}
