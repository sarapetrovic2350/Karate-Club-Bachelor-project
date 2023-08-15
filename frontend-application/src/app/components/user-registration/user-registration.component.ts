import { Component, OnInit } from '@angular/core';
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
import {User} from "../../models/user.model";
import Swal from 'sweetalert2';
import {FormControl, Validators, FormGroup, FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {
  constructor(
    private router: Router,
    private userService: UserService
  ) { }
  title = 'Registration';
  user = new User();
  submitted = false;
  passwordRepeated: string= "";
  street: string = "";
  number: string = "";
  city: string= "";
  country: string="";
  isAdministrator: boolean = false;
  isCoach: boolean = false;

  ngOnInit(): void {
    let role = localStorage.getItem('role')

    if (role == "ADMINISTRATOR") {
      this.isAdministrator = true;
    }
    if (role == "COACH") {
      this.isCoach = true;
    }
  }
  email = new FormControl('', [Validators.required, Validators.email]);
  name = new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(30)])
  lastName = new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(30)])
  password = new FormControl('', [Validators.required, Validators.minLength(6), Validators.maxLength(30)])
  passwordConfirm = new FormControl('', [Validators.required, Validators.minLength(6), Validators.maxLength(30)])
  streetFormControl = new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(30)])
  streetNumberFormControl = new FormControl('', [Validators.required])
  cityFormControl = new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(30)])
  countryFormControl = new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(30)])
  roleFormControl = new FormControl( '', [Validators.required])
  beltFormControl = new FormControl( '', [Validators.required])
  genderFormControl = new FormControl( '', [Validators.required])
  licenceNumberFormControl = new FormControl('', [Validators.required])
  jmbgFormControl = new FormControl('', [Validators.required, Validators.minLength(13), Validators.maxLength(13)])


  getEmailErrorMessage() {
    return this.email.hasError('required') ? 'You must enter email' :
      this.email.hasError('email') ? 'Not a valid email' :
        '';
  }
  passwordMatchValidator() {
    return this.user.password === this.passwordRepeated
  }
  onSubmit() {
    let admin = this.userService.getCurrentUser()
    this.user.address.street = this.street;
    this.user.address.streetNumber = this.number;
    this.user.address.city = this.city;
    this.user.address.country = this.country;
    this.user.karateClub = admin.karateClub;
    if (this.isCoach) {
      this.user.userType = "STUDENT";
    }
    console.log(this.user);
    this.userService.registerUser(this.user).subscribe(
      {
        next: (res) => {
          this.router.navigate(['/login']);
          Swal.fire({
            icon: 'success',
            title: 'Success!',
            text: 'Successfully registered to Karate Club!',
          })

        },
        error: (e) => {
          this.submitted = false;
          console.log(e);
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Email already exists.',
          })

        }

      });
  }
}
