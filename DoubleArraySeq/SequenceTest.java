/*
   Program:       SequenceTest.java
   Authors:       Nik Barbero, Traylin Drake
   Date:          3/4/2019
   Description:   A program to test the DoubleArraySeq class.
                  Manipulates DoubleArraySeq objects using the available methods.
*/
import java.util.*;

class SequenceTest {
   public static void main(String[] args) {
   
   /* Initializes the necessary variables for the program.
   *  DoubleArraySeq sequenceC is used for the concatenation method.
   *  boolean flag[null-8] are control variables that contain try/catch blocks.
   *  int choice[null-3], setCurrent, getElement are used to track user inputs.
   *  All double variables are used to track user inputs. 
   */
   DoubleArraySeq sequenceA = new DoubleArraySeq();
   DoubleArraySeq sequenceB = new DoubleArraySeq(5);
   DoubleArraySeq sequenceC = new DoubleArraySeq();
   Scanner key = new Scanner(System.in);
   boolean flag = true;
   boolean flag2 = true;
   boolean flag3 = true;
   boolean flag4 = true;
   boolean flag5 = true;
   boolean flag6 = true;
   boolean flag7 = true;
   boolean flag8 = true;
   int choice = 0;
   int choice2 = 0;
   int choice3 = 0;
   int setCurrent = 0;
   int getElement = 0;
   double addFront = 0.0;
   double addBefore = 0.0;
   double addAfter = 0.0;
   double addEnd = 0.0;
   String activeSequence = "A";
   
   //The program is ran in a loop that exits when the user selects option 16
   while(flag) {
      System.out.println("\n\t1.\t\tPrint the sequenences of A and B\n"
                        +"\t2.\t\tReport the capacity of A and B\n"
                        +"\t3.\t\tReport if A and B are equal\n"
                        +"\t4.\t\tChange active sequence\n"
                        +"\t5.\t\tAdd a number to the front of a sequence\n"
                        +"\t6.\t\tSet the current element location\n"
                        +"\t7.\t\tAdd a number before the current element\n"
                        +"\t8.\t\tAdd a number after the current element\n"
                        +"\t9.\t\tAdd a number to the end of a sequence\n"
                        +"\t10.\tAdd sequence B to the end of A\n"
                        +"\t11.\tDelete a number at a certain index\n"
                        +"\t12.\tDelete the first number from the sequence\n"
                        +"\t13.\tDisplay a number at a certain index\n"
                        +"\t14.\tDisplay the last element in the sequence\n"
                        +"\t15.\tCreate a new sequence using concatenate of B and A and show\n"
                        +"\t16.\tQuit\n"
                        +"Active Sequence: " + activeSequence);
      
      choice = menu(16, key);
      switch(choice) {
      
         //Print the sequences of A and B (uses toString( ))
         case 1:  System.out.println("Sequence A:\t" + sequenceA.toString());
                  System.out.println("Sequence B:\t" + sequenceB.toString());
                  break;
                  
         //Report the capacity of A and B (uses getCapacity( ))
         case 2:  System.out.println("Capacity of A:\t" + sequenceA.getCapacity());
                  System.out.println("Capacity of B:\t" + sequenceB.getCapacity());
                  break;
                  
         //Report if A and B are equal (uses equals( ) )
         case 3:  if(sequenceA.equals(sequenceB))
                     System.out.println("A and B are equal.");
                  else
                     System.out.println("A and B are not equal.");
                  break;
                  
         //Change active sequence (default is A)
         case 4:  if(activeSequence.equals("A")) {
                     activeSequence = "B";
                     System.out.println("Active sequence has been set to " + activeSequence + ".");
                  } else {
                     activeSequence = "A";
                     System.out.println("Active sequence has been set to " + activeSequence + ".");
                  }
                  break;
                  
         //Add a number to the front of a sequence (uses addFront())
         case 5:  System.out.println("Which sequence would you like to add to?\n"
                                       +"\t1.\tSequence A\n"
                                       +"\t2.\tSequence B");
                                       
                  choice2 = menu(2, key);
                  if(choice2 == 1) {
                     System.out.println("Enter the number you would like to add.");
                     while(flag2) {
                        try {
                           addFront = key.nextDouble();
                           flag2 = false;
                        } catch(InputMismatchException e) {
                           System.out.println("Please enter a double.");
                           key.next();
                        }
                     }
                     sequenceA.addFront(addFront);
                     flag2 = true;
                  } else {
                     System.out.println("Enter the number you would like to add.");
                     while(flag2) {
                        try {
                           addFront = key.nextDouble();
                           flag2 = false;
                        } catch(InputMismatchException e) {
                           System.out.println("Please enter a double.");
                           key.next();
                        }
                     }
                     sequenceB.addFront(addFront);
                     flag2 = true;
                  }
                  break;
                  
         //Set the current element location (uses setCurrent())
         case 6:  System.out.println("Enter the index location.");
                  while(flag3) {  
                     try {
                        setCurrent = key.nextInt();
                        
                        if(setCurrent < 0)
                           throw new Exception("Please enter a positive integer.");
                           
                        flag3 = false;
                     } catch(InputMismatchException e) {
                        System.out.println("Please enter an integer.");
                        key.next();
                     } catch(Exception e) {
                        System.out.println(e.getMessage());
                     }
                  }
                  
                  //Checks the active sequence and updates accordingly
                  try {
                     if(activeSequence.equals("A")) {
                        sequenceA.setCurrent(setCurrent);
                        System.out.println("Current element set to " + setCurrent + ".");
                     } else {
                        sequenceB.setCurrent(setCurrent);
                        System.out.println("Current element set to " + setCurrent + ".");
                     }
                  } catch(IllegalStateException e) {
                     System.out.println("Error: There is no current element.");
                  }   
                  
                  flag3 = true; 
                  break;
                  
         //Add a number before the current element (uses addBefore())
         case 7:  System.out.println("Enter the number you would like to add.");
                  while(flag4) {
                     try {
                        addBefore = key.nextDouble();
                        flag4 = false;
                     } catch(InputMismatchException e) {
                        System.out.println("Please enter a double.");
                        key.next();
                     }
                  }
                  
                  //Checks the active sequence and updates accordingly
                  if(activeSequence.equals("A"))
                     sequenceA.addBefore(addBefore);
                  else
                     sequenceB.addBefore(addBefore);
                     
                  flag4 = true;
                  break;
                  
         //Add a number after the current element (uses addAfter())
         case 8:  System.out.println("Enter the number you would like to add.");
                  while(flag5) {
                     try {
                        addAfter = key.nextDouble();
                        flag5 = false;
                     } catch(InputMismatchException e) {
                        System.out.println("Please enter a double.");
                        key.next();
                     }
                  }
                  
                  //Checks the active sequence and updates accordingly
                  if(activeSequence.equals("A"))
                     sequenceA.addAfter(addAfter);
                  else
                     sequenceB.addAfter(addAfter);
                     
                  flag5 = true;
                  break;
                  
         //Add a number to the end of a sequence (uses addEnd())
         case 9:  System.out.println("Which sequence would you like to add to?\n"
                                       +"\t1.\tSequence A\n"
                                       +"\t2.\tSequence B");
                                       
                  choice3 = menu(2, key);
                  if(choice3 == 1) {
                     System.out.println("Enter the number you would like to add.");
                     while(flag6) {
                        try {
                           addEnd = key.nextDouble();
                           flag6 = false;
                        } catch(InputMismatchException e) {
                           System.out.println("Please enter a double.");
                           key.next();
                        }
                     }
                     sequenceA.addEnd(addEnd);
                     flag6 = true;
                  } else {
                     System.out.println("Enter the number you would like to add.");
                     while(flag6) {
                        try {
                           addEnd = key.nextDouble();
                           flag6 = false;
                        } catch(InputMismatchException e) {
                           System.out.println("Please enter a double.");
                           key.next();
                        }
                     }
                     sequenceB.addEnd(addEnd);
                     flag6 = true;
                  }
                  break;
                  
         //Add sequence B to end of A (uses addAll())
         case 10: sequenceA.addAll(sequenceB);
                  System.out.println("Sequence B has been added to the end of A.");
                  break;
                  
         //Delete a number at a certain index (uses setCurrent() and removeCurrent())
         case 11: System.out.println("Enter the index location.");
                  while(flag7) {  
                     try {
                        setCurrent = key.nextInt();
                        
                        if(setCurrent < 0)
                           throw new Exception("Please enter a positive integer.");
                           
                        flag7 = false;
                     } catch(InputMismatchException e) {
                        System.out.println("Please enter an integer.");
                        key.next();
                     } catch(Exception e) {
                        System.out.println(e.getMessage());
                     }
                  }
                  
                  //Checks the active sequence and updates accordingly
                  try{
                     if(activeSequence.equals("A")) {
                        sequenceA.setCurrent(setCurrent);
                        sequenceA.removeCurrent();
                     } else {
                        sequenceB.setCurrent(setCurrent);
                        sequenceB.removeCurrent();
                     } 
                  } catch(IllegalStateException e) {
                     System.out.println("Error: There is no current element.");
                  }
                 
                  flag7 = true; 
                  break;
                  
         //Delete the first number from the sequence (uses removeFront())
         case 12: if(activeSequence.equals("A")) //Checks the active sequence and updates accordingly
                     sequenceA.removeFront();
                  else
                     sequenceB.removeFront();
                  
                  System.out.println("First element of Sequence " + activeSequence + " has been removed.");
                  break;
                  
         //Display a number at a certain index (uses getElement())
         case 13: System.out.println("Enter an index location.");
                  while(flag8) {  
                     try {
                        getElement = key.nextInt();
                        
                        if(getElement < 0)
                           throw new Exception("Please enter a positive integer.");
                           
                        flag8 = false;
                     } catch(InputMismatchException e) {
                        System.out.println("Please enter an integer.");
                        key.next();
                     } catch(Exception e) {
                        System.out.println(e.getMessage());
                     }
                  }
                  
                  //Checks the active sequence and updates accordingly
                  try {
                     if(activeSequence.equals("A"))
                        System.out.println("Number at index " + getElement + " " + sequenceA.getElement(getElement));
                     else
                        System.out.println("Number at index " + getElement + " " + sequenceB.getElement(getElement));
                  } catch(IllegalStateException e) {
                     System.out.println("Error: There is no current element.");
                  }    
                  flag8 = true;
                  break;
                  
         //Display the last element in the sequence(setCurrentLast() and getCurrent())
         case 14: try {
                     if(activeSequence.equals("A")) { //Checks the active sequence and updates accordingly
                        sequenceA.setCurrentLast();
                        System.out.println("Last element: " + sequenceA.getCurrent());
                     } else {
                        sequenceB.setCurrentLast();
                        System.out.println("Last element: " + sequenceB.getCurrent());
                     }
                  } catch(IllegalStateException e) {
                     System.out.println("Error: There is no current element.");
                  }
                  break;
                  
         //Create a new sequence using concatenate of B and A and show
         case 15: try { 
                     sequenceC = DoubleArraySeq.concatenation(sequenceA, sequenceB);
                     System.out.println("Concatenation of A and B:\n" + sequenceC.toString());
                  } catch(IllegalStateException e) {
                     System.out.println("Error: One or both sequences are empty.");
                  }
                  break;
                  
         //Quit
         case 16: flag = false;
                  break;
      }//switch(choice)
   }//while(flag)
   
   
   }//main
   
   //the menu() method is used as a try/catch block whenever a menu is displayed to the user in the program
   public static int menu(int a, Scanner key) { //requires the size of the menu and a scanner object
      boolean flag = true;
      int choice = -1;
      while(flag) { //keeps it in a loop to exit when a valid input is entered
         try {
            choice = key.nextInt(); //the user has been asked to enter which menu option they would like to choose
            if(choice < 1 || choice > a) {
               throw new Exception("Please select a valid menu option."); //new exception for inputs less than 1 and greater than the size of the menu
            }
            flag = false; //exits the loop when a valid input is entered
         } catch(InputMismatchException e) {
            System.out.println("Please enter an integer."); 
            key.next(); //clears the scanner for input mismatch errors
         } catch(Exception e) {
            System.out.println(e.getMessage()); //gets the message for inputs outside the range of menu options
         }
      }
      return choice; //returns the users valid input
   }//menu
} //class