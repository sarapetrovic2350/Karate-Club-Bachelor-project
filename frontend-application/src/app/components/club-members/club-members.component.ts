import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {User} from "../../models/user.model";
import {UserService} from "../../services/user.service";
import {Group} from "../../models/group.model";
import {GroupService} from "../../services/group.service";
import * as XLSX from "xlsx";
const EXCEL_EXTENSION = '.xlsx';
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

  fileNameCoaches= 'ExcelSheetCoaches';
  fileNameStudents= 'ExcelSheetStudents';
  fileNameGroups= 'ExcelSheetGroups';

  constructor(private userService: UserService, private groupService: GroupService) { }

  ngOnInit(): void {
    let user = this.userService.getCurrentUser();
    this.userService.getAllClubCoaches(user.karateClub.clubId).subscribe(
      {
        next: (res) => {
          this.coaches = res;
          console.log(res)
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
  exportCoachesToExcel(): void {
    /* pass here the table id */
    let element = document.getElementById('excel-table-coaches');
    const ws: XLSX.WorkSheet =XLSX.utils.table_to_sheet(element, {dateNF:'mm/dd/yyyy;@',cellDates:true, raw: true});
    /* generate workbook and add the worksheet */
    ws['!cols'] = [
      {wch: 15},
      {wch: 15},
      {wch: 20},
      {wch: 15},
      {wch: 15},
    ];
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'Sheet1');

    /* save to file */
    XLSX.writeFile(wb, this.fileNameCoaches + '_date_' + new Date(Date.now()).toDateString() + EXCEL_EXTENSION);

  }
  exportStudentsToExcel(): void {
    /* pass here the table id */
    let element = document.getElementById('excel-table-students');
    const ws: XLSX.WorkSheet =XLSX.utils.table_to_sheet(element, {dateNF:'mm/dd/yyyy;@',cellDates:true, raw: true});
    /* generate workbook and add the worksheet */
    ws['!cols'] = [
      {wch: 15},
      {wch: 15},
      {wch: 20},
      {wch: 15},
      {wch: 15},
      {wch: 20},
    ];
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'Sheet1');

    /* save to file */
    XLSX.writeFile(wb, this.fileNameStudents + '_date_' + new Date(Date.now()).toDateString() + EXCEL_EXTENSION);

  }
  exportGroupsToExcel(): void {
    /* pass here the table id */
    let element = document.getElementById('excel-table-groups');
    const ws: XLSX.WorkSheet =XLSX.utils.table_to_sheet(element, {dateNF:'mm/dd/yyyy;@',cellDates:true, raw: true});
    /* generate workbook and add the worksheet */
    ws['!cols'] = [
      {wch: 18},
      {wch: 18},
      {wch: 18},
    ];
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'Sheet1');

    /* save to file */
    XLSX.writeFile(wb, this.fileNameGroups + '_date_' + new Date(Date.now()).toDateString() + EXCEL_EXTENSION);

  }
}
