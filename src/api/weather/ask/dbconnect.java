package api.weather.ask;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;  

public class dbconnect { 
   
	 dbconnect()  {  
      MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
      //System.out.println("Connected to the database successfully");  
    
   } 
	 
	 public  void dbupdate1(String s1,String s2)
	 {	
		 MongoClient mongo = new MongoClient( "localhost" , 27017 );
		 MongoDatabase database = mongo.getDatabase("weatherapi"); 
		 MongoCollection<Document> collection = database.getCollection("fivedays"); 
		 Document Doc = new Document (s1,s2);
		 collection.insertOne(Doc);
		 
	 }
	 public  void dbupdate2(String s1,String s2)
	 {	
		 MongoClient mongo = new MongoClient( "localhost" , 27017 );
		 MongoDatabase database = mongo.getDatabase("weatherapi"); 
		 MongoCollection<Document> collection = database.getCollection("sixteendays"); 
		 Document Doc = new Document (s1,s2);
		 collection.insertOne(Doc);
		 
	 }
	 public void dbupdate3(File s2)
	 {	
		 MongoClient mongo = new MongoClient( "localhost" , 27017 );
		 MongoDatabase database = mongo.getDatabase("weatherapi"); 
		 @SuppressWarnings("deprecation")
		 DB db = mongo.getDB("weatherapi");
		
		 String newFileName = "maps";
			//File imageFile = new File(s2);
			GridFS gfsPhoto = new GridFS(db, "maps");
			GridFSInputFile gfsFile;
			try {
				gfsFile = gfsPhoto.createFile(s2);
				gfsFile.setFilename(newFileName);
				gfsFile.save();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 
		 
	 }
}