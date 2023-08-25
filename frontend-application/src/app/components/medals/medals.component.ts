import { Component, OnInit } from '@angular/core';
import {DisciplineCompetition} from "../../models/discipline-competition.model";
import {Medal} from "../../models/medal.model";
import {MatTableDataSource} from "@angular/material/table";
import {User} from "../../models/user.model";
import {CompetitionService} from "../../services/competition.service";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-medals',
  templateUrl: './medals.component.html',
  styleUrls: ['./medals.component.css']
})
export class MedalsComponent implements OnInit {
  public medals: Medal[] = [];
  public dataSourceMedals= new MatTableDataSource<Medal>();
  public displayedColumnsMedals = ['competitionName', 'date', 'medal', 'student', 'discipline', 'gender category', 'group category', 'weight category'];
  public loggedInUser: User;
  constructor(private competitionService: CompetitionService, private userService: UserService) { }

  ngOnInit(): void {
    this.loggedInUser = this.userService.getCurrentUser();
    this.competitionService.getCompetitionMedalsForKarateClub(this.loggedInUser.karateClub.clubId).subscribe(res => {
      this.medals = res;
      this.dataSourceMedals.data = this.medals;
    })
  }

}
