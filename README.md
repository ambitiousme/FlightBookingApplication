# FlightBookingApplication
For learning purpose.

# Date:14/08/2024
Repository created has been created in GITHUB and saved it locally.
Common GIT bash commands:
git clone <repository-url>
git status
git add .
git commit -m "your message"
git push

# Date:15/08/2024 DATABASE setup in DOCKER
Create project by springInitializr. Committing it to GIT.

--Creating Docker Compose file 
db.docker-compose.yml  --done
--Run Docker Compose to Create and Start the Container
docker-compose -f /path/to/your/docker-compose.yml up --done
--Commit the Container to Create a New Image
docker commit <container_id_or_name> my_custom_image:latest      --done
--Stop and Remove the Container
docker-compose down                                --done 
--Run New Containers Using the Committed Image
docker run -d --name mySQL_DB  --hostname DBhost -p 3306:3306 mysql_8  --done 

Now Started my project Giving error because of Database configuration is not available.

--MySQL Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name?useSSL=false&serverTimezone=UTC
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

--JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect







