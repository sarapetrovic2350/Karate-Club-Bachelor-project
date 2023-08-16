import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {Ram} from "../../models/ram.model";
import {User} from "../../models/user.model";
import {UserService} from "../../services/user.service";

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
  constructor(private userService: UserService) { }


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
  }

}
