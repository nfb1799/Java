/* Nik Barbero
   This program allows the user to play RPS against the computer in a loop.
   When the user is done playing, the program prints the number of games, wins, losses, and ties. 
*/
import java.util.*;

class GameNB {
   public static void main(String[] args){
      
      Scanner key = new Scanner(System.in); //introduces a Scanner object
      Random ran = new Random(); //introduces a Random object
      
      System.out.println("Let's play Rock, Paper, Scissors.\n"); //introduces the game then skips a line
      int selection = 0; //initialies the users selection
      int computer = ran.nextInt(3)+1; //assigns the computer a random number 1-3
      int win = 0; //initializes the number of wins
      int tie = 0; //initializes the number of losses 
      int loss = 0; //initializes the number of ties
      int games = 0; //initializes the number of games played
      String compChoice = new String(); //initializes a string for a future switch statement
      
      
      while(selection != 4) {
        
         switch (computer){ //this switch assigns the computer rock, paper, or scissors based on the randomly generated number 1-3
            case 1: compChoice = "rock"; //if the number is one, the computer chooses rock
                  break;
            case 2: compChoice = "paper"; //if the number is two, the computer chooses paper
                  break;
            case 3: compChoice = "scissors"; //if the number is three, the computer chooses scissors
                  break;
         }
         
         try {
            System.out.println("Press 1 for rock, 2 for paper, 3 for scissors, or 4 to quit."); //starts the game by asking the user to make a selection
            selection = key.nextInt();
            if(selection < 1 || selection > 4) { //numbers less than 1 and greater than 4 become exceptions 
               throw new Exception("\nERROR: Please enter a number 1-4."); //error message for an invalid number
            }
            computer = ran.nextInt(3)+1; //assigns the computer a new number 1-3
            games++; //adds one to the game count
         } catch(InputMismatchException e) { //catches invalid data entries
            System.out.println("\nERROR: You have entered an invalid key.");
            key.nextLine(); //clears the scanner
            selection = 0; //resets selection to 0 
         } catch(Exception e) { //catches invalid numbers
            System.out.println(e.getMessage());
         }
         
         if(selection == 1){ //prints what the user and the computer chose 
            System.out.println("You chose rock.");
            System.out.println("The computer chose " + compChoice + ".");
            if(computer == 1){ //if the computer chose rock
               System.out.println("You tied.\n");
               tie++; //adds one to the tie count
            } else if(computer == 2){ //if the computer chose paper
               System.out.println("You lose.\n");
               loss++; //adds one to the loss count
            } else { //if the computer chose scissors
               System.out.println("You win!\n");
               win++; //adds one to the win count
            }
         } else if(selection == 2){
            System.out.println("You chose paper.");
            System.out.println("The computer chose " + compChoice + ".");
            if(computer == 1){
               System.out.println("You win!\n");
               win++;
            } else if(computer == 2){
               System.out.println("You tied.\n");
               tie++;
            } else {
               System.out.println("You lose.\n");
               loss++;
            }
         } else if(selection == 3){
            System.out.println("You chose scissors.");
            System.out.println("The computer chose " + compChoice + ".");
            if(computer == 1){
               System.out.println("You lose.\n");
               loss++;
            } else if(computer == 2){
               System.out.println("You win!\n");
               win++;
            } else {
               System.out.println("You tied.\n");
               tie++;
            }
         } else if(selection == 4) {
            games--; //the game counter must be decremented when 4 is entered because no game is played but one got counted
         }
      } //closes the loop
      
      if(games == 1) //prints the number of games played using an if/else statement for proper English
         System.out.println("You played " + games + " game.");
      else
         System.out.println("You played " + games + " games.");
         
      if(win == 1) //prints the number of wins using an if/else statement for proper English
         System.out.println("You won " + win + " time.");
      else
         System.out.println("You won " + win + " times.");
      
      if(loss == 1) //prints the number of losses using an if/else statement for proper English
         System.out.println("You lost " + loss + " time.");
      else
         System.out.println("You lost " + loss + " times.");
      
      if(tie == 1) //prints the number of ties using and if/else statement for proper English
         System.out.println("You tied " + tie + " time.");
      else
         System.out.println("You tied " + tie + " times.");
         
      System.out.println("Thanks for playing!");
   } //closes the main method
} //closes the class