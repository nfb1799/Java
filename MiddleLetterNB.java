/* Nik Barbero
This program asks the user to enter a string of text and prints the middle character back to them.
*/
import java.util.*; // for Scanner class

class MiddleLetterNB { 
   public static void main(String[] args){
      
      //introduces a Scanner and sets the delimiter to the enter key
      Scanner key = new Scanner(System.in);
      key.useDelimiter(System.getProperty("line.separator"));
      
      //introduces the program to the user and skips a line
      System.out.println("This program will find the middle character in any string of text.");
      System.out.println();
      
      //asks the user to enter a string of text and saves it as a string
      System.out.println("Please enter a phrase or sentence.");
      String phrase = new String(key.next());
      
      int length = phrase.length(); // determines the length of the string
      int middle;
      
      //if the length is odd, it is divided by 2 to find the middle character and prints it back to the user
      if(length%2 != 0){
         middle = length/2;
         System.out.println("The middle character is '" + phrase.charAt(middle) + "'");
      /*if the length is even, it is divided by 2 then decreased by one. I subtracted 1 instead of rounding down because that changes the data type to double
      i subtracted 1 instead of rounding down because that changes the data type to double which cannot be used with the .charAt() method
      */
      } else {
         middle = (length/2)-1;  
         System.out.println("The middle character is '" + phrase.charAt(middle) + "'");
      }   
      
   } // closes main method
} // closes the class
      
      