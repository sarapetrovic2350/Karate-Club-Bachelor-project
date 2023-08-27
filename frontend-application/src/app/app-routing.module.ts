import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
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
import {RoleGuardService} from "./services/role-guard.service";
import {ForbiddenComponent} from "./components/forbidden/forbidden.component";
import {Role} from "./models/user.model";

const routes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'user-profile',
    component: UpdateUserComponent,
    canActivate: [RoleGuardService],
    data: {
      roles: [Role.Coach, Role.Admin, Role.Student]
    }
  },
  {
    path: 'user-registration',
    component: UserRegistrationComponent,
    canActivate: [RoleGuardService],
    data: {
      roles: [Role.Coach, Role.Admin]
    }
  },
  {
    path: 'create-group',
    component: CreateGroupComponent,
    canActivate: [RoleGuardService],
    data: {
      roles: [Role.Admin]
    }
  },
  {
    path: 'club-members',
    component: ClubMembersComponent,
    canActivate: [RoleGuardService],
    data: {
      roles: [Role.Coach, Role.Admin]
    }
  },
  {
    path: 'group-info',
    component: StudentGroupInfoComponent,
    canActivate: [RoleGuardService],
    data: {
      roles: [Role.Student]
    }
  },
  {
    path: 'competitions',
    component: CompetitionsComponent,
    canActivate: [RoleGuardService],
    data: {
      roles: [Role.Coach, Role.Admin, Role.Student]
    }
  },
  {
    path: 'calendar',
    component: CalendarComponent,
    canActivate: [RoleGuardService],
    data: {
      roles: [Role.Coach, Role.Admin, Role.Student]
    }
  },
  {
    path: 'upcoming-competitions',
    component: UpcomingCompetitionsComponent,
    canActivate: [RoleGuardService],
    data: {
      roles: [Role.Student]
    }
  },
  {
    path: 'medals',
    component: MedalsComponent,
    canActivate: [RoleGuardService],
    data: {
      roles: [Role.Coach, Role.Admin, Role.Student]
    }
  },
  {
    path: 'disciplines-registered-students',
    component: DisciplinesRegisteredStudentsComponent,
    canActivate: [RoleGuardService],
    data: {
      roles: [Role.Coach, Role.Admin]
    }
  },
  {
    path: 'disciplines/:competitionId',
    component: DisciplinesComponent,
    canActivate: [RoleGuardService],
    data: {
      roles: [Role.Coach]
    }
  },
  {
    path: 'disciplines/:competitionId/register-student/:disciplineId',
    component: RegisterStudentToDisciplineComponent,
    canActivate: [RoleGuardService],
    data: {
      roles: [Role.Coach]
    }
  },
  {
    path: 'forbidden',
    component: ForbiddenComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
