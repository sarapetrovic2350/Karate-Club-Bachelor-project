import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Group} from "../models/group.model";
import {Observable} from "rxjs";
import {Competition} from "../models/competition.model";

@Injectable({
  providedIn: 'root'
})
export class CompetitionService {
  apiHost: string = 'http://localhost:8091/competition';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) { }
  getAllCompetitions(params: any): Observable<Competition[]> {
    return this.http.get<Competition[]>(this.apiHost + "/findAll", {params});
  }

}
