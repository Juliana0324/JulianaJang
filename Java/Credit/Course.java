package Credit;

public class Course {

	public static final int CREDIT_MAJOR = 3;
	public static final int CREDIT_GENERAL = 2;
	public String name; 
	public int credit;
	public String score;
	
	 Course(String name, int credit, String score) {
		this.name=name;
		this.credit = credit;
		this.score = score;
	 }
	 
	
	 public double getScore() {		
		switch(score) {
			case "A+" : 
				return 4.5;

			case "A":
				return 4.0;
			case "B+":
				return 3.5;
			case "B":
				return 3.0;

			case "C+":
				return 2.5;
				
			case "C":
				return  2.0;

			case "D+":
				return 1.5;
				
			case "D":
				return 1.5;
				
			case "F":
				return 0;
				
		}
		return -1;
	}

}

