import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProfileDetailsComponent} from './profile-details/profile-details.component';

const routes: Routes = [
  { path: 'details/:id', component:ProfileDetailsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
