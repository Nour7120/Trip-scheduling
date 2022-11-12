import { Component, OnInit } from '@angular/core';
import { admin } from '../admin';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  Admin:admin = {
    "email": "",
    "password": ""
  };
  constructor(private adminService:AdminService) { }

  ngOnInit(): void {

  }
  makeSignUp():void{
    this.adminService.signFirst(this.Admin).subscribe(data => console.log(data));
  }

}
