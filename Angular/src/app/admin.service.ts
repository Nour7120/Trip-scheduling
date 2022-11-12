import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { admin } from './admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  constructor(private http:HttpClient) { }

  signFirst(Admin:admin): Observable<Object>{
    return this.http.post<admin>('http://localhost:8080/api/v1/admin/signUp',Admin);
  }
  makeLogin(Admin:admin): Observable<Object>{
    return this.http.post<admin>('http://localhost:8080/api/v1/admin/signIn',Admin);
  }


}
