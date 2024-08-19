package com.lts.FBA.FlightBookingApplication.Utility;

public class DistanceCalculator {

	// Radius of the Earth in kilometers
	private static final double EARTH_RADIUS_KM = 6371.0;

	public static double calculateHaversineDistance(double lat1, double lon1, double lat2, double lon2) {

		lon1 = Math.toRadians(lon1);
		lon2 = Math.toRadians(lon2);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

		// Haversine formula
		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);

		double c = 2 * Math.asin(Math.sqrt(a));

		return (c * EARTH_RADIUS_KM);
	}

}
