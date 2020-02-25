import java.util.*;

class ExamReview2 {
   public static void main(String[] args){
      
      for(int i=2; i<=100; i+=2){
         System.out.println(i);
      }
      
      int j = 2;
      while(j <= 100){
         System.out.println(j);
         j+=2;
      }
      
      int k = 1;
      int x = 1;
      while(k<=6){
         System.out.print("*");
         while(x<=3){
            System.out.print("*");
            x++;
         }
         x=1;
         System.out.println();
         k++;
      }
      
      Scanner scan = new Scanner(System.in);
      try{
         System.out.println("Enter a whole number:");
         int value = scan.nextInt();
         System.out.println("You entered: " + value);
      } catch (InputMismatchException e){
         System.out.println("Wrong type.");
      } catch (Exception e){
         System.out.println("Something went wrong.");
      } finally {
         System.out.println("That's it.");
      }

   }
}