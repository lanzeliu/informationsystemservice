# CSYE6225 Spring2020 Lanze Liu
# informationsystemservice
ElasticBeanStalk URL
http://informationsystemservice-env.6mpvw2u7ta.us-east-2.elasticbeanstalk.com/
# Assignment1
Requirement:
- Create a AWS Account
- Create GitHub Account
- Continue making code changes. and Push code regularly.
- Deploy the code using ElasticBeanstalk.
- StudentInformationSystem 
     - The system manages Professors, Students and Programs.
     - Every Program has Courses
     - Every Course has Lectures, and each lecture will have notes, and associated material
     - Every Course will have a board
     - Every Course will have a roster 
     - Every Course has enrolled Students
     - Every Course has one associated Professor, and a Student TA
     - Every Student has information in the system 
          - Name        
          - StudentId
          - image     
          - courses enrolled
          - program name
- When thinking of the URIs - think of using names. 
- Step 1 - Design the RESTful API first. 
     - Identify the nouns in the API
     - /classes/{courseId}  eg. /classes/csye6225
     - understand the relationship between the objects 
     - And then illustrate the relationship between the Resources
- Step 2 - Identify the GET, POST, PUT, or DELETE operations for each API
- Step 3 - Implement the APIs in code. 
- Step 4 - Deploy using ElasticBeanstalk
- Your Resources are all going to stay in Memory.

URIs:
1. programs
- /programs GET, POST
- /programs/{programId} GET, PUT, DELETE
- /programs/{programId}/courses GET, POST
- /programs/{programId}/courses/{courseId} GET, PUT, DELETE
- /programs/{programId}/students GET, POST
- /programs/{programId}/students/{studentId} GET, PUT, DELETE
- /programs/{programId}/courses/{courseId}/students GET, POST
- /programs/{programId}/courses/{courseId}/students/{studentId} GET, PUT, DELETE
- /programs/{programId}/students/{studentId}/courses GET, POST
- /programs/{programId}/students/{studentId}/courses/{courseId} GET, PUT, DELETE
  
2. students
- /students GET
- /students/{studentId} GET

3.professors
- /professors GET, POST
- /professors/{professorId} GET, PUT, DELETE
  
4.courses
- /courses GET
- /courses/{courseId} GET
- /courses/{courseId}/lectures GET, POST
- /courses/{courseId}/lectures/{lectureId} GET, PUT, DELETE
  
5. lectures
- /lectures GET
- /lectures/{lectureId} GET
