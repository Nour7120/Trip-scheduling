import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LoginComponent } from './login/login.component';
import { UpdateStationComponent } from './update-station/update-station.component';
import { AddStationComponent } from './add-station/add-station.component';
import { DeleteStationComponent } from './delete-station/delete-station.component';
import { GetStationComponent } from './get-station/get-station.component';
import { UpdateTripComponent } from './update-trip/update-trip.component';
import { AddTripComponent } from './add-trip/add-trip.component';
import { DeleteTripComponent } from './delete-trip/delete-trip.component';
import { GetTripComponent } from './get-trip/get-trip.component';
import { HomeComponent } from './home/home.component';
import { TripPageComponent } from './trip-page/trip-page.component';
import { StationPageComponent } from './station-page/station-page.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    SignUpComponent,
    LoginComponent,
    UpdateStationComponent,
    AddStationComponent,
    DeleteStationComponent,
    GetStationComponent,
    UpdateTripComponent,
    AddTripComponent,
    DeleteTripComponent,
    GetTripComponent,
    HomeComponent,
    TripPageComponent,
    StationPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
