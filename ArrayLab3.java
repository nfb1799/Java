import java.util.*;
import java.text.*;

class ArrayLab3 {
   public static void main(String[] args) {
   
      Scanner key = new Scanner(System.in);
      DecimalFormat df = new DecimalFormat("0.000");
      boolean flag = true;
      int inputs = 0;
      double numbers[] = new double[1];
      
      System.out.println("This program will find the standard deviation of a set of numbers.");
      
      while(flag) {
         try{
            System.out.println("How many numbers will you be entering?");
            inputs = key.nextInt();
            flag = false;
            numbers = new double[inputs];
         } catch(InputMismatchException e) {
            System.out.println("Invalid input.");
            key.next();
         }
      }
      
      for(int i=0; i < inputs; i++) {
         try {
            System.out.println("Enter value " + (i+1) + ": ");
            numbers[i] = key.nextDouble();
         } catch(InputMismatchException e) {
            System.out.println("Invalid input.");
            key.next();
            i--;
         }
      }
      
      System.out.print("You entered the values ");
      for(int j=0; j < numbers.length; j++) {
         if(j != (numbers.length - 1)) {
            System.out.print(numbers[j] + ", ");
         } else {
            System.out.println(numbers[j] + ".");
         }
      }
      
      System.out.println("The standard deviation is " + df.format(stDev(numbers)) + ".");
            
   }
   public static double stDev(double[] a) {
      double s = 0;
      double avg = 0;
      
      for(int i=0; i < a.length; i++) {
         avg = avg + a[i];
      }
      avg = avg/(double)(a.length);
      
      for(int j = 0; j < a.length; j++) {
         s = s + Math.pow((a[j]-avg),2);
      }
      s = Math.sqrt(s/a.length);
      return s;
   }
}