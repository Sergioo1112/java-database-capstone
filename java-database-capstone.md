This Spring Boot application uses both MVC and REST controllers. 
Thymeleaf templates are used for the Admin and Doctor dashboards,
while REST APIs serve all other modules. 

The application interacts with two databases—MySQL 
(for patient, doctor, appointment, and admin data) and MongoDB 
(for prescriptions). All controllers route requests through a 
common service layer, which in turn delegates to the appropriate
repositories. MySQL uses JPA entities while MongoDB uses document models.

- Numbered flow of data and control:
1. User accesses Dashboard.
2. Action routes to Rest Controller.
3. Controller accesses Service layer which retreives data from database throught Repo.
4. Service layer returns all user data and returns it to controller.
5. Rest Controller converts into useful Json format.
6. Frontend parses Json into useful boxes colors and information for the User