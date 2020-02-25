/* Nik Barbero
   This program determines whether or not a number is perfect.
   A number is perfect when the sum of all of its divisors is itself.
   The program prints the divisors and the current sum as it finds them. 
   The user may enter 0 at any time to end program.
*/
import java.util.*; //for Scanner

class PerfectNB {
   public static void main(String[] args) {
      
      //introduces the program and the exit condition
      System.out.println("This program will determine whether or not a number is  perfect. Enter 0 at any time to end the program.\n");
      
      //introduces a scanner, random, and some variables for later use
      Scanner key = new Scanner(System.in);
      Random ran = new Random();
      int number = 2;
      int divisor;
      int sum;
      int counter = 0;
     
      while(number != 0){//exit condition is when number = 0
         sum = 0; //the sum is reset to 0 at the start of the loop
         number = -1; //number is reset to -1 so the program doesn't run from misinputs
         counter++; //adds 1 to the counter at the beginning of the loop
         
         if(counter == 4){ //prints a user tip on every fourth attempt
            System.out.println("TIP: "+ tip(ran.nextInt(5)+1) +" is a perfect number. Try it out!");
            counter = 0;
         }
         
         try {
            System.out.println("Please enter a number: ");//asks the user for a number
            number = key.nextInt();//saves the number into a variable
            if(number < 0){
               throw new Exception("ERROR: Numbers must be positive.\n"); //new exception for negative numbers
            }
         } catch(InputMismatchException e) {
            System.out.println("ERROR: Inputs must be integers.\n"); //input mismatch exception 
            key.next(); //clears the scanner of any buffers
         } catch(Exception e) { 
            System.out.println(e.getMessage()); //retrieves the message for negative numbers
         }
         
         //a loop that divides the users number by every number less than the number and prints back divisors
         for(divisor = 1; divisor<number; divisor++){
            int remainder = number%divisor;
            if(remainder == 0){ //when a divisor is found
               sum = sum + divisor; //sum starts at 0 and is added to as the loop runs
               System.out.println("Divisor: " + divisor + " Sum: " + sum); //continuously prints the divisor and the sum back
            }
         } //for loop
         
         if(sum != 0){ //doesn't print during an exit condition
            if(sum == number){
               System.out.println(sum + " is equal to " + number + ". This is a perfect number!\n");
            } else {
               System.out.println(sum + " is not equal to " + number + ". This is not a perfect number.\n");  
            }          
         } 
      } //while loop
      
      System.out.println("Thank you. Goodbye."); //prints when the user exits
   }//main
   
   public static int tip(int a){ //takes in an integer and returns 1 of 5 perfect numbers
      int b = 0;
      switch(a){
         case 5:  b = 6;
                  break;
         case 4:  b = 28;
                  break;
         case 3:  b = 496;
                  break;
         case 2:  b = 8128;
                  break;
         case 1:  b = 33550336;
                  break;
      }
      return b;
   }//tip
}//class