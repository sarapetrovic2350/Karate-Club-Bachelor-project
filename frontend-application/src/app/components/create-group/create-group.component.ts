import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {UserService} from "../../services/user.service";
import {GroupService} from "../../services/group.service";
import {Group} from "../../models/group.model";
import {User} from "../../models/user.model";
import {FormControl, Validators} from "@angular/forms";
import Swal from "sweetalert2";

@Component({
  selector: 'app-create-group',
  templateUrl: './create-group.component.html',
  styleUrls: ['./create-group.component.css']
})
export class CreateGroupComponent implements OnInit {
  title = 'New Group';
  submitted = false;
  coaches: User[] = [];
  chosenCoach: string = "";
  group = new Group();
  constructor(
    private router: Router,
    private userService: UserService,
    private groupService: GroupService
  ) { }
  ngOnInit(): void {

    this.userService.getAllCoaches().subscribe(
      {
        next: (res) => {
          this.coaches = res;

        },
        error: (e) => {
          console.log(e);
        }

      });
  }
  name = new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(30)])

  categoryFormControl = new FormControl( '', [Validators.required])

  onSubmit() {
    console.log(this.group)
    this.groupService.createGroup(this.group).subscribe(
      {
        next: (res) => {

          Swal.fire({
            icon: 'success',
            title: 'Success!',
            text: 'Successfully created new group in Karate Club!',
          })
          this.router.navigate(['/club-members']);

        },
        error: (e) => {
          this.submitted = false;
          console.log(e);
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Something went wrong.',
          })

        }

      });
  }
}
