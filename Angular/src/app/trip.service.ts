import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { trip } from './trip';

@Injectable({
  providedIn: 'root'
})
export class TripService {

  constructor(private http:HttpClient) { }
  getAllTrips(): Observable<trip[]>{
    return this.http.get<trip[]>(`https://trip-scheduling-2back-trip-scheduling-2.apps.eu410.prod.nextcle.com/api/v1/trip`);
  }
  createtrip(Trip:trip): Observable<Object>{
    return this.http.post<trip>(`https://trip-scheduling-2back-trip-scheduling-2.apps.eu410.prod.nextcle.com/api/v1/trip`,Trip);
  }
  deleteTrip(id:number):Observable<any>{
    return this.http.delete(`https://trip-scheduling-2back-trip-scheduling-2.apps.eu410.prod.nextcle.com/api/v1/trip/${id}`);
  }
  updateTripbyId(id:number,Trip:trip):Observable<object>{
    return this.http.put<trip>(`https://trip-scheduling-2back-trip-scheduling-2.apps.eu410.prod.nextcle.com/api/v1/trip/${id}?startTime=${Trip.startTime}&endTime=${Trip.endTime}&fromStation=${Trip.fromStation.name}&toStation=${Trip.toStation.name}`,null);
  }
}
