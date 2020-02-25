/* Nik Barbero
This program takes 3 quadratic coefficients from the user and solves for the values of x using the quadratic formula.
*/
import java.util.*; // for Scanner class
import java.text.*; // for DecimalFormat class

class QuadraticNB {
   public static void main(String[] args) {
      
      //introduces a Scanner and a DecimalFormat
      Scanner key = new Scanner(System.in);
      DecimalFormat df = new DecimalFormat("0.00");
      
      //introduction of the program and the quadratic equation
      System.out.println("This program will solve for the variable x for equations of the form Ax^2 + Bx + C = 0.");
      System.out.println();
      
      //retrieves 3 coefficients from the user, stores them as integer values, then prints the equation back to the user
      System.out.println("Please enter the values for the coefficients A, B, and C in that order. A cannot be zero.");
      double coA = key.nextDouble();
      double coB = key.nextDouble();
      double coC = key.nextDouble();
      System.out.println("You have entered the equation " + df.format(coA) + "x^2 + " + df.format(coB) + "x + " + df.format(coC) + " = 0");
      
      //plugs the coefficients into both the positive quadratic equation and the negative and solves for x
      double posResult = (-coB+(Math.sqrt(Math.pow(coB,2)-(4*coA*coC))))/(2*coA);
      double negResult = (-coB-(Math.sqrt(Math.pow(coB,2)-(4*coA*coC))))/(2*coA);
      
      //prints solutions back to the user
      System.out.println("The solutions are:");
      System.out.println("x = " + df.format(posResult));
      System.out.println("x = " + df.format(negResult));
      
      
      
   } // closes main method
} // closes the class