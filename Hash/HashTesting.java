/*
   Program:       HashTesting.java
   Author:        Nik Barbero
   Date:          5/19/2019
   Description:   An analysis of the efficiency of different 
                  hashing methods
*/
import java.util.*;
import java.io.*;
import java.text.*;

class HashTesting {
   public static void main(String[] args) {
      
      // Sets up the file to read in from
      // Creates array to store the data that will be passed
      //    into the tables
      Scanner input = new Scanner(System.in);
      String[] names = new String[200];
      Integer[] keys = new Integer[200];
      try {
         input = new Scanner(new File("names.txt"));
      } catch(FileNotFoundException e) {
         System.out.println("Error: File not found.");
      }
      
      // Creates the tables to store the data
      // Also creates variables to track sums of collisions
      Table linearTable = new Table<Integer, String>(241);
      TableDoubleHash doubleTable = new TableDoubleHash<Integer, String>(241);
      TableChainHash chainTable = new TableChainHash<Integer, String>(241);
      double linearSum = 0;
      double doubleSum = 0;
      double chainSum = 0;
      DecimalFormat df = new DecimalFormat("0.00");
      
      // Fills the array with input from file
      for(int i = 0; i < 200; i++) {
         names[i] = input.next();
         keys[i] = input.nextInt();
      }
      
      /*
         Puts each value into each table and tracks the number of collision
         Outputs the number of collisions for each table every iteration
         Calculates and prints the average number of collisions
      */
      System.out.println("Collisions per Attempted Placement in Tables");
      System.out.println("Attempt\tLinear\tDouble\tChain");
      for(int i = 0; i < 200; i++) {
         linearTable.put(keys[i], names[i]);
         doubleTable.put(keys[i], names[i]);
         chainTable.put(keys[i], names[i]);
         
         linearSum += linearTable.getCollisions(i);
         doubleSum += doubleTable.getCollisions(i);
         chainSum += chainTable.getCollisions(i);
         
         System.out.printf("%5d%7d%9d%9d%n", (i+1), linearTable.getCollisions(i), doubleTable.getCollisions(i), chainTable.getCollisions(i));
      } 
      
      System.out.println("Linear Average = " + df.format((linearSum/200)));
      System.out.println("Double Average = " + df.format((doubleSum/200)));
      System.out.println("Chain Average = " + df.format((chainSum/200)));
   }
}