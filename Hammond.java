import java.util.*;

class Hammond {
   public static void main(String[] args) {
      
      Scanner key = new Scanner(System.in);
      
      System.out.println("How many shots were hit?");
      int shots = key.nextInt();
      System.out.println("How many of those shots were headshots?");
      int headshots = key.nextInt();
      int bodyshots = shots-headshots;
      
      System.out.println("How many people were knocked back?");
      int knockB = key.nextInt();
      
      System.out.println("How many people were knocked up directly?");
      int knockU = key.nextInt();
      System.out.println("How many people were knocked up inderectly?");
      int knockU2 = key.nextInt();
      
      System.out.println("How many mines did damage?");
      int mines = key.nextInt();
      
      double bodyDMG = bodyshots*2.5;
      int headDMG = headshots*5;
      int knockBDMG = knockB*50;
      int knockUDMG = (knockU*100)+(knockU2*75);
      int mineDMG = mines*130;
      
      double totalDMG = bodyDMG+headDMG+knockBDMG+knockUDMG+mineDMG;
      
      System.out.println();
      System.out.println("You did a total of " + (int)totalDMG + " damage.");
      
   }
}