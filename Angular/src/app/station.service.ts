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
    return this.http.get<Station[]>(environment.apiUrl + `/station`);
  }
  createStation(Station:Station): Observable<Object>{
    return this.http.post<Station>(environment.apiUrl + `/station`,Station);
  }
  deleteStation(id:number): Observable<any>{
    return this.http.delete(environment.apiUrl + `/station/${id}`);
  }
  updateStation(id:number,Station:Station):Observable<any>{
    return this.http.put<Station>(environment.apiUrl + `/station/${id}?name=${Station.name}`, null);
  }
}
