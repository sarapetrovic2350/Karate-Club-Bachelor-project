import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {CalendarComponent} from "../calendar/calendar.component";
import Swal from "sweetalert2";
import {MembershipFeeService} from "../../services/membership-fee.service";

@Component({
  selector: 'app-pay-membership-fee',
  templateUrl: './pay-membership-fee.component.html',
  styleUrls: ['./pay-membership-fee.component.css']
})
export class PayMembershipFeeComponent implements OnInit {
  action: string = 'cancel';

  constructor(
    private membershipFeeService: MembershipFeeService,
    public dialogRef: MatDialogRef<CalendarComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any)  { }

  ngOnInit(): void {
    console.log(this.data)
  }
  closeDialog(): void {
    this.dialogRef.close({ event: this.action, data: this.data });
  }
  payMembershipFee() {
    this.membershipFeeService.payMembership(this.data.studentId).subscribe({
      next: () => {
        Swal.fire({
          icon: 'success',
          title: 'Success!',
          text: 'Successfully paid membership fee! You can now continue using application!',
        })
        this.closeDialog();
      },
      error: (error) => {
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Something went wrong! ',
        })
      },
    });
  }

}

