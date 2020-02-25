/* Nik Barbero
   This program is a dice game for as many players as the user desires
   The players will each enter their names before the game begins
   Each player with have up to 2 rolls on a set of 5 dice to get the highest score possible
   The first player to 300 points wins the game
   The game will end when a player reaches 300 points regardless of their place in player order
*/

import java.util.*; //for scanner

class Game {
   public static void main(String[] args) {
      
      //all objects, arrays, and variables necessary for the program
      Scanner key = new Scanner(System.in);
      key.useDelimiter(System.getProperty("line.separator"));
      Player[] players;
      Dice[] dice = new Dice[5];
      int[] rolls = new int[5];
      int choice1 = 1;
      int choice2 = 1;
      int choice3 = 1;
      int choice4 = 1;
      int sum = 0;
      boolean flag1 = true;
      boolean flag2 = false;
      boolean flag3 = true;
      boolean flag4 = true;
      boolean flag5 = true;
      
      System.out.println("Welcome to my dice game!");
      System.out.println("How many players will you have?"); //asks the users to enter the number of players
      while(flag1) {
         try{ //try block for the number of players
            choice1 = key.nextInt();
            if(choice1 < 1) {
               throw new Exception("You must have at least 1 player."); //new exception for less than 1 player
            }
            flag1 = false; //exits the loop when a correct input is entered
         } catch(InputMismatchException e) {
            System.out.println("You must enter an integer.");
            key.next(); //clears the scanner on input mismatch errors
         } catch(Exception e) {
            System.out.println(e.getMessage()); //gets the message for less than 1 player
         }
      }
      players = new Player[choice1]; //creates an array of players with the number of players the user entered
      
      System.out.print("Enter all players' names.\n"); //asks the user to enter all players' names
      for(int i = 0; i < choice1; i++) {
         System.out.print("Player " + (i+1) + ": ");
         players[i] = new Player(key.next()); //saves the users input as the name of the player
      }
      
      for(int i = 0; i < 5; i++) { //creates 5 dice objects in an array
         dice[i] = new Dice();
      }
      System.out.println("\nThe first player to 300 points wins! Good luck!"); //game-start message
      
      while(flag2 == false) { //once the players have been entered, the game enters a loop until a player reaches 300 points
         for(int i = 0; i < choice1; i++) { //this for loop dictates whose turn it is
            
            if(flag2 == false) { //makes sure this doesn't get run any extra times
               for(int j = 0; j < choice1; j++) { //this for loop checks if anyone has won at the start of every turn
                  if(players[j].isWinning()) {
                     flag2 = true; //sets the game flag to true when a player has won
                     System.out.println("Congratulations, " + players[j].getName() + ", you win with " + players[j].getScore() + " points!"); //prints when a player has won
                  } 
               }
            }
            
            if(flag2 == false) {//game ends here if anyone has more than 300 points
            
               System.out.println("\n" + players[i].getName() + ", please select an option."); 
               while(flag3) { //this loop ends after a player rolls the dice
                  System.out.println("\t1. Roll\n\t2. View Scores"); //displays a menu of options for the user to choose from
                  
                  //the menu() method takes in the number of options in the menu and a scanner
                  //it is used to test for correct inputs and returns the selected menu choice
                  choice2 = menu(2,key);
                  
                  switch(choice2) { //switch dictated by the users menu choice
                  case 1:  System.out.println("You rolled:"); //rolls 5 dice and displays the outcomes to the user
                           for(int k = 0; k < 5; k++) {
                              rolls[k] = dice[k].roll();
                              System.out.println((k+1) + ": " + rolls[k]);
                           }
                           flag3 = false;
                           break;
                  case 2:  System.out.println("The scores are:"); //displays the players names and scores, the menu will then be displayed again
                           for(int k = 0; k < choice1; k++) {
                              System.out.println(players[k].getName() + ": " + players[k].getScore());
                           }
                           break;
                  }//switch(choice2)
               }//while(flag3)
               flag3 = true; //resets the flag for the first roll
               
               System.out.println("What would you like to do next?");
               while(flag4) { //this loop ends after a player rolls again or tallies the dice
                  System.out.println("\t1. Roll Again\n\t2. Tally Dice\n\t3. View Scores"); //menu with 3 options
                  choice3 = menu(3,key); //menu() method for a try/catch block
                  
                  switch(choice3) { //switch determined by the players menu choice
                     case 1:  System.out.println("How many dice would you like to re-roll? (You will pick which dice after.)");
                              while(flag5) { 
                                 try {
                                    choice4 = key.nextInt();
                                    if(choice4 < 1 || choice4 > 5) {
                                       throw new Exception("Please enter a number 1-5."); //you must reroll at least one die and cannot roll more than 5
                                    }
                                    flag5 = false; //exits the loop when a valid input has been entered
                                 } catch(InputMismatchException e) {
                                    System.out.println("Please enter an integer.");
                                    key.next(); //clears the scanner for input mismatch errors
                                 } catch(Exception e) { 
                                    System.out.println(e.getMessage()); //gets the message for numbers less than 1 or greater than 5
                                 }
                              }
                              flag5 = true; //resets the flag for the next player
                              
                              /* the reroll() method takes in the rolls array, the number of rerolls, and the dice array
                                 it then asks the user which dice they would like to reroll and rolls them again
                                 it returns the same rolls array but with some dice rerolled 
                              */
                              rolls = reroll(rolls, choice4, dice); 
                              sum = 0; //resets the sum to 0 every loop
                              System.out.println("You rolled:");
                              for(int m = 0; m < 5; m++) {
                                 System.out.println((m+1) + ": " + rolls[m]); //displays the rolls to the user
                                 sum = sum + rolls[m]; //calculates the sum
                              }
                              System.out.println("Points from this roll: " + sum); //displays the total points from the roll
                              players[i].updateScore(sum); //adds the sum to the players' score
                              System.out.println("Total points: " + players[i].getScore()); //displays total score for that player
                              flag4 = false; //exits the loops for the second part of the players turn
                              break;
                     case 2:  sum = 0; //sets the sum to 0 every loop
                              for(int m = 0; m < 5; m++) {
                                 sum = sum + rolls[m]; //calculates the sum
                              }
                              System.out.print("Point from this roll: " + sum + "\n"); //displays the total points from the roll
                              players[i].updateScore(sum); //adds the sum to the players' score
                              System.out.println("Total points: " + players[i].getScore()); //displays total score for that player
                              flag4 = false; //exits the loops for the second part of the players turn
                              break;
                     case 3:  System.out.println("The scores are:"); //displays all players' names and scores
                              for(int m = 0; m < choice1; m++) {
                                 System.out.println(players[m].getName() + ": " + players[m].getScore());
                              }
                              break;
                  }//switch(choice3)
               }//while(flag4)
               flag4 = true; //resets the flag for the next player
               
            }
         }//first for loop
      }//while(flag2)
   
   
   
   
   } //main
   
