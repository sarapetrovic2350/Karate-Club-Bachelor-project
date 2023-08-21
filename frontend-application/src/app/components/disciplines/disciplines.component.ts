import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params, Router} from "@angular/router";
import {CompetitionService} from "../../services/competition.service";
import {Discipline} from "../../models/discipline.model";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'app-disciplines',
  templateUrl: './disciplines.component.html',
  styleUrls: ['./disciplines.component.css']
})
export class DisciplinesComponent implements OnInit {
  public disciplinesKata: Discipline[] = [];
  public disciplinesKumite: Discipline[] = [];
  public dataSourceDisciplinesKata = new MatTableDataSource<Discipline>();
  public dataSourceDisciplinesKumite= new MatTableDataSource<Discipline>();
  public displayedColumnsDisciplinesKata = ['type', 'gender category', 'group category', 'commands'];
  public displayedColumnsDisciplinesKumite = ['type', 'gender category', 'group category', 'weight category', 'commands'];
  public competitionId: any;

  constructor(private route: ActivatedRoute, private router: Router, private competitionService: CompetitionService) { }

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      console.log(params['competitionId']);
      this.competitionId = params['competitionId'];
      this.competitionService.getDisciplinesForCompetition(params['competitionId']).subscribe(res => {
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
    });
  }
  selectStudent(disciplineId: string) {
      console.log(this.competitionId);
      this.router.navigate(['disciplines/' + this.competitionId + '/register-student/' + disciplineId])

  }

}
