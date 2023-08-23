import { Component, OnInit } from '@angular/core';
import {Discipline} from "../../models/discipline.model";
import {MatTableDataSource} from "@angular/material/table";
import {DisciplineCompetition} from "../../models/discipline-competition.model";
import {CompetitionService} from "../../services/competition.service";
import {UserService} from "../../services/user.service";
import {User} from "../../models/user.model";

@Component({
  selector: 'app-upcoming-competitions',
  templateUrl: './upcoming-competitions.component.html',
  styleUrls: ['./upcoming-competitions.component.css']
})
export class UpcomingCompetitionsComponent implements OnInit {
  public disciplinesKata: DisciplineCompetition[] = [];
  public disciplinesKumite: DisciplineCompetition[] = [];
  public dataSourceDisciplinesKata = new MatTableDataSource<DisciplineCompetition>();
  public dataSourceDisciplinesKumite= new MatTableDataSource<DisciplineCompetition>();
  public displayedColumnsDisciplinesKata = ['competitionName', 'date','type', 'gender category', 'group category'];
  public displayedColumnsDisciplinesKumite = ['competitionName', 'date','type', 'gender category', 'group category', 'weight category'];
  public competitionId: any;

  public loggedInUser: User;
  constructor(private competitionService: CompetitionService, private userService: UserService) { }

  ngOnInit(): void {
    this.loggedInUser = this.userService.getCurrentUser();
    this.competitionService.getDisciplinesOfCompetitionForStudent(this.loggedInUser.userId).subscribe(res => {
      for (let i=0; i < res.length; i++) {
        if (res[i].weightCategory == null) {
          this.disciplinesKata.push(res[i]);
        }
        else {
          this.disciplinesKumite.push(res[i]);
        }
      }

      this.dataSourceDisciplinesKata.data = this.disciplinesKata;
      this.dataSourceDisciplinesKumite.data = this.disciplinesKumite;
    })
  }

}
