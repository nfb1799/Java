import java.util.*;

class ArrayLab2 {
   public static void main(String[] args) {
      
      Scanner key = new Scanner(System.in);
      key.useDelimiter(System.getProperty("line.separator"));
      String[] array = new String[5];
      
      System.out.println("Please enter 5 words/phrase/senteces to see their length.");
      for(int i = 0; i < array.length; i++){
         System.out.println("Enter string " + (i+1) + ":");
         array[i] = key.next();
      }
      
      for(String phrase : array) {
         System.out.print(phrase + ": ");
         System.out.println(phrase.length() + " characters");
      }
   }
}