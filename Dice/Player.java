/* Nik Barbero
   The Player class is used to create player objects for use in the dice game.
   It stores a users name and score.
*/

class Player {
   
   private String name;
   private int score;
   
   //Player() takes in no parameters and creates a new player with no name or score
   public Player() {
      name = "None";
      score = 0;
   }
   
   //Player() takes in a string a creates a new player with that string as the name and 0 score
   public Player(String str) {
      name = str;
      score = 0;
   }
   
   //getter method for a players name
   public String getName() {
      return name;
   }
   
   //getter method for a players score
   public int getScore() {
      return score;
   }
   
   //setter method for a players name
   public void setName(String str) {
      name = str;
   }
   
   //setter method for a players score
   public void setScore(int a) { 
      score = a;
   }
   
   //takes in an int and adds that to the score of a player
   public void updateScore(int a) {
      score = score + a;
   }
   
   //checks to see if a player has won the game
   //returns true if the player has 300 or more points
   public boolean isWinning() {
      boolean flag;
      if(score >= 300) {
         flag = true;
      } else {
         flag = false;
      }
      return flag;
   }
   
   //returns a player object as a string by displaying their name and score
   public String toString() {
      String player = new String("Player: " + name + " Score: " + score);
      return player;
   }
}//class