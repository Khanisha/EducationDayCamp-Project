package EducationDayCamp;

import java.text.DecimalFormat;
public class Event {
	private static DecimalFormat df2 = new DecimalFormat("##.##");
	
	 String EventName, Location, MainActivity,ben;
	 int Days;
	 double Fee;
	 
	 Event(){
		 this.EventName = "";
		 this.Location ="";
		 this.MainActivity ="";
		 this.Days =0;
		 this.Fee =0.0;
	 }
	 
	 Event(String ename,String loc,String mact, int d, double f){
		 this.EventName = ename;
		 this.Location = loc;
		 this.MainActivity = mact;
		 this.Days = d;
		 this.Fee = f; 
	 }
	 public void setEventName(String EventName){
			this.EventName=EventName;
		}
	 public void setLocation(String Location){
			this.Location=Location;
		}
	 public void setMainActivity(String MainActivity){
			this.MainActivity=MainActivity;
		}
	 public void setDays(int Days){
			this.Days=Days;
		}
	 public void setFee(double Fee){
			this.Fee=Fee;
		}
	 public String getEventName () {
		  return this.EventName;
	  }
	  public String getLocation () {
		  return this.Location;
	  }
	  public String getMainActivity () {
		  return this.MainActivity;
	  }
	  public int getDays () {
		  return this.Days;
	  }
	  public double getFee () {
		  return this.Fee;
	  }
	  public void benefit() {
			ben="WHAT TO EXPECT !";
			System.out.println("WHAT TO EXPECT !");
		}
	  public String toString() {
		  benefit();
		  return  
	  "\n---EVENT DETAILS---"+
	  "\nEvent Name : "+this.EventName+
	  "\nLocation : "+this.Location+
	  "\nMain Activity : "+this.MainActivity+
	  "\nDuration (days) : "+this.Days+
	  "\nFee : RM"+df2.format(this.Fee);
	  }
	 }
