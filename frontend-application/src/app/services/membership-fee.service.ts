import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Group} from "../models/group.model";
import {MembershipFee} from "../models/membership-fee.model";

@Injectable({
  providedIn: 'root'
})
export class MembershipFeeService {

  apiHost: string = 'http://localhost:8091/membershipFee';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }
  payMembership(studentId: string) {
    return this.http.post<MembershipFee>(this.apiHost + '/payMembership/' + studentId, null);
  }
  checkIfMembershipIsPaidForMonth(studentId: string) {
    return this.http.get<boolean>(this.apiHost + '/checkIfMembershipIsPaidForMonth/' + studentId);
  }
  getMembershipFee(studentId: string) {
    return this.http.get<MembershipFee>(this.apiHost + '/getMembershipFee/' + studentId);
  }

}
