import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Station } from './station';

@Injectable({
  providedIn: 'root'
})
export class StationService {

  private baseUrl = "http://localhost:8080/api/v1/station";

  constructor(private http:HttpClient) { }

  getAllStations(): Observable<Station[]>{
    return this.http.get<Station[]>(`${this.baseUrl}`);
  }
  createStation(Station:Station): Observable<Object>{
    return this.http.post<Station>(this.baseUrl,Station);
  }
  deleteStation(id:number): Observable<any>{
    return this.http.delete(`http://localhost:8080/api/v1/station/${id}`);
  }
  updateStation(id:number,Station:Station):Observable<any>{
    return this.http.put<Station>(`http://localhost:8080/api/v1/station/${id}?name=${Station.name}`, null);
  }
}
