import { Component, OnInit } from '@angular/core';
import {Medal} from "../../models/medal.model";
import {MatTableDataSource} from "@angular/material/table";
import {User} from "../../models/user.model";
import {MembershipFee} from "../../models/membership-fee.model";
import {MembershipFeeService} from "../../services/membership-fee.service";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-membership-fee',
  templateUrl: './membership-fee.component.html',
  styleUrls: ['./membership-fee.component.css']
})
export class MembershipFeeComponent implements OnInit {
  public membershipFees: MembershipFee[] = [];
  public dataSourceFees= new MatTableDataSource<MembershipFee>();
  public displayedColumnsFees = ['name', 'price', 'date', 'paid'];
  public loggedInUser: User;
  constructor(private membershipFeeService: MembershipFeeService, private userService: UserService) { }

  ngOnInit(): void {
    this.loggedInUser = this.userService.getCurrentUser();
    this.membershipFeeService.getMembershipFee(this.loggedInUser.userId).subscribe(res => {
      this.membershipFees[0] = res;
      console.log(res)
      this.dataSourceFees.data = this.membershipFees;
    })
  }

}
