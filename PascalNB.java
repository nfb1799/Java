/* Nik Barbero
   This program will print a given number of lines of the Pascal triangle.
*/
import java.util.*;

class PascalNB {
   public static void main(String[] args) {
      
      //initializes all the necessary objects and variables
      Scanner key = new Scanner(System.in);
      boolean flag = true;
      int input = 1;
      
      System.out.println("This program will print successive lines of the Pascal triangle.");
      while(flag) {
         try{
            System.out.println("How many lines would you like to print?"); //asks the users how many lines they would like to print
            input = key.nextInt();
            if(input <= 0) { //input must be greater than 0
               throw new Exception("You must print at least 1 line.");
            }
            flag = false; //exits the while loop when a valid input is entered
         } catch(InputMismatchException e) {
            System.out.println("You must enter an integer."); //input mismatch error message
            key.next(); //clears the scanner
         } catch(Exception e) {
            System.out.println(e.getMessage()); //retrieves the message for numbers less than 1
         }
      }//while 
      
      int[][] triangle = new int[input][]; //creates a 2D array with the number of line that the user entered
      
      for(int i = 0; i < input; i++) {
         triangle[i] = new int[i+1];
         triangle[i][0] = 1; //the first value is always 1
         if(i > 1) { //doesn't enter until the third line
            for(int j = 1; j < i; j++) {
               triangle[i][j] = (triangle[i-1][j-1] + triangle[i-1][j]); //sets the values of each line of the array as the sum of the two above it
            }
         }
        triangle[i][i] = 1; //the last value is always 1
      }//for
   
      
      for(int k = 0; k < input; k++) {
         int x = (input - k) - 1; //sets x for the number of tabs to format as a triangle
         while(x > 0){
            System.out.print("\t");//prints one less tab every loop
            x--;
         }
         for(int m = 0; m < triangle[k].length; m++) {
            System.out.print(triangle[k][m] + "\t\t"); //prints the values of the array with 2 tabs in between
         }
         System.out.println(); //skips a line after each line is printed 
      }//outer for loop
   }//main
}//class