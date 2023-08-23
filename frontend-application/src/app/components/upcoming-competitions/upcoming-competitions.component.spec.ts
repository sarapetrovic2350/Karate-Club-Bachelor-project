import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpcomingCompetitionsComponent } from './upcoming-competitions.component';

describe('UpcomingCompetitionsComponent', () => {
  let component: UpcomingCompetitionsComponent;
  let fixture: ComponentFixture<UpcomingCompetitionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpcomingCompetitionsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpcomingCompetitionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
