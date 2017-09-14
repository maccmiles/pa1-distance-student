package edu.wit.cs.comp1000;

/**
 * Second Programming Assignment:
 * Carpenter's Conversion Tool
 * 
 * @author Miles Macchiaroli
 */
import java.util.Scanner; //Tell java we're gonna take input
public class PA1a {
	/**
	 * Starts the program, Converts measurements
	 * 
	 * @param args command-line arguments, ignored
	 */
	public static void main(String[] args) { // begin Main String
		Scanner input = new Scanner(System.in); //Start Scanner
		int yards; // init yards
		int feet; // init feet
		int inch; // init inches
		int total;
	
		System.out.printf("Enter number of yards: ");
		yards = input.nextInt(); // request value for yards
		System.out.printf("Enter number of feet: ");
		feet = input.nextInt(); // request value for feet
		System.out.printf("Enter number of inches: ");
		inch = input.nextInt(); // request value for inches
		total = (yards * 36) + (feet * 12) + inch; // Calculate total inches
	
		System.out.printf("Total number of inches: %d%n", total); // Output Total

	}

}
