import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PayMembershipFeeComponent } from './pay-membership-fee.component';

describe('PayMembershipFeeComponent', () => {
  let component: PayMembershipFeeComponent;
  let fixture: ComponentFixture<PayMembershipFeeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PayMembershipFeeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PayMembershipFeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
