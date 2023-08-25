class StudentGroup {
  constructor(
    public name: string = '',
    public surname: string = '',
    public groupName: string = '',
    public coachName: string = '',
    public coachSurname: string = ''

  ){}
}

export class DisciplineRegisteredStudents {
  constructor(
    public competitionId: string = '',
    public competitionName: string = '',
    public disciplineId: string ='',
    public disciplineType: string = '',
    public groupCategory: string = '',
    public genderCategory: string = '',
    public weightCategory: string = '',
    public registeredStudents: StudentGroup[] = []
  ){}
}
