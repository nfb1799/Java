/*
   Program:       GolferScoresTree.java
   Author:        Nik Barbero
   Date:          5/5/2019
   Description:   Saves and manipulates golfer information with a binary search tree
*/

import java.util.*;
import java.io.*;

class GolferScoresTree {
   public static void main(String[] args) {
      
      /* Initializes variables necessary for File I/O
         key is a keyboard scanner
         input scans the text file for golfer information
         printer saves the current golfers' information when creating the output file
      */
      Scanner key = new Scanner(System.in);
      Scanner input = key;
      String textFile = "";
      File inFile;
      PrintWriter outFile;
      Golfer printer;
      boolean flag = true;
      
      /* Initializes variables necessary for the tree
         The data members are used multiple times each
         Any time a new golfer is added, the same variables get recycled
      */
      TreeBag<Golfer> golfTree = new TreeBag<Golfer>();
      String lastname = "";
      int numberOfRounds = 0;
      int handicap = 0;
      double averageScore = 0.0;
      
      /* Initializes variables necessary for the menu/switch
         choice is the users menu selection
         The flags control loops for data input
      */
      int choice = -1;
      boolean flag2 = true;
      boolean flag3 = true;
      String findName;
      int addScore = 0;
      
      //Introduces the program and asks the user for an input file
      System.out.println("Welcome to the Golfer Scores Tree!\n");
      do {
         System.out.println("Please enter the name of the input file to begin.");
         try {
            textFile = key.next();
            inFile = new File(textFile);
            input = new Scanner(inFile);
            flag = false;
         } catch(FileNotFoundException e) {
            System.out.println("Error: File cannot be found.");
         }
      } while(flag);
      
      //Scans the input file and saves golfer info to the tree
      while(input.hasNext()) {
         lastname = input.next();
         numberOfRounds = input.nextInt();
         handicap = input.nextInt();
         averageScore = input.nextDouble();
         golfTree.add(new Golfer(lastname, numberOfRounds, handicap, averageScore));
      }
      
      //While loop containing the menu
      while(flag2) {
         System.out.println("\t1.\tDisplay listing to screen of all golfers' stats\n"
                           +"\t2.\tDisplay the golfers in current tree format\n"
                           +"\t3.\tFind and display on individual golfers' stats\n"
                           +"\t4.\tUpdate an individual golfers stats(Add a score)\n"
                           +"\t5.\tRemove a golfer from the Database\n"
                           +"\t6.\tAdd a new golfer to the Database\n"
                           +"\t7.\tQuit and update datafile\n");
                           
         choice = menu(7, key);
         
         switch(choice) {
            //Display listing to screen of all golfers' stats
            case 1:  golfTree.display();
                     System.out.println();
                     break;
            
            //Display the golfers in current tree format         
            case 2:  golfTree.displayAsTree();
                     System.out.println();
                     break;
            
            //Find and display on individual golfers' stats         
            case 3:  System.out.println("Enter the golfers' name.");
                     findName = key.next();
                     if(golfTree.retrieve(new Golfer(findName)) != null)
                        System.out.println(golfTree.retrieve(new Golfer(findName)).toString());
                     else
                        System.out.println("Golfer could not be found.");
                     
                     System.out.println();
                     break;
                     
            //Update an individual golfers' stats(Add a score)         
            case 4:  System.out.println("Enter the golfers' name.");
                     findName = key.next();
                     if(golfTree.retrieve(new Golfer(findName)) != null) {
                        while(flag3) {
                           System.out.println("Enter the new score.");
                           try {
                              addScore = key.nextInt();
                              if(addScore < 1) 
                                 throw new Exception("Score must be at least 1 stroke.");
                              flag3 = false;
                           } catch(InputMismatchException e) {
                              System.out.println("Error: Please enter a positive integer.");
                              key.next();
                           } catch(Exception e) {
                              System.out.println(e.getMessage());
                           }
                        } 
                        flag3 = true;
                        golfTree.retrieve(new Golfer(findName)).addScore(addScore);
                     } else {
                        System.out.println("Golfer could not be found.");
                     }
                     System.out.println();
                     break;
            
            //Remove golfer from the Database         
            case 5:  System.out.println("Enter the golfers' name");
                     findName = key.next();
                     if(golfTree.retrieve(new Golfer(findName)) != null) {
                        golfTree.remove(new Golfer(findName));
                        System.out.println("Golfer removed.");   
                     } else {
                        System.out.println("Golfer could not be found.");
                     }
                     System.out.println();
                     break;
                     
            //Add a new golfer to the Database         
            case 6:  System.out.println("Enter the golfers' name.");
                     lastname = key.next();
                     while(flag3) {
                        System.out.println("Enter the number of rounds.");
                        try {
                           numberOfRounds = key.nextInt();
                           if(numberOfRounds < 0) 
                              throw new Exception("Number of rounds cannot be negative.");
                           flag3 = false;
                        } catch(InputMismatchException e) {
                           System.out.println("Error: Please enter a positive integer.");
                           key.next();
                        } catch(Exception e) {
                           System.out.println(e.getMessage());
                        }
                     }
                     flag3 = true;
                     while(flag3) {
                        System.out.println("Enter the handicap");
                        try {
                           handicap = key.nextInt();
                           if(handicap < 0 || handicap > 20) 
                              throw new Exception("Handicap must be in the range of 0-20");
                           flag3 = false;
                        } catch(InputMismatchException e) {
                           System.out.println("Error: Please enter a positive integer.");
                           key.next();
                        } catch(Exception e) {
                           System.out.println(e.getMessage());
                        }
                     }
                     flag3 = true;
                     while(flag3) {
                        System.out.println("Enter the average score");
                        try {
                           averageScore = key.nextDouble();
                           if(averageScore < 0) 
                              throw new Exception("Average score must be at least 0.");
                           flag3 = false;
                        } catch(InputMismatchException e) {
                           System.out.println("Error: Please enter a positive number.");
                           key.next();
                        } catch(Exception e) {
                           System.out.println(e.getMessage());
                        }
                     }
                     flag3 = true;
                     golfTree.add(new Golfer(lastname, numberOfRounds, handicap, averageScore));
                     System.out.println("Golfer added.");
                     System.out.println();
                     break;
                     
            //Quit and update datafile         
            case 7:  flag2 = false;
                     int size = golfTree.size();
                     try {
                        outFile = new PrintWriter(textFile);
                        printer = golfTree.extractLeaf();
                        for(int i = 0; i < size; i++) {
                           if(printer != null) {
                              lastname = printer.getName();
                              numberOfRounds = printer.getRounds();
                              handicap = printer.getHandicap();
                              averageScore = printer.getAverage();
                              outFile.println(lastname + " " + numberOfRounds + " " + handicap + " " + averageScore);
                           }
                           printer = golfTree.extractLeaf();
                        }
                        outFile.close();
                     } catch(Exception e) {
                        System.out.println("An error occurred.");
                     }
                     break;
         }
      }
   }
   
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
   
}