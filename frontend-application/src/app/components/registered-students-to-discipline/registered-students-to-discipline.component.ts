import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {DisciplinesRegisteredStudentsComponent } from "../disciplines-registered-students/disciplines-registered-students.component";

@Component({
  selector: 'app-registered-students-to-discipline',
  templateUrl: './registered-students-to-discipline.component.html',
  styleUrls: ['./registered-students-to-discipline.component.css']
})
export class RegisteredStudentsToDisciplineComponent implements OnInit {
  action: string = 'cancel';
  public displayedColumns = ['student', 'group', 'coach'];
  constructor(public dialogRef: MatDialogRef<DisciplinesRegisteredStudentsComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any)  { }

  ngOnInit(): void {
  }

  closeDialog(): void {
    this.dialogRef.close({ event: this.action, data: this.data });
  }
}
