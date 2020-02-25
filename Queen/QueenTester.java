class QueenTester {
   public static void main(String[] args) {
      Queen q = new Queen(1,1);
      Queen p = new Queen(2,2);
      Queen c = new Queen(3,1);
      
      if(q.conflict(c))
         System.out.print("conflict");
      else
         System.out.print("no");
         
      System.out.println(q.toString());
      
      System.out.println("|_|_|Q|_|");
      System.out.println("|Q|_|_|_|");
      System.out.println("|_|_|_|Q|");
      System.out.println("|_|Q|_|_|");
   }
}