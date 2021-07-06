package EducationDayCamp;
import java.text.DecimalFormat;

public class Leadership extends Event{
private static DecimalFormat df2 = new DecimalFormat("##.##");
	
	String EventName = "LEADERSHIP CAMP";
	String Location ="Jerejak Island, Penang";
	String MainActivity ="The Human Knot,Plane Crash,Tallest Tower,Minefield";
	int Days = 3;
	double Fee = 350.0;

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
public void benefit() {//polymorphism
	super.benefit();
	ben=ben+"\nLeadership Camp is designed to have deep and meaningful impact, helping youth be more aware of themselves; their strengths, weaknesses, leadership potential, and leadership style\n"+
	"\nWe are committed to ensuring that each Youth is given the opportunity to learn as much as they can which is why we have one of the highest facilitator- to-camper ratio among Youth Camps which ensures that each camper is given the appropriate amount of attention.\n";
}
public String toString() {//polymorphism
	  benefit();
	  return 
			  ""+ben+
"\n---EVENT DETAILS---"+
"\nEvent Name : "+this.EventName+
"\nLocation : "+this.Location+
"\nMain Activity : "+this.MainActivity+
"\nDuration (days) : "+this.Days+
"\nFee : RM"+df2.format(this.Fee);
}
}


