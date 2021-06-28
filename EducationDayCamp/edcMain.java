package EducationDayCamp;

public class edcMain {

	public static void main(String[] args) {
		parti ptc = new parti("Josephine","Joseph","female","012344567");
		
		print(ptc);
	}
	public static void print(Object ptc) {
		Fitness fit=new Fitness();
		Survivalist sur=new Survivalist();
		Leadership lea=new Leadership();
		
		System.out.println(ptc.toString()+fit);
		fit.benefit();
		System.out.println(ptc.toString()+sur);
		sur.benefit();
		System.out.println(ptc.toString()+lea);
	    lea.benefit();
	}

	String printinfo(String i) {
		Fitness fit=new Fitness();
		Survivalist sur=new Survivalist();
		Leadership lea=new Leadership();
		String j="";
		if(i=="FITNESS CAMP") {
			j=fit.toString();
		}else if(i=="SURVIVALIST CAMP") {
			j=sur.toString();
		}else if(i=="LEADERSHIP CAMP") {
			j=lea.toString();
		}
		return j;
	}

}
