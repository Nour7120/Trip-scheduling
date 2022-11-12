import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Station } from '../station';
import { StationService } from '../station.service';

@Component({
  selector: 'app-update-station',
  templateUrl: './update-station.component.html',
  styleUrls: ['./update-station.component.css']
})
export class UpdateStationComponent implements OnInit {

  Station:Station = {"stationId":0, "name": ""};
  constructor(private stService:StationService) { }

  ngOnInit(): void {
  }
  update_station(id:number):void{
    this.stService.updateStation(id,this.Station).subscribe(data => console.log(data));
  }
}
