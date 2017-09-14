package edu.wit.cs.comp1000;

/** PA1b
 * Second Programming Assignment:
 * Carpenter's Conversion Tool
 * 
 * @author Miles Macchiaroli
 */
import java.util.Scanner; //Tell java we're gonna take input
public class PA1b {
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
	
		System.out.printf("Enter number of inches: ");
		inch = input.nextInt(); // request value for inches
		yards = (inch / 36); // Calculate total yards
		inch = inch - (yards * 36); // Remove Inches put towards yard calculation
		feet = (inch / 12); // Calculate total feet
		inch = inch - (feet * 12); // Remove Inches put towards foot calculation
	
		System.out.printf("Yards: %d%n", yards); // Output Yards
		System.out.printf("Feet: %d%n", feet); // Output feet
		System.out.printf("Inches: %d%n", inch); // Output inch

	}

}
