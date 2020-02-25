/* Nik Barbero
   The Dice class is used to create dice objects for use in the dice game
   It creates objects with 6 integer sides numbered 1-6
   A random object is used to "roll" a die
*/

import java.util.*; //for random object

class Dice {
   
   private int side1, side2, side3, side4, side5, side6;
   
   public Dice() {
      side1 = 1;
      side2 = 2;
      side3 = 3;
      side4 = 4;
      side5 = 5;
      side6 = 6;
   }
   
   //getters for each side of a die
   public int getSide1() {
      return side1;
   }
   public int getSide2() {
      return side2;
   }
   public int getSide3() {
      return side3;
   }
   public int getSide4() {
      return side4;
   }
   public int getSide5() {
      return side5;
   }
   public int getSide6() {
      return side6;
   }
   
   //setters for each side of a die
   public void setSide1(int a) {
      side1 = a;
   }
   public void setSide2(int a) {
      side2 = a;
   }
   public void setSide3(int a) {
      side3 = a;
   }
   public void setSide4(int a) {
      side4 = a;
   }
   public void setSide5(int a) {
      side5 = a;
   }
   public void setSide6(int a) {
      side6 = a;
   }
   
   //returns a dice object as a string
   public String toString() {
      String sides = new String(side1 + ", " + side2 + ", " + side3 + ", " + side4 + ", " + side5 + ", " + side6);
      return sides;
   }
   
   //rolls a die by getting a random integer 1-6
   public int roll() {
      Random ran = new Random();
      int roll = ran.nextInt(6)+1;
      return roll;
   }
} //class