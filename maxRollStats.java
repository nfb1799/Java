import java.util.*;

class maxRollStats {
   public static void main(String args[]) {
      int[] ranges = new int[20];
      Random numbers = new Random();
      int roll;
      
      for(int i = 0; i < 20; i++) {
         ranges[i] = 0;
      }
      
      for(int i = 0; i < 1000000; i++) {
         roll = numbers.nextInt(2147483646) + 1;
         if(roll <= 107374182)
            ranges[0]++;
         else if(roll <= 214748364)
            ranges[1]++;
         else if(roll <= 322122546)
            ranges[2]++;
         else if(roll <= 429496728)
            ranges[3]++;
         else if(roll <= 536871540)
            ranges[4]++;
         else if(roll <= 644245722)
            ranges[5]++;
         else if(roll <= 751620534)
            ranges[6]++;
         else if(roll <= 858995346)
            ranges[7]++;
         else if(roll <= 966370158)
            ranges[8]++;
         else if(roll <= 1073744970)
            ranges[9]++;
         else if(roll <= 118119782) 
            ranges[10]++;
         else if(roll <= (118119782 + 107374182*1))
            ranges[11]++;
         else if(roll <= (118119782 + 107374182*2))
            ranges[12]++;  
         else if(roll <= (118119782 + 107374182*3))
            ranges[13]++;  
         else if(roll <= (118119782 + 107374182*4))
            ranges[14]++;  
         else if(roll <= (118119782 + 107374182*5))
            ranges[15]++;
         else if(roll <= (118119782 + 107374182*6))
            ranges[16]++; 
         else if(roll <= (118119782 + 107374182*7))
            ranges[17]++;
         else if(roll <= (118119782 + 107374182*8))
            ranges[18]++;
         else if(roll <= (118119782 + 107374182*9))
            ranges[19]++;
      } 
      
      for(int i = 0; i < 20; i++) {
         //ranges[i] /= 10000;
         System.out.println(ranges[i]);
      
      }
   }
}