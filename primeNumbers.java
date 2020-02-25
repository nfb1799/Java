class primeNumbers {
   public static void main(String args[]) {
   
      boolean prime = true;
      
      for(int i = 2; i < 1000000; i++) {
         prime = true;
         for(int j = 2; j < i && prime; j++) {
            if(i%j == 0)
               prime = false;
         }
         if(prime) 
            System.out.println(i); 
      }
   
   
   }
}