import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddStationComponent } from './add-station/add-station.component';
import { AddTripComponent } from './add-trip/add-trip.component';
import { DeleteStationComponent } from './delete-station/delete-station.component';
import { DeleteTripComponent } from './delete-trip/delete-trip.component';
import { GetStationComponent } from './get-station/get-station.component';
import { GetTripComponent } from './get-trip/get-trip.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { StationPageComponent } from './station-page/station-page.component';
import { TripPageComponent } from './trip-page/trip-page.component';
import { UpdateStationComponent } from './update-station/update-station.component';
import { UpdateTripComponent } from './update-trip/update-trip.component';

const routes: Routes = [
  {path:'signUp',component:SignUpComponent},
  {path:'login',component:LoginComponent},
  {path:'home',component:HomeComponent},
  {path:'tripPage',component:TripPageComponent},
  {path:'stationPage',component:StationPageComponent},
  {path:'addStation',component:AddStationComponent},
  {path:'getStation',component:GetStationComponent},
  {path:'updateStation',component:UpdateStationComponent},
  {path:'deleteStation',component:DeleteStationComponent},
  {path:'addTrip',component:AddTripComponent},
  {path:'getTrip',component:GetTripComponent},
  {path:'updateTrip',component:UpdateTripComponent},
  {path:'deleteTrip',component:DeleteTripComponent},
  {path:'',redirectTo:'signUp',pathMatch:'full'},
  {path:'**',redirectTo:'signUp',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
