package com.lts.FBA.FlightBookingApplication.Utility;

import java.util.UUID;

public class UniqueNumberGenerator {
	
	public static String generateFlightNumber() {
        return "FL-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	}

}
