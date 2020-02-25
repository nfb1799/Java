import java.text.*;

class ArrayLab {
   public static void main(String[] args) {
      
      DecimalFormat df = new DecimalFormat("0.00");
      double sum = 0;
      double[] array = new double[6];
      array[0] = 1.41;
      array[1] = 2.52;
      array[2] = 3.63;
      array[3] = 4.74;
      array[4] = 5.85;
      array[5] = 6.96;
      
      System.out.println("The values in your array are:");
      
      for(int i = 0; i < array.length; i++) {
         if(i != (array.length - 1)){
            System.out.print(array[i] + ", "); 
         } else {
            System.out.println(array[i]); 
         }
         sum = sum + array[i];
      }
      
      System.out.println("The sum of these values is: " + sum);
      System.out.println("The square root of " + sum + " is: " + df.format(Math.sqrt(sum)));
      
   }
}