   //the menu() method is used as a try catch block whenever a menu is displayed to the user in the program
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
   
   
   //the reroll() method allows the player to reroll a predetermined number of dice
   public static int[] reroll(int[] a, int b, Dice[] d) { //takes in an array of previous rolls, the number of rerolls, and a dice array
      int[] c = new int[b]; //new int array for the dice the user would like to rerol
      boolean flag = true;
      Scanner key = new Scanner(System.in);
      
      System.out.println("Which dice would you like to reroll?"); //asks the user to select dice to reroll
      for(int i = 0; i < b; i++) {
         try { //try/catch block for integers 1-5
            c[i] = (key.nextInt())-1; //decrements the users input by 1 to match the array index
            if(c[i] < 0 || c[i] > 4) {
               throw new Exception("Please enter a number 1-5."); //new exception for inputs less than 1 or greater than 5
            }
         } catch(InputMismatchException e) {
            System.out.println("Please enter an integer.");
            key.next(); //clears the scanner for input mismatch errors
            i--; //decrements to make the user try again on the same input
         } catch(Exception e) {
            System.out.println(e.getMessage()); //gets the message for inputs less than 1 or greater than 5
            i--; //decrements to make the user try again on the same input
         }
      }
      
      //rerolls all dice that the user selected
      for(int j = 0; j < 5; j++) {
         for(int k = 0; k < b; k++) {
            if(c[k] == j) {
               a[j] = d[k].roll();
            }
         }
      }
      return a; //returns the original array of rolls with some of the dice rerolled
   } 
} //class