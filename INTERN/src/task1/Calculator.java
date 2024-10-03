package task1;

import java.util.Scanner;

public class Calculator {
	
	public double add(double number1,double number2) {
		
		return number1+number2;
		
	}
	public double sub(double number1,double number2) {
		
		return number1-number2;
		
	}
	public double mul(double number1,double number2) {
		
		return number1*number2;
		
	}
	public double div(double number1,double number2) {
		
		return number1/number2;
		
	}

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter the first number:");
		double n1=scanner.nextDouble();
		
		System.out.println("Enter the Second number:");
		double n2=scanner.nextDouble();
		
		Calculator calculator=new Calculator();
		
		System.out.println("Choose  the Operation: ");
		System.out.println(" 1 .Addition \n 2 . Subtraction \n 3 . Multiplaction \n 4 . Division");
		int choice=scanner.nextInt();
		
		double result;
		if (1==choice) {
			result = calculator.add(n1, n2);
		    System.out.println("Addition = "+result);
		}
		else if (2==choice) {
			result = calculator.sub(n1, n2);
			System.out.println("Subtraction = "+result);
		}
		else if (3==choice) {
			result = calculator.mul(n1, n2);
			System.out.println("Multiplaction = "+result);
		}
		else if (4==choice) {
			result = calculator.div(n1, n2);
			System.out.println("Division = "+result);
		}
		else {
			System.out.println(" ***** Please Enter the valid Number *****");
		}
		
	}
}