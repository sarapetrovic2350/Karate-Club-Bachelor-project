import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {AngularMaterialModule} from "./angular-material/angular-material.module";
import {HttpClientModule, HTTP_INTERCEPTORS} from "@angular/common/http";

import { SideNavComponent } from './components/side-nav/side-nav.component';
import { LoginComponent } from "./components/login/login.component";
import { UpdateUserComponent } from "./components/user-profile/update-user.component";
import {ReactiveFormsModule} from "@angular/forms";
import {UserRegistrationComponent} from "./components/user-registration/user-registration.component";
import { ClubMembersComponent } from './components/club-members/club-members.component';
import { StudentGroupInfoComponent } from './components/student-group-info/student-group-info.component';
import { CreateGroupComponent } from './components/create-group/create-group.component';
import { CompetitionsComponent } from './components/competitions/competitions.component';
import {NgxPaginationModule} from "ngx-pagination";
import { FullCalendarModule } from '@fullcalendar/angular';
import { CalendarComponent } from './components/calendar/calendar.component';
import { DisciplinesComponent } from './components/disciplines/disciplines.component';
import { RegisterStudentToDisciplineComponent } from './components/register-student-to-discipline/register-student-to-discipline.component';
import { UpcomingCompetitionsComponent } from './components/upcoming-competitions/upcoming-competitions.component';
import { MedalsComponent } from './components/medals/medals.component';
import { DisciplinesRegisteredStudentsComponent } from './components/disciplines-registered-students/disciplines-registered-students.component';
import { RegisteredStudentsToDisciplineComponent } from './components/registered-students-to-discipline/registered-students-to-discipline.component';
import { ChangePasswordComponent } from './components/change-password/change-password.component';
import { ForbiddenComponent } from './components/forbidden/forbidden.component';
import {JWT_OPTIONS, JwtHelperService} from "@auth0/angular-jwt";
import {AuthGuardService} from "./services/auth-guard.service";
import {TokenInterceptor} from "./interceptor/TokenInterceptor";
import { PayMembershipFeeComponent } from './components/pay-membership-fee/pay-membership-fee.component';
import { MembershipFeeComponent } from './components/membership-fee/membership-fee.component';
// @ts-ignore
@NgModule({
  declarations: [
    AppComponent,
    SideNavComponent,
    LoginComponent,
    UpdateUserComponent,
    UserRegistrationComponent,
    ClubMembersComponent,
    StudentGroupInfoComponent,
    CreateGroupComponent,
    CompetitionsComponent,
    CalendarComponent,
    DisciplinesComponent,
    RegisterStudentToDisciplineComponent,
    UpcomingCompetitionsComponent,
    MedalsComponent,
    DisciplinesRegisteredStudentsComponent,
    RegisteredStudentsToDisciplineComponent,
    ChangePasswordComponent,
    ForbiddenComponent,
    PayMembershipFeeComponent,
    MembershipFeeComponent,

  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        AngularMaterialModule,
        HttpClientModule,
        ReactiveFormsModule,
        NgxPaginationModule,
        FullCalendarModule

    ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    },
    AuthGuardService,
    { provide: JWT_OPTIONS, useValue: JWT_OPTIONS },
    JwtHelperService
  ],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class AppModule { }
