import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentGroupInfoComponent } from './student-group-info.component';

describe('StudentGroupInfoComponent', () => {
  let component: StudentGroupInfoComponent;
  let fixture: ComponentFixture<StudentGroupInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentGroupInfoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StudentGroupInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
