import { Component, OnInit } from '@angular/core';
import {Competition} from "../../models/competition.model";
import {CompetitionService} from "../../services/competition.service";

@Component({
  selector: 'app-competitions',
  templateUrl: './competitions.component.html',
  styleUrls: ['./competitions.component.css']
})
export class CompetitionsComponent implements OnInit {
  competitions: Competition[] = [];
  page = 1;
  count = 0;
  pageSize = 3;
  constructor(private competitionService: CompetitionService) { }

  ngOnInit(): void {
    this.retrieveCompetitions();
  }
  getRequestParams(page: number, pageSize: number): any {
    let params: any = {};

    if (page) {
      params[`page`] = page - 1;
    }

    if (pageSize) {
      params[`size`] = pageSize;
    }

    return params;
  }
  retrieveCompetitions(): void {
    const params = this.getRequestParams(this.page, this.pageSize);
    this.competitionService.getAllCompetitions(params).subscribe((data: any) => {
      this.competitions = data.competitions;
      this.count = data.totalItems;
      console.log(data);
      console.log(this.competitions);
    })
  }

  handlePageChange(event: number): void {
    this.page = event;
    console.log(this.page)
    this.retrieveCompetitions();
  }

}
