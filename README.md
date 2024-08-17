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
db.docker-compose.yml  --done
### Run Docker Compose to Create and Start the Container
docker-compose -f /path/to/your/docker-compose.yml up --done
### Commit the Container to Create a New Image 
docker commit <container_id_or_name> my_custom_image:latest      --done 
### Stop and Remove the Container
docker-compose down                                --done 
### Run New Containers Using the Committed Image 
docker run -d --name mySQL_DB  --hostname DBhost -p 3306:3306 mysql_8  --done <br /><br />

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
User:
•	Roles: Many-to-Many relationship with Role. Unidirectional from User to Role.
•	Bookings: One-to-Many relationship with Booking. Bidirectional.
•	PaymentMethods: One-to-Many relationship with PaymentMethod. Bidirectional.
<br />
Flight:
•	Airline: Many-to-One relationship with Airline. Bidirectional.
•	DepartureAirport & ArrivalAirport: Many-to-One relationships with Airport. Bidirectional.
•	FlightSeat: One-to-Many relationship with FlightSeat. Bidirectional.
•	Booking: One-to-Many relationship with Booking. Bidirectional
<br/>
Booking:
•	Passenger: One-to-Many relationship with Passenger. Bidirectional.
•	Payment: One-to-One relationship with Payment. Bidirectional
•	FlightSeat: One-to-Many relationship with FlightSeat. Bidirectional.
<br/>
FlightSeat:
•	Passenger: One-to-One relationship with Passenger. Bidirectional.
<br/>
Payment:
•	PaymentMethod: Many-to-One relationship with PaymentMethod. Bidirectional.










