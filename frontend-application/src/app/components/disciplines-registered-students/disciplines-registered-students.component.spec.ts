import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisciplinesRegisteredStudentsComponent } from './disciplines-registered-students.component';

describe('DisciplinesRegisteredStudentsComponent', () => {
  let component: DisciplinesRegisteredStudentsComponent;
  let fixture: ComponentFixture<DisciplinesRegisteredStudentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisciplinesRegisteredStudentsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DisciplinesRegisteredStudentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
