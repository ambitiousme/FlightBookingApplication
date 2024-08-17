package com.test;
import java.util.UUID;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=10;i++)
		{
		String Result= generateFlightNumber();
		System.out.println(Result);
		}
	}
	
	public static String generateFlightNumber() {
        // Example strategy: Generate a unique flight number using UUID
        String Result = "FL-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        return Result;
    }

}
