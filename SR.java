import java.util.*;

class SR{
   public static void main(String[] args){
      
      Scanner key = new Scanner(System.in);
      key.useDelimiter(System.getProperty("line.separator"));
      
      System.out.println("Enter 0 at any time to exit.");
      System.out.print("Enter your initial SR: ");
      int sr1 = key.nextInt();
      System.out.println();
      int avg = 0;
      int sr2 = 1;
      int loop = 0;
      int winLoop = 0;
      int loseLoop = 0;
      int prevSR = sr1;
      
      while(sr2 != 0){
         System.out.print("Game " + (loop + 1) + ": ");
         sr2 = key.nextInt();
         if(sr2 == 0){
            sr2 = prevSR;
         }
         
         if(sr2 != prevSR){   
            if(sr2 > prevSR){
               winLoop++;
            } else if(sr2 < prevSR){ 
               loseLoop++;
            } else {
               loop--;
            }
         }
         if(sr2 == prevSR){
            prevSR = sr2;
            sr2 = 0;
         } else { 
            prevSR = sr2;
            loop++;
         } 
         avg = (prevSR-sr1)/loop;
         
      }
      System.out.println("\nTotal Games: " + loop);
      System.out.println("Total Wins: " + winLoop);
      System.out.println("Total Losses: " + loseLoop);
      System.out.println("Net SR: " + (prevSR-sr1));
      System.out.println("SR per game: " + avg);
   }
}