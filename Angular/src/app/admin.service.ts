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
    return this.http.post<admin>(environment.apiUrl + `/admin/signUp`,Admin);
  }
  makeLogin(Admin:admin): Observable<Object>{
    return this.http.post<admin>(environment.apiUrl + `/admin/signIn`,Admin);
  }


}
