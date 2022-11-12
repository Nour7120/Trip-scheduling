import { Component, OnInit } from '@angular/core';
import { TripService } from '../trip.service';
import { trip } from '../trip';

@Component({
  selector: 'app-add-trip',
  templateUrl: './add-trip.component.html',
  styleUrls: ['./add-trip.component.css']
})
export class AddTripComponent implements OnInit {
  Trip:trip = {
    "tripId":0,
    "startTime": "",
    "endTime": "",
    "fromStation":{"stationId": 0, "name": ""},
    "toStation":{"stationId": 0, "name": ""}
  };
  constructor(private trService:TripService) { }

  ngOnInit(): void {
  }
  add_trip():void{
    this.trService.createtrip(this.Trip).subscribe(data =>{console.log(data)});
  }
}
