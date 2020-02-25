import java.util.*;
import java.io.*;

class Tespa {
   public static void main(String args[]) {
      
      File data = new File("matchups.txt");
      Scanner key = new Scanner(System.in);
      
      double[][] matchups = new double[7][11];
      
      //Our decks
      final int RES_PRIEST = 0;
      final int WARRIOR = 1;
      final int ROGUE = 2;
      final int SHAMAN = 3;
      final int DRUID = 4;
      final int HUNTER = 5;
      final int COMBO_PRIEST = 6;
      
      //The field
      final int Res_Priest = 0;
      final int Combo_Priest = 1;
      final int Quest_Shaman = 2;
      final int Evolve_Shaman = 3;
      final int Quest_Druid = 4;
      final int Maly_Druid = 5;
      final int Hunter = 6;
      final int Warrior = 7;
      final int Rogue = 8;
      final int High_Paladin = 9;
      final int Wrath_Paladin = 10;
      
      try {
         key = new Scanner(data);
      } catch(FileNotFoundException e) {
         System.out.print("Error");
      }
      
      //fills matchup array
      for(int i = 0; i < 7; i++) {
         for(int j = 0; j < 11; j++) {
            matchups[i][j] = key.nextDouble();
         }
      }
      
      for(
      
         
   }//main
   
   public static void PrintData(double[][] data) {
   
      for(int i = 0; i < 7; i++) {
         for(int j = 0; j < 11; j++) {
            System.out.print(data[i][j] + "\t");
         } 
         System.out.println();
      }

   }//PrintData
   
   public static int[][] FillLineups() {
   
      int[][] lineups = new int[4][840];
      lineup[0][0] = 0;
      lineup[1][0] = 1;
      lineup[2][0] = 2;
      lineup[3][0] = 3;
      
      for(int j = 1; j < 840; j++) {
         for(int i = 0; i < 4; i++) {
            
         
         }
      }
      
   }
}//class