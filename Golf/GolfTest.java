import java.util.*;
class GolfTest {
   public static void main(String[] args) {
      Golfer a1 = new Golfer("Stevens", 7, 8, 78.45);
      Golfer a2 = new Golfer("Walker", 5, 14, 84.88);
      Golfer a3 = new Golfer("Smith", 2, 9, 81.50);
      Golfer a4 = new Golfer("Jones", 8, 4, 76.90);
      Golfer a5 = new Golfer("Addison", 6, 18, 89.55);
      Golfer a6 = new Golfer("Norman", 12, 3, 76.40);
      Golfer a7 = new Golfer("Woods", 10, 6, 80.75);
      Golfer a8 = new Golfer("Palmer", 7, 7, 77.77);
      Golfer a9 = new Golfer("Nickels", 1, 13, 84.00);
      Golfer a10 = new Golfer("Rubble", 5, 17, 91.25);
      Golfer a11 = new Golfer("Flintstone", 5, 15, 89.85);
      Golfer a12 = new Golfer("Franks", 8, 10, 79.35);
      
      
      TreeBag<Golfer> testTree = new TreeBag<Golfer>();
      testTree.add(a1);
      testTree.add(a2);
      testTree.add(a3);
      testTree.add(a4);
      testTree.add(a5);
      testTree.add(a6);
      testTree.add(a7);
      testTree.add(a8);
      testTree.add(a9);
      testTree.add(a10);
      testTree.add(a11);
      testTree.add(a12);
      
      testTree.display();
      System.out.println("\n");
      testTree.remove(a7);
      testTree.remove(a11);
      testTree.remove(a1);
      testTree.displayAsTree();
      
   
   }
}