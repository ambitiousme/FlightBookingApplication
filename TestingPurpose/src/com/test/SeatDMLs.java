package com.test;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SeatDMLs {

    // Define the number of airlines and their seat distributions
    static final int[] BUSINESS_SEAT_NUM = {12,16,12,12,24,24,12,12,18,12,24,30,12,20,16,18,12,20,8,16,28,16,12,20,10,14,30,18,16, 8,30,20,28,12,16,14,20,12,16,18,14,10,16,14,12,10,16,14,20,18};
    static final int[] ECONOMY_SEAT_NUM = {150,180,150,156,250,230,150,156,190,144,276,294,150,270,188,210,168,300,134,
    		 150,312,174,138,280,180,150,270,240,174,112,270,200,242,140,160,186,250,138,
    		  174,240,150,180,180,190,140,160,180,174,220,210};
    static final int TOTAL_AIRLINES = 50;
    static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("airline_seats.sql"))) {
            // Generate SQL statements
            for (int airlineId = 1; airlineId <= TOTAL_AIRLINES; airlineId++) {
                generateSeatsForAirline(writer, airlineId);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateSeatsForAirline(BufferedWriter writer, int airlineId) throws IOException {
        // Array indices are 0-based, so subtract 1 to get the correct index
        int index = airlineId - 1;
        if (index < 0 || index >= TOTAL_AIRLINES) {
            System.out.println("Invalid airline ID: " + airlineId);
            return;
        }
        
        int businessSeats = BUSINESS_SEAT_NUM[index];
        int economySeats = ECONOMY_SEAT_NUM[index];
        
        // Generate Business Class Seats
        for (int i = 1; i <= businessSeats; i++) {
            String seatNumber = String.format("B%d%s", (i - 1) / 4 + 1, (char)('A' + (i - 1) % 4));
            writer.write(String.format("DELETE FROM AIRLINE_SEATS WHERE SEAT_NUMBER = '%s' AND AIRLINE_ID=%d ;\n",seatNumber, airlineId));
            writer.write(String.format("INSERT INTO AIRLINE_SEATS (CLASS_TYPE, CREATED_AT, UPDATED_AT, SEAT_NUMBER, AIRLINE_ID) VALUES ('Business', NOW(), NOW(), '%s', %d);\n", seatNumber, airlineId));
        }
        
        // Generate Economy Class Seats
        for (int i = 1; i <= economySeats; i++) {
            String seatNumber = String.format("E%d%s", (i - 1) / 6 + 1, (char)('A' + (i - 1) % 6));
            writer.write(String.format("DELETE FROM AIRLINE_SEATS WHERE SEAT_NUMBER = '%s' AND AIRLINE_ID=%d ;\n",seatNumber, airlineId));
            writer.write(String.format("INSERT INTO AIRLINE_SEATS (CLASS_TYPE, CREATED_AT, UPDATED_AT, SEAT_NUMBER, AIRLINE_ID) VALUES ('Economy',  NOW(), NOW(), '%s', %d);\n",
                seatNumber, airlineId));
        }
    }
}

/*
 * import java.io.BufferedWriter; import java.io.FileWriter; import
 * java.io.IOException; import java.time.LocalDateTime; import
 * java.time.format.DateTimeFormatter;
 * 
 * public class SeatDMLs {
 * 
 * // Define the number of airlines and their seat distributions static final
 * int[] BUSINESS_SEAT_NUM =
 * {12,16,12,12,24,24,12,12,18,12,24,30,12,20,16,18,12,20,
 * 8,16,28,16,12,20,10,14,30,18,16,
 * 8,30,20,28,12,16,14,20,12,16,18,14,10,16,14,12,10,16,14,20,18}; static final
 * int[] ECONOMY_SEAT_NUM =
 * {150,180,150,156,250,230,150,156,190,144,276,294,150,270,188,210,168,300,134,
 * 150,312,174,138,280,180,150,270,240,174,112,270,200,242,140,160,186,250,138,
 * 174,240,150,180,180,190,140,160,180,174,220,210}; static final int
 * TOTAL_SEATS = BUSINESS_SEAT_NUM.length+ECONOMY_SEAT_NUM.length; static final
 * String[] CLASS_TYPES = {"Business", "Economy"}; static final
 * DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
 * 
 * public static void main(String[] args) { // Generate SQL statements try
 * (BufferedWriter writer = new BufferedWriter(new
 * FileWriter("airline_seats.sql"))) { // Generate SQL statements for (int
 * airlineId = 1; airlineId <= 50; airlineId++) {
 * generateSeatsForAirline(writer, airlineId); } } catch (IOException e) {
 * e.printStackTrace(); } }
 * 
 * private static void generateSeatsForAirline(BufferedWriter writer,int
 * airlineId) { // Array indices are 0-based, so subtract 1 to get the correct
 * index int index = airlineId - 1; if (index < 0 || index >= 50) {
 * System.out.println("Invalid airline ID: " + airlineId); return; } int
 * indexB=0; int indexE=0; for(int k =0;k<50;k++) { indexB=k; int businessSeats
 * = BUSINESS_SEAT_NUM[indexB]; if(indexB==49) businessSeats=0;
 * 
 * // Generate Business Class Seats for (int i = 1; i <= businessSeats; i++) {
 * String seatNumber = String.format("B%d%s", (i - 1) / 4 + 1, (char)('A' + (i -
 * 1) % 4)); try { writer.write(String.
 * format("INSERT INTO AirlineSeats (class_type, created_at, updated_at, seat_number, airline_id) VALUES ('Business', '%s', '%s', '%s', %d);\n"
 * , LocalDateTime.now().format(dtf), LocalDateTime.now().format(dtf),
 * seatNumber, airlineId)); } catch (IOException e) { // TODO Auto-generated
 * catch block e.printStackTrace(); } } }
 * 
 * for(int j =0;j<50;j++) { indexB=j; int economySeats =
 * ECONOMY_SEAT_NUM[indexE]; if(indexB==49) economySeats=0;
 * 
 * // Generate Economy Class Seats for (int i = 1; i <= economySeats; i++) {
 * String seatNumber = String.format("E%d%s", (i - 1) / 6 + 1, (char)('A' + (i -
 * 1) % 6)); try { writer.write(String.
 * format("INSERT INTO AirlineSeats (class_type, created_at, updated_at, seat_number, airline_id) VALUES ('Economy', '%s', '%s', '%s', %d);\n"
 * , LocalDateTime.now().format(dtf), LocalDateTime.now().format(dtf),
 * seatNumber, airlineId)); } catch (IOException e) { // TODO Auto-generated
 * catch block e.printStackTrace(); } }
 * 
 * }
 * 
 * 
 * 
 * }
 * 
 * }
 */