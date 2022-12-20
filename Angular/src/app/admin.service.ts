import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { admin } from './admin';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  constructor(private http:HttpClient) { }

  signFirst(Admin:admin): Observable<Object>{
    return this.http.post<admin>(`https://trip-scheduling-2back-trip-scheduling-2.apps.eu410.prod.nextcle.com/api/v1/admin/signUp`,Admin);
  }
  makeLogin(Admin:admin): Observable<Object>{
    return this.http.post<admin>(`https://trip-scheduling-2back-trip-scheduling-2.apps.eu410.prod.nextcle.com/api/v1/admin/signIn`,Admin);
  }


}
