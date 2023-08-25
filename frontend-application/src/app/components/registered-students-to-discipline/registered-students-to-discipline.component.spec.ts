import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisteredStudentsToDisciplineComponent } from './registered-students-to-discipline.component';

describe('RegisteredStudentsToDisciplineComponent', () => {
  let component: RegisteredStudentsToDisciplineComponent;
  let fixture: ComponentFixture<RegisteredStudentsToDisciplineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisteredStudentsToDisciplineComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisteredStudentsToDisciplineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
