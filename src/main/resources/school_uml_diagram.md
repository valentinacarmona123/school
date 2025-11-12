# School Management System - UML Class Diagram

```mermaid
graph TB
    %% Styling for different types of classes
    classDef abstractClass fill:#f9f,stroke:#333,stroke-width:2px
    classDef enumClass fill:#bbf,stroke:#333,stroke-width:2px
    classDef normalClass fill:#9f9,stroke:#333,stroke-width:2px

    %% Person Hierarchy
    Person[<b>Person</b><br>------------------<br>- id: String<br>- name: String<br>- lastName: String<br>- email: String<br>- phone: String<br>- birthDate: LocalDate<br>- gender: Gender<br>- address: String<br>- active: boolean]:::normalClass
    
    Student[<b>Student</b><br>------------------<br>- studentId: String<br>------------------<br>+ enrollInSubject()<br>+ addGrade()<br>+ calculateGPA()]:::normalClass
    
    Teacher[<b>Teacher</b><br>------------------<br>- teacherId: String<br>- specialization: String<br>- fullTime: boolean<br>- salary: double<br>------------------<br>+ addSubject()<br>+ removeSubject()]:::normalClass

    %% Subject related
    Subject[<b>Subject</b><br>------------------<br>- code: String<br>- name: String<br>- credits: int<br>------------------<br>+ addSchedule()<br>+ enrollStudent()]:::normalClass
    
    Grade[<b>Grade</b><br>------------------<br>- id: String<br>- name: String<br>- level: String<br>- capacity: int<br>------------------<br>+ addStudent()<br>+ removeStudent()]:::normalClass
    
    GradeRecord[<b>GradeRecord</b><br>------------------<br>- score: double<br>- date: Date<br>- comments: String<br>------------------<br>+ isPassing()]:::normalClass
    
    Schedule[<b>Schedule</b><br>------------------<br>- id: String<br>- day: DayOfWeek<br>- startTime: LocalTime<br>- endTime: LocalTime<br>------------------<br>+ isOverlapping()]:::normalClass
    
    Classroom[<b>Classroom</b><br>------------------<br>- code: String<br>- building: String<br>- capacity: int<br>- availableEquipment: List~String~<br>------------------<br>+ isAvailable()]:::normalClass
    
    %% Enums
    Gender[<b>Gender</b><br>------------------<br>MALE<br>FEMALE<br>OTHER<br>NOT_SPECIFIED]:::enumClass
    
    GradeType[<b>GradeType</b><br>------------------<br>QUIZ<br>HOMEWORK<br>EXAM<br>PROJECT<br>PARTICIPATION]:::enumClass

    %% Inheritance
    Person <|-- Student
    Person <|-- Teacher

    %% Associations
    Student "1" -- "*" GradeRecord : has >
    Student "*" -- "1" Grade : belongs to >
    Student "*" -- "*" Subject : enrolled in >
    
    Subject "1" -- "*" Schedule : has >
    Subject "1" -- "1" Teacher : taught by >
    Subject "*" -- "*" Student : has enrolled >
    
    Teacher "1" -- "*" Subject : teaches >
    Teacher "1" -- "0..1" Grade : is head teacher of >
    
    GradeRecord "*" -- "1" Subject : for >
    GradeRecord "1" -- "1" GradeType : of type >
    
    Schedule "1" -- "1" Classroom : in >

    %% Notes
    classDef noteClass fill:#ff9,stroke:#333,stroke-width:1px
    
    note1[Person: Base class for all system users]:::noteClass
    note2[Student: Can enroll in multiple subjects]:::noteClass
    note3[Teacher: Can teach multiple subjects]:::noteClass
    note4[Subject: Has schedules and enrolled students]:::noteClass
    
    note1 --- Person
    note2 --- Student
    note3 --- Teacher
    note4 --- Subject
```

## How to View the Diagram
1. Open this file in a Markdown viewer that supports Mermaid.js (like VS Code with Mermaid extension)
2. Or copy the Mermaid code to an online Mermaid editor
3. The diagram will render as an interactive UML class diagram

## Key
- 🟣 Abstract Class
- 🔵 Enumeration
- 🟢 Concrete Class
- Solid Line: Association
- Triangle Arrow: Inheritance
- Diamond: Composition/Aggregation
