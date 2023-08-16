import { Component, OnInit } from '@angular/core';
import {User} from "../../models/user.model";
import {UserService} from "../../services/user.service";
import {MatTableDataSource} from "@angular/material/table";
import {Group} from "../../models/group.model";

@Component({
  selector: 'app-student-group-info',
  templateUrl: './student-group-info.component.html',
  styleUrls: ['./student-group-info.component.css']
})
export class StudentGroupInfoComponent implements OnInit {
  public coaches: any[] = [];
  public dataSourceCoaches = new MatTableDataSource<any>();
  public displayedColumnsCoaches = ['name', 'surname', 'email', 'phoneNumber', 'licenceNumber'];

  public groups: Group[] = [];
  public dataSourceGroups = new MatTableDataSource<Group>();
  public displayedColumnsGroups = ['name', 'category', 'coach'];

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    let user = this.userService.getCurrentUser()
    this.groups[0] = user.group;
    this.coaches[0] = user.group.coach;
    this.dataSourceGroups.data = this.groups;
    this.dataSourceCoaches.data = this.coaches;
    console.log(user)

  }

}
