import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SymptomsCausesComponent} from "./components/symptoms-causes/symptoms-causes.component";
import {PurposesComponent} from "./components/purposes/purposes.component";
import { SearchRamComponent } from './components/search-ram/search-ram.component';
import { CpuSearchComponent } from './components/cpu-search/cpu-search.component';
import { SsdSearchComponent } from './components/ssd-search/ssd-search.component';
import { UpgradeComponentComponent } from './components/upgrade-component/upgrade-component.component';
import {SimilarComputersComponent} from "./components/similar-computers/similar-computers.component";
import { LoginComponent} from "./components/login/login.component";
import  { UpdateUserComponent } from "./components/user-profile/update-user.component";
import {UserRegistrationComponent} from "./components/user-registration/user-registration.component";
import {ClubMembersComponent} from "./components/club-members/club-members.component";
import {StudentGroupInfoComponent} from "./components/student-group-info/student-group-info.component";
import {CreateGroupComponent} from "./components/create-group/create-group.component";
import {CompetitionsComponent} from "./components/competitions/competitions.component";

const routes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path:'purposes',
    component: PurposesComponent
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
    path:'search-ram',
    component: SearchRamComponent
  },
  {
    path:'cpuSearch',
    component: CpuSearchComponent
  },
  {
    path:'ssdSearch',
    component: SsdSearchComponent
  },
  {
    path:'upgrade-component',
    component: UpgradeComponentComponent
  },
  {
    path:'similar-computers',
    component: SimilarComputersComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
