/** Import Scanner class from the java.util package */
import java.util.Scanner;

/**
 * @author Pavel Shvets
 * This application program computes the volume of a cylinder. The program reads in the radius
 * and length of a cylinder, computes the area and volume using two formulas and displays
 * the calculated area and volume 
 *
 */
public class VolumeOfACylinderComputation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final double PI = 3.14159; // Declare a constant
		
		Scanner input = new Scanner(System.in); // Create a Scanner object
		
		// Prompt the user to enter the radius and length
		System.out.print("Enter the radius and length of a cylinder: ");
		double radius = input.nextDouble(); 
		double length = input.nextDouble();
		
		// Compute area
		double area = radius * radius * PI;
		
		// Compute volume
		double volume = area * length;
		
		// display the result
		System.out.format("The area is %6.4f%n", area);
		System.out.format("The volume is %6.1f%n", volume);

	}

}