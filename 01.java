class Student {
	private int studentId;
	private String name;
	private int daysAttended;
	
	Student(int studentId, String name, int daysAttended) {
		this.studentId = studentId;
		this.name = name;
		this.daysAttended = daysAttended;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setDaysAttended(int daysAttended) {
		this.daysAttended = daysAttended;
	}
	
	public int getDaysAttended() {
		return daysAttended;
	}
}

class Classroom {
    Student[] students;
    int count;

    Classroom() {
        students = new Student[10];
		count = 0;
    }

    public void addStudent(Student student) {
        if (count < students.length) {
            students[count] = student;
            count++;
        } 
		else {
            System.out.println("Classroom is full.");
        }
    }

    public void updateAttendance(int studentId, int newDaysAttended) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentId() == studentId) {
                students[i].setDaysAttended(newDaysAttended);
                found = true;
                System.out.println("Attendance updated for Student ID " + studentId);
                break;
            }
        }
        if (!found) {
            System.out.println("\nStudent ID " + studentId + " not found.");
        }
    }


    public void displayAllStudents() {
        System.out.println("\nStudent Details:");
        for (int i = 0; i < count; i++) {
            Student s = students[i];
            System.out.println("ID: " + s.getStudentId() + ", Name: " + s.getName() + ", Days Attended: " + s.getDaysAttended());
        }
    }
}

class MainStudent {
	public static void main(String[] args) {

        Classroom classroom = new Classroom();

        classroom.addStudent(new Student(101, "Alice Smith", 12));
        classroom.addStudent(new Student(102, "Bob Jones", 15));
        classroom.addStudent(new Student(103, "Carol Lee", 10));

        // Update Bob Jones’s attendance to 16
        classroom.updateAttendance(102, 16);

        // update to the  student who doesn't exit
        classroom.updateAttendance(104, 8);

		// Display all student details
        classroom.displayAllStudents();
	}
}
