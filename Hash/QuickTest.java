class QuickTest {
   public static void main(String[] args) {
      TableChainHash table = new TableChainHash<Integer, String>(7);
      table.put(123, "Hello");
      table.put(435, "Hey");
      table.put(34234, "Hi");
      table.put(442, "Yo");
      
      System.out.println(table.remove(442));
   }
}