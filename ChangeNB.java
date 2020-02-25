/* Nik Barbero
This program asks the user how much an item costs and how much they paid for it.
The program determines the amount of change and the number of each denomination of money the user will recieve.
It prints those values back to the user.
*/
import java.util.*; // for Scanner class
import java.text.*; // for DecimalFormat class

class ChangeNB {
   public static void main(String[] args) {
      
      //introduces a Scanner and a DecimalFormat
      Scanner key = new Scanner(System.in);
      DecimalFormat df = new DecimalFormat("0.00");
      
      //introduces the program to the user then skips a line
      System.out.println("This program will compute change and the number of each denomination of change the customer will recieve.");
      System.out.println();
      
      //asks the user how much the product costs and how much they paid
      System.out.println("Please enter the cost of the product.");
      double cost = key.nextDouble();
      System.out.println("Please enter the amount paid.");
      double paid = key.nextDouble();
      //computes the change and prints it back to the user
      double change = (paid-cost);
      System.out.println("Your change is $" + df.format(change));
      
      //solves for the number of each denomination of money the user will recieve starting with one-dollar bills
      double twentyRem = change%20;
      double twenties = (change-twentyRem)/20; // the number of twenties
      
      double tenRem = twentyRem%10;
      double tens = (twentyRem-tenRem)/10; // the number of tens
      
      double fiveRem = tenRem%5;
      double fives = (tenRem-fiveRem)/5; // the number of fives
      
      double oneRem = fiveRem%1;
      double ones = (fiveRem-oneRem)/1; // the number of ones
      
      double quartRem = oneRem%0.25;
      double quarters = (oneRem-quartRem)/0.25; // the number of quarters
      
      double dimeRem = quartRem%0.10;
      double dimes = (quartRem-dimeRem)/0.10; // the number of dimes
      
      double nickelRem = dimeRem%0.05;
      double nickels = (dimeRem-nickelRem)/0.05; // the number of nickels
      
      double pennies = Math.round(nickelRem/0.01); // the number of pennies rounded because of typecasting in lines 110 and 112
      
      System.out.println("You will recieve:");
      
      /*prints the number of each denomination of money back to the user using if else statements for proper english
      if the number of a certain currency is 0, nothing will print for that currency
      */
      if(twenties > 0){
         if((int)twenties == 1)
            System.out.println((int)twenties + " Twenty-dollar bill.");
         else
            System.out.println((int)twenties + " Twenty-dollar bills.");
      }
      
      if(tens > 0){
         if((int)tens == 1)
            System.out.println((int)tens + " Ten-dollar bill.");
         else
            System.out.println((int)tens + " Ten-dollar bills.");
      }
      
      if(fives > 0){
         if((int)fives == 1)
            System.out.println((int)fives + " Five-dollar bill.");
         else
            System.out.println((int)fives + " Five-dollar bills.");
      }
      
      if(ones > 0){
         if((int)ones == 1)
            System.out.println((int)ones + " One-dollar bill.");
         else 
            System.out.println((int)ones + " One-dollar bills.");
      }
      
      if(quarters > 0){
         if((int)quarters == 1)
            System.out.println((int)quarters + " Quarter.");
         else
            System.out.println((int)quarters + " Quarters.");
      }
      
      if(dimes > 0){ 
         if((int)dimes == 1)
            System.out.println((int)dimes + " Dime.");
         else
            System.out.println((int)dimes + " Dimes.");
      }
      
      if(nickels > 0){
         if((int)nickels == 1)
            System.out.println((int)nickels + " Nickel.");
         else
            System.out.println((int)nickels + " Nickels.");
      }
      
      if(pennies > 0){
         if((int)pennies == 1)
            System.out.println((int)pennies + " Penny.");
         else 
            System.out.println((int)pennies + " Pennies.");
      }
   } // closes the main method
} // closes the class