import { Component, OnInit } from '@angular/core';
import { Station } from '../station';
import { StationService } from '../station.service';

@Component({
  selector: 'app-add-station',
  templateUrl: './add-station.component.html',
  styleUrls: ['./add-station.component.css']
})
export class AddStationComponent implements OnInit {
  Station:Station = {"stationId":0,"name": ""};
  constructor(private stservice:StationService) {}

  ngOnInit(): void {
  }
  add_Station():void{
    this.stservice.createStation(this.Station).subscribe(data =>{console.log(data)});
  }

}
