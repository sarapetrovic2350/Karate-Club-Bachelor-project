import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params, Router} from "@angular/router";
import { Discipline } from 'src/app/models/discipline.model';
import {User} from "../../models/user.model";
import {Group} from "../../models/group.model";
import {FormControl, Validators} from "@angular/forms";
import {CompetitionService} from "../../services/competition.service";
import {GroupService} from "../../services/group.service";
import {UserService} from "../../services/user.service";
import Swal from "sweetalert2";

@Component({
  selector: 'app-register-student-to-discipline',
  templateUrl: './register-student-to-discipline.component.html',
  styleUrls: ['./register-student-to-discipline.component.css']
})
export class RegisterStudentToDisciplineComponent implements OnInit {
  competitionName: string = ""
  discipline = new Discipline()
  groups: Group[] = [];
  students: User[] = [];
  submitted = false;
  userId: string = ""
  selectedGroup: Group;
  disciplineKumite: boolean = false

  constructor(private route: ActivatedRoute, private router: Router,
              private competitionService: CompetitionService,
              private groupService: GroupService,
              private userService: UserService) { }

  ngOnInit(): void {
    let user = this.userService.getCurrentUser();

    this.route.params.subscribe((params: Params) => {
      console.log(params['disciplineId']);
      console.log(params['competitionId']);
      this.competitionService.getDisciplineByCompetitionDisciplineId(params['competitionId'], params['disciplineId']).subscribe(res => {
       this.discipline = res;
       if(this.discipline.disciplineType == "KUMITE") {
         this.disciplineKumite = true;
       }

        })
      this.competitionService.getCompetitionById(params['competitionId']).subscribe(res => {
        this.competitionName = res.competitionName;

      })
    })
    this.groupService.getAllGroups(user.karateClub.clubId).subscribe(
      {
        next: (res: any) => {
          this.groups = res;
          console.log(this.groups)
        },
        error: (e) => {
          console.log(e);
        }
      });

  }
  findStudentsInGroup() {
    console.log(this.selectedGroup);
    this.userService.getStudentsInGroup(this.selectedGroup.groupId).subscribe(
      {
        next: (res: any) => {
          this.students = res;
          console.log(this.students)
        },
        error: (e) => {
          console.log(e);
        }
      });
  }
  groupFormControl = new FormControl( '', [Validators.required])
  studentFormControl = new FormControl( '', [Validators.required])
  onSubmit() {
    this.route.params.subscribe((params: Params) => {
    this.competitionService.registerStudentToDiscipline(params['competitionId'], params['disciplineId'], this.userId).subscribe(
      {
        next: (res) => {
          Swal.fire({
            icon: 'success',
            title: 'Success!',
            text: 'Successfully registered student to competition!',
          })
          //this.router.navigate(['/calendar']);
        },
        error: (e) => {
          this.submitted = false;
          console.log(e);
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Something went wrong.',
          })
        }
      })
  } )}
}
