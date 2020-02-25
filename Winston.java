import java.util.*;

class Winston {
   public static void main(String[] args){
      
      Scanner key = new Scanner(System.in);
      
      System.out.println("How long was your target beam connected to an enemy?");
      int beamDMG = (key.nextInt())*60;
      System.out.println("How many people did you hit when landing?");
      int landDMG = (key.nextInt())*40;
      System.out.println("How many smacks connected in your ult?");
      int ultDMG = (key.nextInt())*40;
      int totalDMG = beamDMG+landDMG+ultDMG;
      System.out.println("You did a total of " + totalDMG + " damage.");
      
   }
}