package api.weather.ask;

//Weather forecast of 5days/3hours

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.json.JsonArray;
import javax.json.Json;

import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.swing.JOptionPane;

//import org.json.JSONObject;

//import org.openweathermap.api.DataWeatherClient;
//import org.openweathermap.api.UrlConnectionDataWeatherClient;

public class weather extends Thread{
	private static String API_KEY="c28f7abc84abff68486a67d00a001760";
    public void run() { 
	try {
    	 weather.call_me();
        } catch (Exception e) {
         e.printStackTrace();
       }
     } 
	public static void call_me() throws Exception {
	     String url = "http://samples.openweathermap.org/data/2.5/forecast?q=moscow&appid="+API_KEY;
	     URL obj = new URL(url);
	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	     con.setRequestMethod("GET");
	     con.setRequestProperty("User-Agent", "Mozilla/5.0");
	     int responseCode = con.getResponseCode();
	     // System.out.println("\nSending 'GET' request to URL : " + url);
	     //System.out.println("Response Code : " + responseCode);
	     BufferedReader in = new BufferedReader(
	             new InputStreamReader(con.getInputStream()));
	     String inputLine;
	     StringBuffer response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	     }
	     in.close();
	     
	     
	     dbconnect db = new dbconnect();
	     DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 	 Date date = new Date();
	     String sysdate = date.toString(); 
	     db.dbupdate1(sysdate,response.toString());
	     
         
         JsonReader jsonReader = Json.createReader(new StringReader(response.toString())); 
         JsonObject object = jsonReader.readObject(); 
         jsonReader.close();
         
         
	     //System.out.println("result after Reading JSON Response");
	     JsonArray arrObj = object.getJsonArray("list");
	     boolean flag= false;
         //System.out.println("Weather alerts:");
         outerloop:	 
         for(JsonValue value : arrObj){
        	 JsonReader jsonReader1 = Json.createReader(new StringReader(value.toString())); 
             JsonObject object1 = jsonReader1.readObject(); 
             jsonReader.close();
             JsonArray arrObj1 = object1.getJsonArray("weather");
             for(JsonValue value1 : arrObj1){
             			
           			JsonReader jsonReader2 = Json.createReader(new StringReader(value1.toString())); 
                        JsonObject object2 = jsonReader2.readObject(); 
                        jsonReader.close();
                        if(object2.getString("main")=="Rain")
                        {
                        	//System.out.println("AlertMessage- "+"Rain ahead");
                        	JOptionPane.showMessageDialog(null, 
                         			"Rain ahead", 
                                    "AlertMessage", 
                                    JOptionPane.WARNING_MESSAGE);
                        	flag=true;
                        	break outerloop;
                        }
                        else if(object2.getString("main")=="Snow")
                        {
                        	//System.out.println("AlertMessage- "+"Snow ahead");
                        	JOptionPane.showMessageDialog(null, 
                         			"Snow ahead", 
                                    "AlertMessage", 
                                    JOptionPane.WARNING_MESSAGE);
                        	flag=true;
                        	break outerloop;
                        }

                 		}
                JsonValue temp=   (object1.getJsonObject("main").get("temp"));
                if(Double.parseDouble(temp.toString())< 273.00)
                {
             	//System.out.println("AlertMessage- "+"Freezing temp ahead");
             	JOptionPane.showMessageDialog(null, 
             			"Freezing temperature ahead", 
                        "AlertMessage", 
                        JOptionPane.WARNING_MESSAGE);
            	flag=true;
             	break outerloop;
                }
              			
     		}

         		if(flag== false)
         		{
         			JOptionPane.showMessageDialog(null, 
                 			"Clear weather. Enjoy!", 
                            "AlertMessage", 
                            JOptionPane.WARNING_MESSAGE);
         			//System.out.println("Clear Weather");
         		}
         }
	    
	   }

