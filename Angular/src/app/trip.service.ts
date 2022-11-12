import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { trip } from './trip';

@Injectable({
  providedIn: 'root'
})
export class TripService {

  constructor(private http:HttpClient) { }
  getAllTrips(): Observable<trip[]>{
    return this.http.get<trip[]>(`http://localhost:8080/api/v1/trip`);
  }
  createtrip(Trip:trip): Observable<Object>{
    return this.http.post<trip>(`http://localhost:8080/api/v1/trip`,Trip);
  }
  deleteTrip(id:number):Observable<any>{
    return this.http.delete(`http://localhost:8080/api/v1/trip/${id}`);
  }
  updateTripbyId(id:number,Trip:trip):Observable<object>{
    return this.http.put<trip>(`http://localhost:8080/api/v1/trip/${id}?startTime=${Trip.startTime}&endTime=${Trip.endTime}&fromStation=${Trip.fromStation.name}&toStation=${Trip.toStation.name}`,null);
  }
}
