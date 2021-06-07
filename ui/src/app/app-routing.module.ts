import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClubdetailsComponent } from './clubdetails/clubdetails.component'; // Add this
import { MatchdetailsComponent } from './matchdetails/matchdetails.component';
import {Routes,RouterModule} from "@angular/router";

const routes: Routes = [
  { path: '', component: ClubdetailsComponent },              // Add this
  { path: 'matchdetails', component: MatchdetailsComponent }           // Add this
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
