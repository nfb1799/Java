class Inventory {

   private String description;
   private int quantity;
   private double price;
   
   public void Inventory() {
      description = "Empty";
      quantity = -1;
      price = 0.0;
      
   }
   
   public Inventory(String str, double a) {
      description = str;
      quantity = 0;
      price = a;
   }
   
   public Inventory(String str, int a, double b) {
      description = str;
      quantity = a;
      price = b;
   }
   
   public void setDescription(String str) {
      description = str;
   }
   
   public String getDescription() {
      return description;
   }
   
   public void setQuantity(int a) {
      quantity = a;
   }
   
   public int getQuantity() {
      return quantity;
   }
   
   public void setPrice(double a){
      price = a;
   }
   
   public double getPrice() {
      return price;
   }
}