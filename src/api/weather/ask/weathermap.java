package api.weather.ask;


import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class weathermap extends Thread{
	private static String API_KEY="c28f7abc84abff68486a67d00a001760";
	
	public void run() { 
		try {
	    	 weathermap.call_me();
	        } catch (Exception e) {
	         e.printStackTrace();
	       }
	}
	
	public static void call_me() throws Exception {
		 String url = "https://tile.openweathermap.org/map/clouds/12/30/-20.png?appid="+API_KEY;
	     URL obj = new URL(url);

	     File  newfile = new File("f:\\data\\maps.png");
	     java.io.InputStream inputStream = obj.openStream();
	     BufferedImage image = ImageIO.read(inputStream);
	     ImageIO.write(image, "PNG", newfile);
         
  	        JFrame frame = new JFrame();
	        frame.setSize(3000, 3000);
	        JLabel label = new JLabel(new ImageIcon(image));
	        frame.add(label);
	        frame.setVisible(true);

	    dbconnect db = new dbconnect();
	    db.dbupdate3(newfile);
	     
	} 
       
}
