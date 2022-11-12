import { Component, OnInit } from '@angular/core';
import { Station } from '../station';
import { StationService } from '../station.service';

@Component({
  selector: 'app-get-station',
  templateUrl: './get-station.component.html',
  styleUrls: ['./get-station.component.css']
})
export class GetStationComponent implements OnInit {
  Stations!:Station[];
  constructor(private stService:StationService) { }

  ngOnInit(): void {
  }

  get_station():void{
    this.stService.getAllStations().subscribe((data: Station[]) => {
      console.log(data);
      this.Stations = data;
    });
  }

}
