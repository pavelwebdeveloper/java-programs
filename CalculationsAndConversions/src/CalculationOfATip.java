/** Import Scanner class from the java.util package */
import java.util.Scanner;

/**
 * @author Pavel Shvets
 * This financial application program calculates tips. The program reads in the subtotal and
 * the gratuity rate, then computes the gratuity and total and then displays them on the console.
 *
 */
public class CalculationOfATip {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Create a Scanner object
		
		// Prompt the user to enter the subtotal and gratuity rate
		System.out.print("Enter the subtotal and a gratuity rate: ");
		double subtotal = input.nextDouble(); 
		int gratuityRate = input.nextInt();
		
		// Compute gratuity
		double gratuity = subtotal * (gratuityRate / 100.0);
				
		// Compute total
		double total = subtotal + gratuity;
		
		// display the result
		System.out.format("The gratuity is $%3.1f and total is $%3.1f%n", gratuity, total);

	}

}