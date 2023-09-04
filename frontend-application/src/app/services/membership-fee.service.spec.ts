import { TestBed } from '@angular/core/testing';

import { MembershipFeeService } from './membership-fee.service';

describe('MembershipFeeService', () => {
  let service: MembershipFeeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MembershipFeeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
