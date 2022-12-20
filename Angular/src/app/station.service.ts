import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Station } from './station';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class StationService {


  constructor(private http:HttpClient) { }

  getAllStations(): Observable<Station[]>{
    return this.http.get<Station[]>(`https://trip-scheduling-2back-trip-scheduling-2.apps.eu410.prod.nextcle.com/api/v1/station`);
  }
  createStation(Station:Station): Observable<Object>{
    return this.http.post<Station>(`https://trip-scheduling-2back-trip-scheduling-2.apps.eu410.prod.nextcle.com/api/v1/station`,Station);
  }
  deleteStation(id:number): Observable<any>{
    return this.http.delete(`https://trip-scheduling-2back-trip-scheduling-2.apps.eu410.prod.nextcle.com/api/v1/station/${id}`);
  }
  updateStation(id:number,Station:Station):Observable<any>{
    return this.http.put<Station>(`https://trip-scheduling-2back-trip-scheduling-2.apps.eu410.prod.nextcle.com/api/v1/station/${id}?name=${Station.name}`, null);
  }
}
