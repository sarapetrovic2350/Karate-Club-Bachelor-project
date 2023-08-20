import { Component, OnInit } from '@angular/core';
import {Competition} from "../../models/competition.model";
import {CompetitionService} from "../../services/competition.service";
import {UserService} from "../../services/user.service";
import Swal from "sweetalert2";
import {User} from "../../models/user.model";

@Component({
  selector: 'app-competitions',
  templateUrl: './competitions.component.html',
  styleUrls: ['./competitions.component.css']
})
export class CompetitionsComponent implements OnInit {
  competitions: Competition[] = [];
  page = 1;
  count = 0;
  pageSize = 3;
  isAdministrator: boolean = false;
  loggedInUser: User = new User();
  clubRegistered: boolean = false;
  constructor(private competitionService: CompetitionService, private userService: UserService) { }

  ngOnInit(): void {
    this.retrieveCompetitions();
    let role = localStorage.getItem('role')
    if (role === "ADMINISTRATOR") {
      this.isAdministrator = true;
    }
    this.loggedInUser = this.userService.getCurrentUser();
  }
  getRequestParams(page: number, pageSize: number): any {
    let params: any = {};

    if (page) {
      params[`page`] = page - 1;
    }

    if (pageSize) {
      params[`size`] = pageSize;
    }

    return params;
  }
  retrieveCompetitions(): void {
    const params = this.getRequestParams(this.page, this.pageSize);
    this.competitionService.getAllCompetitions(params).subscribe((data: any) => {
      this.competitions = data.competitions;
      this.count = data.totalItems;
      console.log(data);
      console.log(this.competitions);
    })
  }

  handlePageChange(event: number): void {
    this.page = event;
    console.log(this.page)
    this.retrieveCompetitions();
  }
  checkIfClubIsRegistered(competitionId: string) {
    this.competitionService.checkIfClubIsRegistered(competitionId, this.loggedInUser.karateClub.clubId).subscribe(
      {
        next: (res) => {
          this.clubRegistered = true;
        },
        error: (e) => {
          this.clubRegistered = false;
        }
      })
  }
  registerClubToCompetition(competitionId: string) {
    this.competitionService.registerClubToCompetition(competitionId, this.loggedInUser.karateClub.clubId).subscribe(
      {
        next: (res) => {
          Swal.fire({
            icon: 'success',
            title: 'Success!',
            text: 'Successfully registered karate club to competition!',
          })
        },
        error: (e) => {
          console.log(e);
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Something went wrong.',
          })
        }
      })
  }

}
