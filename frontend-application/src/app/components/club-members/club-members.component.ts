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
    let user = this.userService.getCurrentUser();
    this.userService.getAllClubCoaches(user.karateClub.clubId).subscribe(
      {
        next: (res) => {
          this.coaches = res;
          this.dataSourceCoaches.data = this.coaches

        },
        error: (e) => {
          console.log(e);
        }

      });
    this.userService.getAllClubStudents(user.karateClub.clubId).subscribe(
      {
        next: (res) => {
          this.students = res;
          this.dataSourceStudents.data = this.students

        },
        error: (e) => {
          console.log(e);
        }

      });
    this.groupService.getAllGroups(user.karateClub.clubId).subscribe(
      {
        next: (res: any) => {

          this.groups = res;
          this.dataSourceGroups.data = this.groups

        },
        error: (e) => {
          console.log(e);
        }

      });

    this.groupService.getAllGroupsWithoutCoach().subscribe(
      {
        next: (res: any) => {

          this.groupsWithoutCoach = res;
          this.dataSourceGroupsWithoutCoaches.data = this.groupsWithoutCoach

        },
        error: (e) => {
          console.log(e);
        }

      });

  }

}
