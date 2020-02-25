/*
   Program:       LargeNumberTest.java
   Author:        Nik Barbero
   Date:          3/22/2019
   Description:   A program to test the UnboundedInt class.
                  Manipulates UnboundedInt objects with the available methods.
*/
import java.util.*;

class LargeNumberTest {
   public static void main(String[] args) {
      
      /*
      *  Initializes all the necessary variables for the program.
      *  num1 and num2 are used to store string input for the constructor method.
      *  largeNum1 and largeNum2 store the users large integers.
      *  largeSum, largeProduct, and largeClone are used for their corresponding
      *     methods in the UnboundedInt class.
      *  flag is the control variable to keep the user in the menu until they quit.
      */
      Scanner key = new Scanner(System.in);
      String num1;
      String num2;
      UnboundedInt largeNum1;
      UnboundedInt largeNum2;
      UnboundedInt largeSum = new UnboundedInt();
      UnboundedInt largeProduct = new UnboundedInt();
      UnboundedInt largeClone;
      boolean flag = true;
      int menuChoice = 0;
      
      System.out.println("Welcome to the UnboundedInt tester!");
      System.out.println("Please enter two large integers to begin. (no commas)");
      
      // Stores user input for num1 and num2.
      // The unboundedIntInput() method ensures that all characters are integers.
      num1 = unboundedIntInput(key);
      num2 = unboundedIntInput(key);
      
      // Creates UnboundedInt objects from the string inputs.
      largeNum1 = new UnboundedInt(num1);
      largeNum2 = new UnboundedInt(num2);
      
      // The program is ran in a loop the exits when the user selects option 7. 
      while(flag) {
         System.out.println("\n\t1.\tDisplay both numbers (with commas)"
                           +"\n\t2.\tInput two new numbers (without commas)"
                           +"\n\t3.\tCheck if numbers are equal."
                           +"\n\t4.\tReport the sum of the two numbers"
                           +"\n\t5.\tReport the multiplication of the two numbers"
                           +"\n\t6.\tCreate and output the clone of the first number"
                           +"\n\t7.\tQuit");
         
         menuChoice = menu(7, key);
         System.out.println();
         
         switch(menuChoice) {
         
            // Prints both numbers using toString()
            case 1:  System.out.println(largeNum1.toString());
                     System.out.println(largeNum2.toString());
                     break;
            
            // Lets the user enter two new numbers and reassigns largeNum1 and largeNum2        
            case 2:  System.out.println("Enter two new numbers.");  
                     num1 = unboundedIntInput(key);
                     num2 = unboundedIntInput(key);
                     largeNum1 = new UnboundedInt(num1);
                     largeNum2 = new UnboundedInt(num2);
                     System.out.println("New numbers have been saved.");
                     break;
            
            // Checks if the numbers are equal using equals()         
            case 3:  if(largeNum2.equals(largeNum1)) {
                        System.out.println("The numbers are equal.");
                     } else {
                        System.out.println("The numbers are not equal.");
                     }
                     break;
            
            // Prints the sum of the two numbers using add() and toString()         
            case 4:  largeSum = largeNum1.add(largeNum2);
                     System.out.println("The sum of the two numbers is:\n" + largeSum.toString());
                     break;
            
            // Prints the producat of the two numbers using multiply() and toString()         
            case 5:  largeProduct = largeNum1.multiply(largeNum2);
                     System.out.println("The product of the two numbers is:\n" + largeProduct.toString());
                     break;
            
            // Clones the first number and prints it using clone() and toString()         
            case 6:  largeClone = largeNum1.clone();
                     System.out.println("The clone of the first number:\n" + largeClone.toString());
                     break;
            
            // Exits the program.         
            case 7:  flag = false;
                     System.out.println("Thank you for testing the UnboundedInt class!");
                     break;
         }
      }
      
      
   }//main
   
   // Takes user input intended for an UnboundedInt object.
   // Ensures that all characters in the string are integers.
   public static String unboundedIntInput(Scanner key) {
      boolean flag = true; 
      String num = new String("");
      
      // The method is ran in a loop that exits when a valid input has been entered.
      while(flag) {
         try {
            num = key.next();
            for(int i = 0; i < num.length(); i++) {
               if((int)num.charAt(i) < 48 || (int)num.charAt(i) > 57) {
                  throw new Exception("ERROR: 1 or more characters is not an integer."
                                     +"\nEnter a large integer, without commas.");
               }
            }
            flag = false;
         } catch(Exception e) {
            System.out.println(e.getMessage());
         }
      }
      
      return num;
   }
   
   //the menu() method is used as a try/catch block whenever a menu is displayed to the user in the program
   public static int menu(int a, Scanner key) { //requires the size of the menu and a scanner object
      boolean flag = true;
      int choice = -1;
      while(flag) { //keeps it in a loop to exit when a valid input is entered
         try {
            choice = key.nextInt(); //the user has been asked to enter which menu option they would like to choose
            if(choice < 1 || choice > a) {
               throw new Exception("Please select a valid menu option."); //new exception for inputs less than 1 and greater than the size of the menu
            }
            flag = false; //exits the loop when a valid input is entered
         } catch(InputMismatchException e) {
            System.out.println("Please enter an integer."); 
            key.next(); //clears the scanner for input mismatch errors
         } catch(Exception e) {
            System.out.println(e.getMessage()); //gets the message for inputs outside the range of menu options
         }
      }
      return choice; //returns the users valid input
   }//menu
}//class