class ArrayContinued {
   public static void main(String[] args) {
      
      int[][] aTable = new int[10][];
      int k = 0;
      int x = 10;
      
      for(int i = 0; i < 10; i++) {
         aTable[i] = new int[x];
         x--;
      }
      
      for(int j = 0; j < 10; j++) {
         for(int m = 0; m < aTable[j].length; m++) {
            aTable[j][m] = 20 + (5*k);
            System.out.print(aTable[j][m] + "\t\t");
         }
         System.out.println();
         k++;
      }
         
      
   }
}