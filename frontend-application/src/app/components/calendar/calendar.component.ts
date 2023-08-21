import { Component, OnInit } from '@angular/core';
import { CalendarOptions } from '@fullcalendar/core'; // useful for typechecking
import dayGridPlugin from '@fullcalendar/daygrid';
import {CompetitionService} from "../../services/competition.service";
import {Competition} from "../../models/competition.model";
import {UserService} from "../../services/user.service";
import {User} from "../../models/user.model";

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements OnInit {
  public competitions: Competition[] = [];
  private currentUser: User;
  private clubId: string = "";
  calendarOptions: CalendarOptions = {
    initialView: 'dayGridMonth',
    height: 500,
    plugins: [dayGridPlugin],
    eventColor: '#0b349a',
    //dateClick: this.handleDateClick.bind(this), // MUST ensure `this` context is maintained
    // events: [
    //   { title: 'event 1', date: '2023-08-21' },
    //   { title: 'event 2', date: '2019-04-02' }
    // ]


  };
  public events: any;

  handleDateClick(arg) {
    alert('date click! ' + arg.dateStr)
  }

  constructor(private competitionService: CompetitionService, private userService: UserService) {
  }

  ngOnInit(): void {
    this.currentUser = this.userService.getCurrentUser();
    this.clubId = this.currentUser.karateClub.clubId;
    this.findEvents();
  }

  findEvents() {

    this.competitionService.getCompetitionsClubIsRegisteredTo(this.clubId).subscribe(
      {
        next: (res) => {
        this.competitions = res;
        console.log(this.competitions)
          this.events = [];
          for (let i = 0; i < this.competitions.length; i++) {
            let y = this.competitions[i].date[0]
            var m = this.competitions[i].date[1]
            console.log(m.toString().length)
            if (m.toString().length == 1) {
              m = '0' + m;
            }
            let d = this.competitions[i].date[2]
            if (d.toString().length == 1) {
              d = '0' + d;
            }
            this.events.push({
              title: this.competitions[i].competitionName + ' ' + this.competitions[i].place,
              start: y + '-' + m +'-' +d,
              resizable: {
                beforeStart: true,
                afterEnd: true,
              },
              draggable: true,
            })
          }
          console.log(this.events)
          this.calendarOptions.events = this.events
          for(let i = 0; i < this.events.length; i++) {
            this.calendarOptions.events[i] = this.events[i];
          }
        }

  })

  }

}

