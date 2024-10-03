package task2;



	import java.util.ArrayList;
	import java.util.Scanner;

	public class StudentGradeTracker {
	    private ArrayList<Double> grades;

	    public StudentGradeTracker() {
	        grades = new ArrayList<>();
	    }

	    public void addGrade(double grade) {
	        grades.add(grade);
	    }

	    public double calculateAverage() {
	        if (grades.isEmpty()) {
	            return 0.0;
	        }
	        double sum = 0.0;
	        for (double grade : grades) {
	            sum += grade;
	        }
	        return sum / grades.size();
	    }

	    public String getLetterGrade(double average) {
	        if (average >= 90) {
	            return "A";
	        } else if (average >= 80) {
	            return "B";
	        } else if (average >= 70) {
	            return "C";
	        } else if (average >= 60) {
	            return "D";
	        } else {
	            return "F";
	        }
	    }

	    public double calculateGPA(double average) {
	        // Simple GPA calculation assuming a scale of 4.0
	        if (average >= 90) {
	            return 4.0;
	        } else if (average >= 80) {
	            return 3.0;
	        } else if (average >= 70) {
	            return 2.0;
	        } else if (average >= 60) {
	            return 1.0;
	        } else {
	            return 0.0;
	        }
	    }

	    public void displayResults() {
	        double average = calculateAverage();
	        String letterGrade = getLetterGrade(average);
	        double gpa = calculateGPA(average);

	        System.out.printf("Average Grade: %.2f%n", average);
	        System.out.printf("Letter Grade: %s%n", letterGrade);
	        System.out.printf("GPA: %.2f%n", gpa);
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        StudentGradeTracker tracker = new StudentGradeTracker();

	        System.out.println("Student Grade Tracker");
	        while (true) {
	            System.out.print("Enter a grade (or type 'done' to finish): ");
	            String input = scanner.nextLine();
	            if (input.equalsIgnoreCase("done")) {
	                break;
	            }
	            try {
	                double grade = Double.parseDouble(input);
	                tracker.addGrade(grade);
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter a valid grade.");
	            }
	        }

	        tracker.displayResults();
	    }
	}


