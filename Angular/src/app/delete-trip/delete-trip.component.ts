import { Component, OnInit } from '@angular/core';
import { TripService } from '../trip.service';
import { trip } from '../trip';

@Component({
  selector: 'app-delete-trip',
  templateUrl: './delete-trip.component.html',
  styleUrls: ['./delete-trip.component.css']
})
export class DeleteTripComponent implements OnInit {
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
  delete_trip(id:number):void{
    this.trService.deleteTrip(id).subscribe(data =>{console.log(data)});
  }

}
