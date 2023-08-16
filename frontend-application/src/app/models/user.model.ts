import { Address } from "./address.model";
import {KarateClub} from "./karate-club.model";
import {Group} from "./group.model";

export class User {
    constructor(
        public userId: string = '',
        public email: string = '',
        public password: string = '',
        public name: string = '',
        public surname: string = '',
        public phoneNumber: string = '',
        public address: Address = new Address(),
        public karateClub: KarateClub = new KarateClub(),
        public jmbg: string = "",
        public gender: string = '',
        public userType: string='',
        public licenceNumber: string = '',
        public beltColor: string = '',
        public groupId: string = "",
      ) {}
}

export class AuthRequest {
  constructor(public email: string = '', public password: string = '') {}
}

