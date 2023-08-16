import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { HeaderComponent } from './components/header/header.component';
import {AngularMaterialModule} from "./angular-material/angular-material.module";
import { SymptomsCausesComponent } from './components/symptoms-causes/symptoms-causes.component';
import {HttpClientModule} from "@angular/common/http";
import { PurposesComponent } from './components/purposes/purposes.component';
import { SearchRamComponent } from './components/search-ram/search-ram.component';
import { CpuSearchComponent } from './components/cpu-search/cpu-search.component';
import { SsdSearchComponent } from './components/ssd-search/ssd-search.component';
import { UpgradeComponentComponent } from './components/upgrade-component/upgrade-component.component';
import { SimilarComputersComponent } from './components/similar-computers/similar-computers.component';
import { SideNavComponent } from './components/side-nav/side-nav.component';
import { LoginComponent } from "./components/login/login.component";
import { UpdateUserComponent } from "./components/user-profile/update-user.component";
import {ReactiveFormsModule} from "@angular/forms";
import {UserRegistrationComponent} from "./components/user-registration/user-registration.component";
import { ClubMembersComponent } from './components/club-members/club-members.component';
import { StudentGroupInfoComponent } from './components/student-group-info/student-group-info.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SymptomsCausesComponent,
    PurposesComponent,
    SearchRamComponent,
    CpuSearchComponent,
    SsdSearchComponent,
    UpgradeComponentComponent,
    SimilarComputersComponent,
    SideNavComponent,
    LoginComponent,
    UpdateUserComponent,
    UserRegistrationComponent,
    ClubMembersComponent,
    StudentGroupInfoComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        AngularMaterialModule,
        HttpClientModule,
        ReactiveFormsModule,

    ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class AppModule { }
