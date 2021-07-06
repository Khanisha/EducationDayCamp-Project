package EducationDayCamp;
import java.text.DecimalFormat;

public class Survivalist extends Event {
private static DecimalFormat df2 = new DecimalFormat("##.##");
	
	String EventName = "SURVIVALIST CAMP";
	String Location ="Gunung Jerai, Kedah";
	String MainActivity ="Navigation, Rope course, Making traps to catch food, Making portable water, Making fire & cooking, Basic tool techniques";
	int Days = 3;
	double Fee = 300.0;

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
	ben=ben+"\nWhen you venture into the backcountry, you enter a world filled with challenge, solitude, and excitement, and many people thrive off of this experience.\n"+
	"\nYet, backcountry camping isn't for everyone; the comforts of everyday life are gone.\n";
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


