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

  public disciplines: DisciplineRegisteredStudents[] = [];
  public dataSourceDisciplines= new MatTableDataSource<DisciplineRegisteredStudents>();
  public displayedColumnsDisciplines = ['competitionName', 'date', 'discipline', 'gender category', 'group category', 'weight category', 'commands'];
  constructor(private competitionService: CompetitionService, private userService: UserService, private dialog: MatDialog) {}
  ngOnInit(): void {
    this.loggedInUser = this.userService.getCurrentUser();
    this.getAllDisciplinesCompetitions();
  }
  getAllDisciplinesCompetitions() {
    this.competitionService.getCompetitionsDisciplinesWithRegisteredStudents(this.loggedInUser.karateClub.clubId).subscribe(res => {
      this.disciplines = res;
      this.dataSourceDisciplines.data = this.disciplines;
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
