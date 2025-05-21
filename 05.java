class Student {
	private String name;  
	private int exam1;
	private int exam2;
	private int exam3;
	double avg;

	Student(){
		
	}
	
	boolean validateMarks(int marks) {   
		if (marks<= 100 && marks>=0){
			return true;
		}
		else{
			return false;
		}
	}
	
	Student(String name, int exam1, int exam2, int exam3)throws Exception{
		this.name = name;
		
		if(validateMarks(exam1) && validateMarks(exam2) && validateMarks(exam3)){          // Here we check this marks is valid or not
			this.exam1 = exam1;
			this.exam2 = exam2;
			this.exam3 = exam3;
		}
		else{
			System.out.println("Setting the marks values to 0");
			throw new Exception("Invalid Marks");
		}
	}
	
	String getName(){
		return this.name;
	}
	
	int getExam1() {   
		return this.exam1;
	}
	
	int getExam2() {   
		return this.exam2;
	}
	
	int getExam3() {   
		return this.exam3;
	}

	double calculateAverage() {  
		avg = (exam1 + exam2 + exam3)/3.00;
		return avg;
	}
	
}

class MainStudentMarks{
	public static void main(String[] args){

        try {
				// This is invalid
            Student s1 = new Student("John", 75, 110, 90);

            System.out.println("\nName of the Student 1 is " + s1.getName());
			System.out.println("\nMarks of the Student 1 for Exam1 is " + s1.getExam1());
			System.out.println("Marks of the Student 1 for Exam2 is " + s1.getExam2());
			System.out.println("Marks of the Student 1 for Exam3 is " + s1.getExam3());
			System.out.println("\nAverage of the Student 1 is " + s1.calculateAverage());
        } 
		catch (Exception e) {
            System.out.println("\nException: " + e.getMessage());
        }	

        try {
				// This is valid
            Student s2 = new Student("Eve", 99, 88, 75);

			System.out.println("\nName of the Student 2 is " + s2.getName());
			System.out.println("\nMarks of the Student 2 for Exam1 is " + s2.getExam1());
			System.out.println("Marks of the Student 2 for Exam2 is " + s2.getExam2());
			System.out.println("Marks of the Student 2 for Exam3 is " + s2.getExam3());
			System.out.println("\nAverage of the Student 2 is " + s2.calculateAverage());  
        } 
		catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
	
	}	
}	

