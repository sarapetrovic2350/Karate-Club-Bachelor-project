import { Component, OnInit } from '@angular/core';
import {Medal} from "../../models/medal.model";
import {MatTableDataSource} from "@angular/material/table";
import {User} from "../../models/user.model";
import {DisciplineRegisteredStudents} from "../../models/discipline-registered-students.model";
import {CompetitionService} from "../../services/competition.service";
import { MatDialog } from '@angular/material/dialog';
import {
  RegisteredStudentsToDisciplineComponent
} from "../registered-students-to-discipline/registered-students-to-discipline.component";

@Component({
  selector: 'app-disciplines-registered-students',
  templateUrl: './disciplines-registered-students.component.html',
  styleUrls: ['./disciplines-registered-students.component.css']
})
export class DisciplinesRegisteredStudentsComponent implements OnInit {
  public disciplines: DisciplineRegisteredStudents[] = [];
  public dataSourceDisciplines= new MatTableDataSource<DisciplineRegisteredStudents>();
  public displayedColumnsDisciplines = ['competitionName', 'date', 'discipline', 'gender category', 'group category', 'weight category', 'commands'];
  constructor(private competitionService: CompetitionService, private dialog: MatDialog) {}
  ngOnInit(): void {
    this.getAllDisciplinesCompetitions();
  }
  getAllDisciplinesCompetitions() {
    this.competitionService.getCompetitionsDisciplinesWithRegisteredStudents().subscribe(res => {
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
