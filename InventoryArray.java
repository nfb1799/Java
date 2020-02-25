import java.text.*;

class InventoryArray {
   public static void main(String[] args) {
      
      Inventory[] products = new Inventory[5];
      DecimalFormat df = new DecimalFormat("0.00");
      
      products[0] = new Inventory("Chocolate Bars", 200, 1.00);
      products[1] = new Inventory("Gobstoppers", 350, 1.50);
      products[2] = new Inventory("Gummy Bears", 125, 1.99);
      products[3] = new Inventory("Lollipops", .50);
      products[4] = new Inventory("Kinder Egg", 4.99);
      
      products[0].setPrice(1.25);
      products[3].setQuantity(425);
      products[4].setQuantity(75);
      products[2].setDescription("Gummy Worms");
      
      for(int i = 0; i < 5; i++) {
         System.out.println("We have " + products[i].getQuantity() + " " + products[i].getDescription() + " at a price of $" + df.format(products[i].getPrice()) + " each.");
      }
   }
}