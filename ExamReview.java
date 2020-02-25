import java.util.*;

class ExamReview {
   public static void main(String[] args) {
      
      System.out.println("Hello! Welcome to my program. I will tell you how many factors a number has. Enter 0 at any time to exit.");
      Scanner key = new Scanner(System.in);
      int input;
      boolean flag = true;
      
      while(flag){
         try{
            System.out.print("Enter a number: ");
            input = key.nextInt();
            if(input < 0){
               throw new Exception("Numbers must be positive.");
            }
            if(input == 0){
               flag = false;
               System.out.println("Thank you. Goodbye.");
            } else {
                System.out.println(input + " has " + factors(input) + " factors.");
            }  
         } catch(InputMismatchException e) {
            System.out.println("Only numbers are allowed.");
            key.next();
         } catch(Exception e) {
            System.out.println(e.getMessage());
         }
      }
         
      
      
   }
   public static int factors(int a) {
      int j = 0;
      for(int i=1; i<=a; i++){
         int factor = a%i;
         if(factor == 0){
            j++;
         }
      }
      return j;
   }
      
}
