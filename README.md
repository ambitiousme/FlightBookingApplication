# FlightBookingApplication
For learning purpose.

# Date:14/08/2024
Repository created has been created in GITHUB and saved it locally. <br />
Common GIT bash commands:
git clone <repository-url> <br />
git status<br />
git add . <br />
git commit -m "your message" <br />
git push <br />

# Date:15/08/2024 DATABASE setup in DOCKER
Create project by springInitializr. Committing it to GIT.
<br /><br />
--Creating Docker Compose file <br />
db.docker-compose.yml  --done<br />
--Run Docker Compose to Create and Start the Container<br />
docker-compose -f /path/to/your/docker-compose.yml up --done<br />
--Commit the Container to Create a New Image <br />
docker commit <container_id_or_name> my_custom_image:latest      --done <br />
--Stop and Remove the Container<br />
docker-compose down                                --done <br />
--Run New Containers Using the Committed Image <br />
docker run -d --name mySQL_DB  --hostname DBhost -p 3306:3306 mysql_8  --done <br /><br />

Now Started my project Giving error because of Database configuration is not available. <br /><br />

--MySQL Database Configuration <br />
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name?useSSL=false&serverTimezone=UTC <br />
spring.datasource.username=your_database_username <br />
spring.datasource.password=your_database_password <br />
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver <br />

--JPA/Hibernate Configuration <br />
spring.jpa.hibernate.ddl-auto=update <br />
spring.jpa.show-sql=true <br />
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect <br />







