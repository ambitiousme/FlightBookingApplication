package com.test;
import java.util.UUID;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * for(int i=1;i<=10;i++) { String Result= generateFlightNumber();
		 * System.out.println(Result); }
		 */
		Gen();
	}
	
	public static String generateFlightNumber() {
        // Example strategy: Generate a unique flight number using UUID
        String Result = "FL-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        return Result;
    }
	
	public static void Gen() {
		
		String [] arr = {"DEL","BOM","BLR","HYD","CCU","COK","IXB","GOI","JAI","SXR","VNS","IXD","IDR","IXC","CJB","PNQ","GAU","ATQ","TRV","IXE","TRZ","BHU","JDH","BDQ","RAJ","IXU","KLH","PNY","SLV","IXJ","GWL","AGR","DHM","UDR","BHO","DIB","IXS","LUH","JLR","RPR","BHI","KTU","LHR","DXB","SIN","SYD","LAX","CDG","HKG","YYZ","AMS","ICN","MAD","ZRH","FCO","VIE","CAI","DOH","JFK"};
		
		int len = arr.length;
		
		StringBuffer sb = new StringBuffer("");
		for(int i=45;i<45+len;i++)
		{
			sb.append("DELETE FROM AIRPORTS WHERE ");
			
			sb.append("AIRPORT_CODE='");
			sb.append(arr[i-45]);
			sb.append("' ;\n");
			
	
		}
		System.out.println(sb);
		
	}
	
	

}
