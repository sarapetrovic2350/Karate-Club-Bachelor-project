import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Competition} from "../models/competition.model";
import {Group} from "../models/group.model";
import {Discipline} from "../models/discipline.model";
import {DisciplineCompetition} from "../models/discipline-competition.model";

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
  getCompetitionsClubIsRegisteredTo(clubId: any): Observable<Competition[]> {
    return this.http.get<Competition[]>(this.apiHost + "/getCompetitionsClubIsRegisteredTo/" + clubId, {headers: this.headers});
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
  registerStudentToDiscipline(competitionId: string, disciplineId: string, userId: string) {
    let queryParams = new HttpParams()
    console.log(competitionId);
    console.log(userId);
    queryParams = queryParams.append("competitionId", competitionId)
    queryParams = queryParams.append("disciplineId", disciplineId)
    queryParams = queryParams.append("userId", userId)
    console.log(queryParams);
    return this.http.post<any>(this.apiHost + '/registerStudentToDisciplineForCompetition', null, {params: queryParams});
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
  getDisciplinesForCompetition(competitionId: any): Observable<Discipline[]> {
    return this.http.get<Discipline[]>(this.apiHost + '/getDisciplinesForCompetition/' + competitionId);
  }
  getDisciplinesOfCompetitionForStudent(userId: string): Observable<DisciplineCompetition[]> {
    return this.http.get<DisciplineCompetition[]>(this.apiHost + '/getDisciplinesOfCompetitionForStudent/' + userId);
  }

  getDisciplineByCompetitionDisciplineId(competitionId: any, disciplineId: any) {
    return this.http.get<Discipline>(this.apiHost + '/getDisciplineByCompetitionDisciplineId/' + competitionId + '/' + disciplineId);
  }
  getCompetitionById(competitionId: string) {
    return this.http.get<Competition>(this.apiHost + '/getCompetitionById/' + competitionId);
  }

}
