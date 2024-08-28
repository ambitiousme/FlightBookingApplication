# FlightBookingApplication
For learning purpose.

## Date:14/08/2024
Repository created has been created in GITHUB and saved it locally. <br />
### Common GIT bash commands:
git clone <repository-url> <br />
git status<br />
git add . <br />
git commit -m "your message" <br />
git push <br />

## Date:15/08/2024 DATABASE setup in DOCKER
Create project by springInitializr. Committing it to GIT.
### Creating Docker Compose file
db.docker-compose.yml
### Run Docker Compose to Create and Start the Container
docker-compose -f /path/to/your/docker-compose.yml up
### Commit the Container to Create a New Image 
docker commit <container_id_or_name> my_custom_image:latest
### Stop and Remove the Container
docker-compose down
<br />
### For running up containers:
1.Using a Named Volume:<br />
docker run --name mySQL_DB -p 3306:3306 --hostname mySQLDB_Host -e MYSQL_ROOT_PASSWORD=rootpassword -e MYSQL_DATABASE=FBA_DATABASE -v mysql-data:/var/lib/mysql mysql_8:latest
<br />
2.Using a Bind Mount<br />
docker run --name mySQL_DB -p 3306:3306 --hostname mySQLDB_Host -e MYSQL_ROOT_PASSWORD=rootpassword -e MYSQL_DATABASE=FBA_DATABASE -v C:\TechSpace\SpringBoot-Project\FlightBookingApplication\mySQL_DB_MOUNT:/var/lib/mysql mysql_8:latest
<br />
3. Backup and Restore<br />
Even with volumes, it's a good practice to back up your data regularly.<br />
•	Backup:<br />
docker exec mySQL_DB /usr/bin/mysqldump -u root --password=rootpassword FBA_DATABASE > backup.sql <br />
•	Restore:<br />
docker exec -i mySQL_DB /usr/bin/mysql -u root --password=rootpassword FBA_DATABASE < backup.sql<br />
By using volumes or bind mounts, your MySQL data will persist across container restarts or removals.<br />

Now Started my project Giving error because of Database configuration is not available. <br /><br />

### MySQL Database Configuration</h3> 
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name?useSSL=false&serverTimezone=UTC <br />
spring.datasource.username=your_database_username <br />
spring.datasource.password=your_database_password <br />
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

### JPA/Hibernate Configuration</h3> 
spring.jpa.hibernate.ddl-auto=update <br />
spring.jpa.show-sql=true <br />
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect 


## Date:18/08/2024 Entities Creation
### Created Entities:
<br />
1. User<br />
2. Role<br />
3. Flight<br />
4. Airport<br />
5. Airline<br />
6. AirlineSeat<br />
7. FlightSeat<br />
8. Booking<br />
9. Passenger<br />
10. Payment<br />
11. PaymentMethod<br />
<br />

### Entities Relationship:
<br />
User:<br />
    •	Roles: Many-to-Many relationship with Role. Unidirectional from User to Role.<br />
    •	Bookings: One-to-Many relationship with Booking. Bidirectional.<br />
    •	PaymentMethods: One-to-Many relationship with PaymentMethod. Bidirectional.<br />
<br />
Flight:<br />
•	Airline: Many-to-One relationship with Airline. Bidirectional.<br />
•	DepartureAirport & ArrivalAirport: Many-to-One relationships with Airport. Bidirectional.<br />
•	FlightSeat: One-to-Many relationship with FlightSeat. Bidirectional.<br />
•	Booking: One-to-Many relationship with Booking. Bidirectional<br />
<br/>
Booking:<br />
•	Passenger: One-to-Many relationship with Passenger. Bidirectional.<br />
•	Payment: One-to-One relationship with Payment. Bidirectional<br />
•	FlightSeat: One-to-Many relationship with FlightSeat. Bidirectional.<br />
<br/>
FlightSeat:<br />
•	Passenger: One-to-One relationship with Passenger. Bidirectional.<br />
<br/>
Payment:<br />
•	PaymentMethod: Many-to-One relationship with PaymentMethod. Bidirectional.<br />

### Developed Utility package for Holding Custom Utility classes.

### Static Data creation in Database:
1. Role_DMLs.sql<br />
2. Airport_DMLs.sql<br />
3. Airline_DMLs.sql<br />
4. AirlineSeat_DMLs.sql<br />

### Important Docker Command to run SQL file in containerize DB
e.g.<br />
docker cp C:\TechSpace\SpringBoot-Project\FlightBookingApplication\DMLs\Airports_DMLs.sql mySQL_DB:/Airports_DMLs.sql<br />
In MYSQL<br />
SOURCE /Airports_DMLs.sql;<br />

## Date:18/08/2024 Controller,Service,DTOs and Repository Set up for the projects. -WIP

## Date:18/08/2024
### USER,Flight,Passenger API created and tested OK













