import { Component, OnInit } from '@angular/core';
import { TripService } from '../trip.service';
import { trip } from '../trip';

@Component({
  selector: 'app-get-trip',
  templateUrl: './get-trip.component.html',
  styleUrls: ['./get-trip.component.css']
})
export class GetTripComponent implements OnInit {
  Trips!:trip[];
  constructor(private trService:TripService) { }

  ngOnInit(): void {
  }
  get_trip():void{
    this.trService.getAllTrips().subscribe((data: trip[]) => {
      console.log(data);
      this.Trips = data;
      console.log(this.Trips.length);
    });
 }

}
