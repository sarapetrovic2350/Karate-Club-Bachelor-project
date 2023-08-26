import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';
import { MatDialog } from '@angular/material/dialog';
import {ChangePasswordComponent} from "../change-password/change-password.component";
import {
  RegisteredStudentsToDisciplineComponent
} from "../registered-students-to-discipline/registered-students-to-discipline.component";
@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  constructor(private router: Router, private userService : UserService, private dialog: MatDialog) { }

  title = 'User profile';
  user = new User()
  passwordRepeated: string= "";
  submitted = false;

  ngOnInit(): void {
   this.getUser()
  }
  getUser() {
    this.user = this.userService.getCurrentUser();
    if (this.user != null) {
      this.userService.getUserByEmail(this.user.email).subscribe(res => {
        this.user = res;
      })
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
  getEmailErrorMessage() {
    return this.email.hasError('required') ? 'You must enter email' :
      this.email.hasError('email') ? 'Not a valid email' :
        '';
  }
  passwordMatchValidator() {
    return this.user.password === this.passwordRepeated
  }
  changePassword(user: User) {
    console.log(user);
    let dialogRef = this.dialog.open(ChangePasswordComponent, {
      data: user,
      autoFocus: false
    });

    dialogRef.afterClosed().subscribe((result: any) => {
      if (!result) return;
      if(result.event != 'cancel') this.getUser();
    });
  }
  update(){
    this.userService.updateUser(this.user).subscribe(
      {next: (res) => {
          this.router.navigate(['/user-profile']);
          Swal.fire({
            icon: 'success',
            title: 'Success!',
            text: 'Successfully updated!',
          })
        },
        error: (e) => {
          console.log(e);
          this.submitted = false;
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Check the fields again!',
          })
        }
      });

  }



}
