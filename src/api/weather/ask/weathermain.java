package api.weather.ask;


public class weathermain {
  public static void main ( String args[])
  {
	  Thread T5 = new weather();
	  Thread T16 = new weatherSixteendays();
	  Thread Tmap =new weathermap();
	  T5.start();
	  T16.start();
	  Tmap.start();
	   try {
	         T5.join();
	         T16.join();
	         Tmap.join();
	      } catch ( Exception e) {
	         System.out.println("Interrupted");
	      }
	  
  }

}
