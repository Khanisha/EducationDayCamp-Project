package EducationDayCamp;
import java.text.DecimalFormat;

public class Fitness extends Event{
	private static DecimalFormat df2 = new DecimalFormat("##.##");
	
	String EventName = "FITNESS CAMP";
	String Location ="Tropical island of Phuket, Thailand";
	String MainActivity ="Adventurous assault courses, Outdoor fitness classes, Air-conditioned indoor gym, Beach training";
	int Days = 3;
	double Fee = 450.0;

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
	super.benefit();
	ben=ben+"\nFitness Camp will insure that our team of trainers and staff will create a fun and professional gym environment.\n"+
	"\nWhether you are just coming for a simple get fit program or are looking for a specialized training regime, our Fitness Camp suits all your needs.\n";
}
public String toString() {
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