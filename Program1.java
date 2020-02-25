import java.util.*;

class Program1 {
   public static void main(String[] args) {
   
      System.out.println("Welcome to my program. Enter 0 at any time to exit.\n");
      
      Scanner key = new Scanner(System.in);
      int choice1 = 1;
      int choice2 = 1;
      boolean flag = true;
      
      while(flag){
         try{
            System.out.println("Enter two numbers and I will give you the larger of the absolute values of each number.");
            choice1 = key.nextInt();
            if(choice1!=0){
               choice2 = key.nextInt();
               if(choice2!=0)
                  System.out.println("The larger value is " + greaterAbsolute(choice1, choice2) + ".");
               else
                  flag = false;
            } else {
               flag = false;
            }
         } catch(Exception e) {
            System.out.println("ERROR: Input must be two integers.");
            key.next();
         }
      }
      System.out.println("Thank you. Goodbye.");
      
   } // main
   
   public static int greaterAbsolute(int a, int b) {
      int great;
      if(Math.abs(a) < Math.abs(b)) {
         great = Math.abs(b);
      } else {
         great = Math.abs(a);
      }
      return great;
   }//greaterAbsolute
} // class