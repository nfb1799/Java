class Complex {
   
   private double real;
   private double imaginary;
    
   public Complex() {
      real = 0;
      imaginary = 0;
   }
    
   public Complex(double a) {
      real = a;
      imaginary = 0; 
   }
    
   public Complex(double a, double b) {
      real = a;
      imaginary = b;
   }
   
   public double getReal() {
      return real;
   }
   
   public double getImaginary(){
      return imaginary;
   }
   
   public void setReal(double a) {
      real = a;
   }
   
   public void setImaginary(double a) {
      imaginary = a;
   }
   
   public String toString() {
      String a = new String(real + " + " + imaginary + "i");
      return a;
   }
   
   public boolean equals(Complex com) {
      double a, b, c, d;
      boolean flag;
      a = com.getReal();
      b = com.getImaginary();
      c = this.getReal();
      d = this.getImaginary();
      
      if((a == c) && (b == d)) {
         flag = true;
      } else {
         flag = false;
      }
      
      return flag;
   }
   
   public Complex add(Complex com) {
      double a, b, c, d;
      a = com.getReal();
      b = com.getImaginary();
      c = this.getReal();
      d = this.getImaginary();
      
      Complex plex = new Complex((a+c),(b+d));
      return plex;
   }
   
   public Complex add(double a) {
      double b, c;
      b = this.getReal();
      c = this.getImaginary();
      
      Complex com = new Complex((b+a),c);
      return com;
   }
   
   public static Complex add(Complex com, Complex plex) {
      double a, b, c, d;
      a = com.getReal();
      b = com.getImaginary();
      c = plex.getReal();
      d = plex.getImaginary();
      
      Complex e = new Complex((a+c),(b+d));
      return e;
   }
   
   private final static double LIMIT = 10.0;
   
   public boolean isBig() {
      double size;
      boolean flag;
      size = Math.sqrt(Math.pow((this.getReal()), 2) + Math.pow((this.getImaginary()), 2));
      
      if(size > LIMIT) {
         flag = true;
      } else {
         flag = false;
      }
      
      return flag;
   }
    
} //class