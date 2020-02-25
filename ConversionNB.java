/* Nik Barbero
   This program allows the user to choose and perform different conversions.
   The user navigates through a menu after each use.
   If the user chooses menu option 5, the program will end.
*/
import java.util.*; //for Scanner
import java.text.*; //for DecimalFormat

class ConversionNB {
   public static void main(String[] args) {
   
   System.out.println("Welcome to my conversion program."); //introduces the program
   //introduces a Scanner, DecimalFormat, a user choice variable, and 4 flags
   Scanner key = new Scanner(System.in);
   DecimalFormat df = new DecimalFormat("0.00");
   int choice = 0;
   boolean flag1 = true;
   boolean flag2 = true;
   boolean flag3 = true;
   boolean flag4 = true;
   
      while(choice != 5){ //5 is the exit condition
         //the menu is all one print statement
         System.out.println("\nSelect your desired menu option to continue:\n1 - Miles to Kilometers\n2 - Inches to Centimeters\n3 - Kilograms to Pounds\n4 - Fahrenheit to Celcius\n5 - Exit\n");
         choice = 0; //resets the choice at the start of the loop
         try {
            choice = key.nextInt(); //saves the users choice into a variable
            if(choice < 1 || choice > 5){
               throw new Exception("ERROR: Input must be an integer between 1 and 5."); //new exception for numbers less than 1 or greater than 5
            }
         } catch(InputMismatchException e) {
            System.out.println("ERROR: Input must be an integer."); //input mismatch exception
            key.next(); //clears the scanner of any buffers
         } catch(Exception e) {
            System.out.println(e.getMessage()); //prints the message for the custom exception
         }
         
         /* This switch is triggered by the users menu choice.
            Each case has its own while loop to keep the user in the same menu option when they enter an invalid key.
            If the user chooses choice 5, the program will end. 
         */
         switch(choice){
            case 5:  System.out.println("Thank you. Goodbye."); //print when the user exits
                     break;
            case 4:  while(flag4) { //while flag4 is true
                        try{ 
                           System.out.println("Enter the temperature in F:"); //asks the user for temp F
                           double f = key.nextDouble(); //saves the users input as a double
                           System.out.println(f + " degrees F is equal to " + df.format(convertF(f)) + " degrees C."); //prints the input and the converted value
                           flag4 = false; //exits the while loop
                        } catch(Exception e) {
                           System.out.println("ERROR: Please enter a number."); //input mismatch
                           key.next(); //clears scanner
                        }
                     }
                     flag4 = true; //resets the flag for next use
                     break;
            case 3:  while(flag3) {
                        try{
                           System.out.println("Enter number of kilograms:"); //asks user for number of kg
                           double kg = key.nextDouble(); //saves number of kg as double
                           if(kg < 0){
                              throw new Exception("ERROR: Please enter a positive number."); //kg cannot be negative
                           }
                           System.out.println(kg + " kilograms is equal to " + df.format(convertKilograms(kg)) + " pounds."); //prints the users input and the conversion
                           flag3 = false; //exits the while loops
                        } catch(InputMismatchException e) { 
                           System.out.println("ERROR: Please enter a number."); //input mismatch
                           key.next(); //clears scanner
                        } catch(Exception e) {
                           System.out.println(e.getMessage()); //gets the error message for negative inputs
                        }
                     }
                     flag3 = true; //resets the flag
                     break;
            case 2:  while(flag2) {
                        try{
                           System.out.println("Enter number of inches:"); //asks user for number of inches
                           double inches = key.nextDouble(); //saves inches as a double
                           if(inches < 0){
                              throw new Exception("ERROR: Please enter a positive number."); //exception for negative numbers
                           }
                           System.out.println(inches + " inches is equal to " + df.format(convertInches(inches)) + " centimeters."); //prints the users input and the converted value
                           flag2 = false; // exits the while loop
                        } catch(InputMismatchException e) { 
                           System.out.println("ERROR: Please enter a number."); //input mismatch
                           key.next();
                        } catch(Exception e) {
                           System.out.println(e.getMessage()); //prints the error message for negative numbers
                        }
                     }
                     flag2 = true; //resets the flag
                     break;
            case 1:  while(flag1) {
                        try{
                           System.out.println("Enter number of miles:"); //asks the user for number of miles
                           double miles = key.nextDouble(); //saves the number of miles as a double
                           if(miles < 0){ 
                              throw new Exception("ERROR: Please enter a positive number."); //new exception for negative numbers
                           }
                           System.out.println(miles + " miles is equal to " + df.format(convertMiles(miles)) + " kilometers."); //prints the users input and the converted value
                           flag1 = false; //exits the while loops
                        } catch(InputMismatchException e) { 
                           System.out.println("ERROR: Please enter a number."); //input mismatch
                           key.next(); //clears scanner
                        } catch(Exception e) {
                           System.out.println(e.getMessage()); //prints the error message for negative numbers
                        }
                     }
                     flag1 = true; //resets the flag
                     break;
         }//switch
                      
      }//while loop  
   }//main
   
   public static double convertMiles(double a){ //converts miles to km
      double km = a*1.60934;
      return km;
   }
   
   public static double convertInches(double a){ //converts inches to cm
      double cm = a*2.54;
      return cm;
   }
   
   public static double convertKilograms(double a){ //converts kg to lb
      double lb = a*2.20462;
      return lb;
   }
   
   public static double convertF(double a){ //converts F to C
      double c = ((a-32)*5)/9;
      return c;
   }
      
}//class