import {Component, Inject, OnInit} from '@angular/core';
import {ChangePassword, User} from "../../models/user.model";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {UpdateUserComponent} from "../user-profile/update-user.component";
import {UserService} from "../../services/user.service";
import Swal from "sweetalert2";

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {
  action: string = 'cancel';
  message: string = '';
  newPassword= new ChangePassword();
  constructor(
    private userService: UserService,
    public dialogRef: MatDialogRef<UpdateUserComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any)  { }

  ngOnInit(): void {
  }
  closeDialog(): void {
    this.dialogRef.close({ event: this.action, data: this.data });
  }
  changePassword(){
    if (!this.validatePassword()) {
      return
    }
    else {
      this.message = ""
      this.newPassword.email = this.data.email;
      console.log(this.newPassword)
      this.userService.changePassword(this.newPassword).subscribe({
        next: () => {
          Swal.fire({
            icon: 'success',
            title: 'Success!',
            text: 'Successfully changed password!',
          })
          this.closeDialog();
        },
        error: (error) => {
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Old password is not correct! ',
          })
        },
      });
    }
  }


  validatePassword() {
    if (this.newPassword.password.length < 6) {
      this.message = "Your password should contain at least 6 characters!";
      return false;
    } else if (this.newPassword.password !== this.newPassword.passwordRepeated) {
      this.message = "Passwords do not match!";
      return false;
    }
    return true;
  }
}
