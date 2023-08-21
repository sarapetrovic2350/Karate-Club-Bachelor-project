import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthRequest } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router,
    private userService: UserService) {

   }
  title = 'Login';
  message: string= "";
  request = new AuthRequest();
  submitted = false;

  ngOnInit(): void {
  }

  onSubmit() {
    if (this.request.email == '' || this.request.password == '') {
      this.message = 'Email or password missing.';
    } else {
      this.submitted = true;
      this.userService.login(this.request).subscribe(
        {
          next: (res) => {
            window.location.href = '/calendar'
            this.successfulLogin(res);
            Swal.fire({
              icon: 'success',
              title: 'Success!',
              text: 'Successfully logged in!',
            })


          },
          error: (e) => {
            this.submitted = false;
            console.log(e);
            Swal.fire({
              icon: 'error',
              title: 'Oops...',
              text: 'Invalid email or password.',
            })

          }
        });

    }
  }
  successfulLogin(data: any) {
    this.userService.setLoggedUser(data);
  }

}
