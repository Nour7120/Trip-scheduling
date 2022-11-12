import { Component, OnInit } from '@angular/core';
import { Station } from '../station';
import { StationService } from '../station.service';

@Component({
  selector: 'app-delete-station',
  templateUrl: './delete-station.component.html',
  styleUrls: ['./delete-station.component.css']
})
export class DeleteStationComponent implements OnInit {
  Station:Station = {"stationId":0, "name":""};
  constructor(private stService:StationService) { }

  ngOnInit(): void {
  }
  delete_station(id:number):void{
    this.stService.deleteStation(id).subscribe(data =>{console.log(data)});
  }

}
