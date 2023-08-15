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
