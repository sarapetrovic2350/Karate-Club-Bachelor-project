import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {DisciplineRegisteredStudents} from "../../models/discipline-registered-students.model";
import {CompetitionService} from "../../services/competition.service";
import { MatDialog } from '@angular/material/dialog';
import {
  RegisteredStudentsToDisciplineComponent
} from "../registered-students-to-discipline/registered-students-to-discipline.component";
import {UserService} from "../../services/user.service";
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-disciplines-registered-students',
  templateUrl: './disciplines-registered-students.component.html',
  styleUrls: ['./disciplines-registered-students.component.css']
})
export class DisciplinesRegisteredStudentsComponent implements OnInit {
  loggedInUser= new User();

  public disciplinesKata: DisciplineRegisteredStudents[] = [];
  public dataSourceDisciplinesKata= new MatTableDataSource<DisciplineRegisteredStudents>();
  public disciplinesKumite: DisciplineRegisteredStudents[] = [];
  public dataSourceDisciplinesKumite= new MatTableDataSource<DisciplineRegisteredStudents>();
  public displayedColumnsDisciplinesKumite = ['competitionName', 'date', 'discipline', 'gender category', 'group category', 'weight category', 'commands'];
  public displayedColumnsDisciplinesKata = ['competitionName', 'date', 'discipline', 'gender category', 'group category', 'commands'];
  constructor(private competitionService: CompetitionService, private userService: UserService, private dialog: MatDialog) {}
  ngOnInit(): void {
    this.loggedInUser = this.userService.getCurrentUser();
    this.getAllDisciplinesCompetitions();
  }
  getAllDisciplinesCompetitions() {
    this.competitionService.getCompetitionsDisciplinesWithRegisteredStudents(this.loggedInUser.karateClub.clubId).subscribe(res => {
      for(let i = 0; i < res.length; i ++) {
        if(res[i].disciplineType == "KATA") {
          this.disciplinesKata.push(res[i])
        }
        else {
          this.disciplinesKumite.push(res[i])
        }
      }
      this.dataSourceDisciplinesKata.data = this.disciplinesKata;
      this.dataSourceDisciplinesKumite.data = this.disciplinesKumite;
    })
  }
  viewStudents(discipline: DisciplineRegisteredStudents) {
    console.log(discipline);
    let dialogRef = this.dialog.open(RegisteredStudentsToDisciplineComponent, {
      data: discipline,
      autoFocus: false
    });

    dialogRef.afterClosed().subscribe((result: any) => {
      if (!result) return;
      if(result.event != 'cancel') this.getAllDisciplinesCompetitions();
    });
  }

}
