export class MembershipFee {
  constructor(
    public membershipFeeId: string = '',
    public membershipFeeName: string = '',
    public paymentDate: string = '',
    public isPaidForMonth: string = '',
    public price: number,
    public studentId: string = '',
    public clubId: string = ''

  ) {
  }
}
