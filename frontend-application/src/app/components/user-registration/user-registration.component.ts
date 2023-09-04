import { Component, OnInit } from '@angular/core';
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
import {User} from "../../models/user.model";
import Swal from 'sweetalert2';
import {FormControl, Validators, FormGroup, FormBuilder} from '@angular/forms';
import {Group} from "../../models/group.model";
import {GroupService} from "../../services/group.service";

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {
  constructor(
    private router: Router,
    private userService: UserService,
    private groupService: GroupService
  ) { }
  title = 'Registration';
  user = new User();
  loggedInUser = new User();
  submitted = false;
  passwordRepeated: string= "";
  street: string = "";
  number: string = "";
  city: string= "";
  country: string="";
  isAdministrator: boolean = false;
  isCoach: boolean = false;
  groups: Group[] = [];
  groupsForStudents: Group[] = [];
  availableGroupsForCoach: Group[] = [];
  chosenGroup: string = "";
  noAvailableGroups: boolean = false;

  ngOnInit(): void {
    this.loggedInUser = this.userService.getCurrentUser();
    let role = localStorage.getItem('role')

    if (role == "ROLE_ADMINISTRATOR") {
      this.isAdministrator = true;
    }
    if (role == "ROLE_COACH") {
      this.isCoach = true;
    }
    this.groupService.getAllGroups(this.loggedInUser.karateClub.clubId).subscribe((data:any) => {
      console.log(data);
      this.groupsForStudents = data;
    })

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

  groupFormControl = new FormControl( '', [Validators.required])
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
    this.user.groupId = this.chosenGroup;
    console.log(this.chosenGroup)
    if (this.isCoach) {
      this.user.userType = "STUDENT";
    }
    if (this.user.userType == "COACH") {
      this.user.beltColor = "BLACK";
    }
    console.log(this.user);
    this.userService.registerUser(this.user).subscribe(
      {
        next: (res) => {

          Swal.fire({
            icon: 'success',
            title: 'Success!',
            text: 'Successfully registered to Karate Club!',
          })
          this.router.navigate(['/club-members']);

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

  findAvailableGroups() {
    this.groupService.getAllGroups(this.loggedInUser.karateClub.clubId).subscribe((data:any) => {
      console.log(data);

      if(this.user.userType == "COACH") {
        this.groupService.getAllGroupsWithoutCoach().subscribe(
          {
            next: (res: any) => {

              this.availableGroupsForCoach = res;
              this.noAvailableGroups = false;
              this.groups = this.availableGroupsForCoach
              console.log(this.groups)
              if(this.groups.length == 0) {
                this.noAvailableGroups = true;
              }

            },
            error: (e) => {
              console.log(e);
            }

          });
      }
      else {
        this.groups = data;
        this.availableGroupsForCoach = [];
        this.noAvailableGroups = false;
      }
    })
  }
}
