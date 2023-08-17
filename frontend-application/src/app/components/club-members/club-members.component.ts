import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {User} from "../../models/user.model";
import {UserService} from "../../services/user.service";
import {Group} from "../../models/group.model";
import {GroupService} from "../../services/group.service";

@Component({
  selector: 'app-club-members',
  templateUrl: './club-members.component.html',
  styleUrls: ['./club-members.component.css']
})
export class ClubMembersComponent implements OnInit {

  public coaches: User[] = [];
  public dataSourceCoaches = new MatTableDataSource<User>();
  public displayedColumnsCoaches = ['name', 'surname', 'email', 'phoneNumber', 'licenceNumber'];

  public students: User[] = [];
  public dataSourceStudents = new MatTableDataSource<User>();
  public displayedColumnsStudents = ['name', 'surname', 'email', 'phoneNumber', 'beltColor', 'group'];

  public groups: Group[] = [];
  public groupsWithoutCoach: Group[] = [];
  public dataSourceGroups = new MatTableDataSource<Group>();
  public dataSourceGroupsWithoutCoaches = new MatTableDataSource<Group>();
  public displayedColumnsGroups = ['name', 'category', 'coach'];

  constructor(private userService: UserService, private groupService: GroupService) { }

  ngOnInit(): void {

    this.userService.getAllCoaches().subscribe(
      {
        next: (res) => {
          this.coaches = res;
          this.dataSourceCoaches.data = this.coaches

        },
        error: (e) => {
          console.log(e);
        }

      });
    this.userService.getAllStudents().subscribe(
      {
        next: (res) => {
          this.students = res;
          this.dataSourceStudents.data = this.students

        },
        error: (e) => {
          console.log(e);
        }

      });
    this.groupService.getAllGroups().subscribe(
      {
        next: (res: any) => {
          for (let i=0; i < res.length; i++) {
            if (res[i].coach == null) {
              this.groupsWithoutCoach.push(res[i]);
            }
            else {
              this.groups.push(res[i]);
            }
          }
          this.dataSourceGroups.data = this.groups
          this.dataSourceGroupsWithoutCoaches.data = this.groupsWithoutCoach

          console.log(this.groups)
        },
        error: (e) => {
          console.log(e);
        }

      });

  }

}
