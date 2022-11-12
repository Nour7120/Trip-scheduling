import { Component, OnInit } from '@angular/core';
import { TripService } from '../trip.service';
import { trip } from '../trip';

@Component({
  selector: 'app-update-trip',
  templateUrl: './update-trip.component.html',
  styleUrls: ['./update-trip.component.css']
})
export class UpdateTripComponent implements OnInit {
  Trip:trip = {
    "tripId":0,
    "startTime": "",
    "endTime": "",
    "fromStation":{"stationId": 0, "name": ""},
    "toStation":{"stationId": 0, "name": ""}
  };
  constructor(private trService: TripService) { }

  ngOnInit(): void {
  }
  update_trip(id:number):void{
    this.trService.updateTripbyId(id,this.Trip).subscribe(data =>console.log(data));
  }
}
