import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {UpdateUserComponent} from "./components/user-profile/update-user.component";
import {UserRegistrationComponent} from "./components/user-registration/user-registration.component";
import {ClubMembersComponent} from "./components/club-members/club-members.component";
import {StudentGroupInfoComponent} from "./components/student-group-info/student-group-info.component";
import {CreateGroupComponent} from "./components/create-group/create-group.component";
import {CompetitionsComponent} from "./components/competitions/competitions.component";
import {CalendarComponent} from "./components/calendar/calendar.component";
import {DisciplinesComponent} from "./components/disciplines/disciplines.component";
import {
  RegisterStudentToDisciplineComponent
} from "./components/register-student-to-discipline/register-student-to-discipline.component";
import {UpcomingCompetitionsComponent} from "./components/upcoming-competitions/upcoming-competitions.component";
import {MedalsComponent} from "./components/medals/medals.component";
import {
  DisciplinesRegisteredStudentsComponent
} from "./components/disciplines-registered-students/disciplines-registered-students.component";

const routes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'user-profile',
    component: UpdateUserComponent
  },
  {
    path: 'user-registration',
    component: UserRegistrationComponent
  },
  {
    path: 'create-group',
    component: CreateGroupComponent
  },
  {
    path: 'club-members',
    component: ClubMembersComponent
  },
  {
    path: 'group-info',
    component: StudentGroupInfoComponent
  },
  {
    path: 'competitions',
    component: CompetitionsComponent
  },
  {
    path: 'calendar',
    component: CalendarComponent
  },
  {
    path: 'upcoming-competitions',
    component: UpcomingCompetitionsComponent
  },
  {
    path: 'medals',
    component: MedalsComponent
  },
  {
    path: 'disciplines-registered-students',
    component: DisciplinesRegisteredStudentsComponent
  },
  {
    path: 'disciplines/:competitionId',
    component: DisciplinesComponent
  },
  {
    path: 'disciplines/:competitionId/register-student/:disciplineId',
    component: RegisterStudentToDisciplineComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
