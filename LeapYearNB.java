/* Nik Barbero
This program asks the user to enter a year and determines if that year is a leap year or not.
*/
import java.util.*; // for Scanner class

class LeapYearNB {
   public static void main(String[] args){
      
      //introduces a scanner
      Scanner key = new Scanner(System.in);
      
      //introduces the program to the user then skips a line
      System.out.println("This program will determine if a given year is a leap year or not.");
      System.out.println();
      
      //asks the user to enter a year and saves it as an integer
      System.out.println("Please enter a year.");
      int year = key.nextInt();
      
      /*determines if a year is a leap year and prints the results back to the user
      a year is a leap year if it is divisible by 4 but not 100 
      */
      if(year%4 == 0 && year%100 != 0){
         System.out.println("This is a leap year!");
      } else if(year%4 == 0 && year%100 == 0 && year%400 == 0){ // a year that is divisible by both 4 and 100 is a leap year if it is divisible by 400
         System.out.println("This is a leap year!");
      } else {
         System.out.println("This is not a leap year.");
      } 
      
   } // closes the main method
} // closes the class