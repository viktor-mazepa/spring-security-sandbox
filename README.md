# spring-security-sandbox
Lessons Project. Repository for code which I wrote during Spring Course study (https://www.udemy.com/course/spring-alishev/).
A simple application that allows to add users into the database (table Person) and perform authentication via a basic authentication form (login and password).
By default, the user creates with ROLE_USER. It can be updated via the database to ROLE_ADMIN(sorry, it's just a sandbox repository)
It contains three HTML pages:
 - /auth/login - authentication form, available to all
 - /auth/registration - to create a new user, available to all
 - /hello – an almost blank page which allows user to logout, available for all authenticated users
 - /admin – an almost blank page, available for all ADMIN users
Application using docker-compose to build application container based on tomcat-jre image and postgres image for database container. 
For authentication and authorization, I used Spring Security framework. 
For database collaboration, it is using Hibernate+Spring JPA. For UI it uses - Thymeleaf.
