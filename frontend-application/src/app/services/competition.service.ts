import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Competition} from "../models/competition.model";
import {Group} from "../models/group.model";

@Injectable({
  providedIn: 'root'
})
export class CompetitionService {
  apiHost: string = 'http://localhost:8091/competition';
  apiHostRegisterClub: string = 'http://localhost:8091/competition/registerClubToCompetition'
  headers: HttpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient) {
  }
  getAll() {
    return this.http.get<Competition[]>(this.apiHost + "/getAll", {headers: this.headers});
  }
  getAllCompetitions(params: any): Observable<Competition[]> {
    return this.http.get<Competition[]>(this.apiHost + "/findAll", {params});
  }

  registerClubToCompetition(competitionId: any, clubId: any) {
    let queryParams = new HttpParams()
    console.log(competitionId);
    console.log(clubId);
    queryParams = queryParams.append("competitionId", competitionId)
    queryParams = queryParams.append("clubId", clubId)
    console.log(queryParams);
    return this.http.post<any>(this.apiHostRegisterClub, null, {params: queryParams});
  }

  checkIfClubIsRegistered(competitionId: any, clubId: any) {
    let queryParams = new HttpParams()
    console.log(competitionId);
    console.log(clubId);
    queryParams = queryParams.append("competitionId", competitionId)
    queryParams = queryParams.append("clubId", clubId)
    console.log(queryParams);
    return this.http.get<any>(this.apiHost + '/checkIfClubIsRegistered', {params: queryParams});
  }

}
