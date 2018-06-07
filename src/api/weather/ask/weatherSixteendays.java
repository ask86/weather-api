package api.weather.ask;
// Don't have access to 16days weather forecast under free membership
// shows authentication error
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class weatherSixteendays extends Thread {
	private static String API_KEY="c28f7abc84abff68486a67d00a001760";
	public void run() { 
	     try {
	    	 weatherSixteendays.call_me1();
	        } catch (Exception e) {
	         e.printStackTrace();
	       }
	     }
		public static void call_me1() throws Exception {
	
// 			 String url = "api.openweathermap.org/data/2.5/forecast/daily?q=London,us&cnt=16&appid="+API_KEY;
// 		     URL obj = new URL(url);
//		     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//		     con.setRequestMethod("GET");
//		     con.setRequestProperty("User-Agent", "Mozilla/5.0");
//		     int responseCode = con.getResponseCode();
//		     //System.out.println("\nSending 'GET' request to URL : " + url);
//		     //System.out.println("Response Code : " + responseCode);
//		     BufferedReader in = new BufferedReader(
//		             new InputStreamReader(con.getInputStream()));
//		     String inputLine;
//		     StringBuffer response = new StringBuffer();
//		     while ((inputLine = in.readLine()) != null) {
//		     	response.append(inputLine);
//		     }
//		     in.close();
//
//		     dbconnect db = new dbconnect();
//		     DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		 	 Date date = new Date();
//		     String sysdate = date.toString(); 
//		    
//		     db.dbupdate2(sysdate,response.toString());
	   }
	}
