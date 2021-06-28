package EducationDayCamp;

abstract class Participant {
	abstract void setFirstname(String firstN);
	abstract void setLastname(String lastN);
	abstract void setGender(String gend);
	abstract void setContactNo(String cno);
	
	abstract String setFirstname();
	abstract String setLastname();
	abstract String setGender();
	abstract String setContactNo();
}

class parti extends Participant{
	
	String FirstName,LastName,Gender,ContactNo;
	
	 parti(String firstN, String lastN, String gend, String cno){
	 this.FirstName = firstN;
	 this.LastName = lastN;
	 this.Gender = gend;
	 this.ContactNo = cno;
	 }
	 
	public void setFirstName(String firstN) {
			this.FirstName=firstN;
		}
	public void setLastName(String lastN) {
			this.LastName=lastN;
		}
	public void setGender(String gend) {
			this.Gender=gend;
		}
	public void setContactNo(String cno) {
		this.ContactNo=cno;
	}
	public String getFirstName() {
		return this.FirstName;
	}
	public String getLastName() {
		return this.LastName;
	}
	public String getGender() {
		return this.Gender;
	}
	public String getContactNo() {
		return this.ContactNo;
	}
	public String toString() {
		return "\n---PARTICIPANT DETAILS---"+"\nParticipant : "+FirstName+" "+LastName+"\nGender : "+Gender+"\nContact Number : "+ContactNo;
	}

	@Override
	void setFirstname(String firstN) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void setLastname(String lastN) {
		// TODO Auto-generated method stub
		
	}

	@Override
	String setFirstname() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String setLastname() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String setGender() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String setContactNo() {
		// TODO Auto-generated method stub
		return null;
	}
}