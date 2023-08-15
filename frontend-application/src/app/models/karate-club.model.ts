import {Address} from "./address.model";

export class KarateClub {
  constructor(
    public clubId: string = '',
    public phoneNumber: string = '',
    public name: string = '',
    public address: Address = new Address()

  ) {}
}
