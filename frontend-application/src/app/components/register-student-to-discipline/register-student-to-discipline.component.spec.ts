import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterStudentToDisciplineComponent } from './register-student-to-discipline.component';

describe('RegisterStudentToDisciplineComponent', () => {
  let component: RegisterStudentToDisciplineComponent;
  let fixture: ComponentFixture<RegisterStudentToDisciplineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterStudentToDisciplineComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisterStudentToDisciplineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
