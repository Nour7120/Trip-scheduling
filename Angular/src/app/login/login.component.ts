import { Component, OnInit } from '@angular/core';
import { admin } from '../admin';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  Admin:admin = {
    "email": "",
    "password": ""
  };
  constructor(private adminService:AdminService) { }

  ngOnInit(): void {

  }
  makeLogin():void{
    this.adminService.makeLogin(this.Admin).subscribe(data => console.log(data));
  }


}
