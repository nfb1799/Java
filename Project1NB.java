/* This program will perform three tasks.
Task 1: Perform various calculations on two numbers input by the user.
Task 2: Performs operations on sentences input by the user.
Task 3: Gives the user a lucky number using a random number generator.
*/
import java.text.*; // for DecimalFormat
import java.util.*; // for Random and Scanner

class Project1NB {
   public static void main(String[] args) {
   
      Scanner key = new Scanner(System.in); // introduces a scanner called key
      
      // introduces two DecimalFormat objects
      DecimalFormat df = new DecimalFormat("0.000"); 
      DecimalFormat df2 = new DecimalFormat("0");
      
      // introduces the program to the user
      System.out.println("Task 1: This portion of the program will perform various mathematical operations on two numbers.");
      System.out.println(); // skips a line
   
      System.out.println("Please input two numbers.");
      int num1 = key.nextInt(); // uses the scanner to save the next integer as a variable
      int num2 = key.nextInt();
      
      // performs different computations on the numbers
      int sum = num1+num2;
      int diff = num1-num2; // subtracts the numbers and saves the value as an integer
      int prod = num1*num2;
   
      // prints results of different computations
      System.out.println("The sum of the numbers is " + sum + ".");
      System.out.println("The difference of the numbers is " + diff + ".");
      System.out.println("The product of the numbers is " + prod + ".");
      System.out.println("The larger of the two numbers is " + Math.max(num1,num2) + ".");
      
      double expo = Math.pow(num1,num2);
      
      System.out.println(num1 + "^" + num2 + "=" + df2.format(expo) + ".");
      
      double low = Math.sqrt(Math.min(num1,num2)); // finds the lower of the two numbers
      System.out.println("The square root of the lower number is " + df.format(low) + ".");
      
      // performs exponent and square root equations
      double sq1 = Math.pow(num1,2);
      double sqrt2 = Math.sqrt(num2);
      
      // prints results of specific equatoins
      System.out.println("The square root of the second number is " + df.format(sqrt2) + ".");
      System.out.println("(" + num1 + "^2" + ")" + "*" + df.format(sqrt2) + "=" + df.format(sq1*sqrt2));
      
      System.out.println(); // skips two lines for the next task
      System.out.println();
      System.out.println("Task 2: This portion of the program will manipulate strings of text.");
      System.out.println();
      
      // retrieves a string until the first 'enter'
      key.useDelimiter(System.getProperty("line.separator")); // sets the delimiter to the enter key
      System.out.println("Please enter a complete sentence.");
      String sent1 = new String(key.next()); // saves the next sentence as a string
      System.out.println("You entered: " + sent1);
      
      // prints the number of characters and the sentence from index 1
      int length = (sent1.indexOf(".")+1); // gets the index of the period and adds 1
      System.out.println("Your sentence has " + length + " characters.");
      System.out.println("Your sentence without the first letter is: " + sent1.substring(1,length));
      
      // gets the second sentence from the user and prints both as well as the index of the space
      System.out.println();
      System.out.println("Please enter another complete sentence.");
      String sent2 = new String(key.next());
      System.out.println("Your sentences are: " + sent1 + " " + sent2);
      int space = sent1.indexOf(" "); // creates integer value for the index of the first space
      System.out.println("The first space is located at index " + space + ".");
      
      System.out.println(); // skips two lines for the next task
      System.out.println();
      System.out.println("Task 3: This portion of the program will give you a lucky number.");
      System.out.println();
      
      Random ran = new Random(); // introduces an RNG called ran
            
      // gets an upper value from the user and prints a lucky number
      System.out.println("What number would you like to use as the upper value?");
      int upper = key.nextInt();
      int luckyNum = ran.nextInt(upper);
      System.out.println("Your lucky number is " + luckyNum + ".");
      
      System.out.println();
      System.out.println();
      System.out.print("Thank you for using my program.");
 
   
   } // closes main method
} // closes class