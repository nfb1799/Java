import java.util.*;

class FamilyAge {
   public static void main(String[] args) {
      
      Scanner key = new Scanner(System.in);
      int age;
      int[] ages = new int[10];
      boolean flag = true;
      int counter = 1;
      
      System.out.println("Please enter the age of each family member.");
      System.out.println("Enter 0 to exit.");
      
      while(flag) {
         System.out.print("Member " + counter + ": ");
         age = key.nextInt();
         
         if(age == 0) {
            flag = false;
            continue;
         }
         
         ages[counter-1] = age;
         counter++;
      }
      
      System.out.println("Ages:");
      for(int i = 0; i < (counter-1); i++) 
         System.out.println(ages[i]);
   }//main
   
   public void removeElement(int[] ages, int element) {
      int j = 0;
      
      for(int i = 0; i < ages.length; i++){
      
         if((i+1) == element)
            i++;
            
         ages[j] = ages[i];
         j++;
      }
   }
   
}//class