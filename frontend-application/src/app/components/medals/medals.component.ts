import {Component, OnInit} from '@angular/core';
import * as XLSX from 'xlsx';
import {Medal} from "../../models/medal.model";
import {MatTableDataSource} from "@angular/material/table";
import {User} from "../../models/user.model";
import {CompetitionService} from "../../services/competition.service";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-medals',
  templateUrl: './medals.component.html',
  styleUrls: ['./medals.component.css']
})
export class MedalsComponent implements OnInit {
  public medals: Medal[] = [];
  public dataSourceMedals= new MatTableDataSource<Medal>();
  public displayedColumnsMedals = ['competitionName', 'date', 'medal', 'student', 'discipline', 'gender category', 'group category', 'weight category'];
  public loggedInUser: User;
  fileName= 'ExcelSheet.xlsx';
  constructor(private competitionService: CompetitionService, private userService: UserService) { }

  ngOnInit(): void {
    this.loggedInUser = this.userService.getCurrentUser();
    this.competitionService.getCompetitionMedalsForKarateClub(this.loggedInUser.karateClub.clubId).subscribe(res => {
      this.medals = res;
      this.dataSourceMedals.data = this.medals;
    })
  }
  exportExcel(): void
  {
    /* pass here the table id */
    let element = document.getElementById('excel-table');
    const ws: XLSX.WorkSheet =XLSX.utils.table_to_sheet(element);
    /* generate workbook and add the worksheet */
    ws['!cols'] = [
      {wch: 25},
      {wch: 10},
      {wch: 10},
      {wch: 20},
      {wch: 15},
      {wch: 15},
      {wch: 15},
      {wch: 15}
    ];
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'Sheet1');

    /* save to file */
    XLSX.writeFile(wb, this.fileName);

  }
}
