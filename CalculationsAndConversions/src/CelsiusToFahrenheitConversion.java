/** Import Scanner class from the java.util package */
import java.util.Scanner;
/**
 * @author Pavel Shvets
 * This application program converts Celsius to Fahrenheit. The program reads a Celsius degree
 * in a double value from the console, then converts it to Fahrenheit, and displays the result
 *
 */
public class CelsiusToFahrenheitConversion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create a Scanner object
		Scanner input = new Scanner(System.in);
		
		// Prompt the user to enter a Celsius degree in a double value
		System.out.print("Enter a degree in Celsius: ");
		
		// read a double value entered by the user
		double celsius = input.nextDouble();
		
		// Compute Fahrenheit according to the conversion formula and assign the result
		// to the fahrenheit variable with a double value
		double fahrenheit = (9.0 / 5) * celsius + 32;
		
		// display the result for the calculated Fahrenheit value
		System.out.format("%3.1f Celsius is %4.1f Fahrenheit", celsius, fahrenheit);

	}

}
