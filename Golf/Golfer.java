import java.text.*;
class Golfer implements Comparable
{

   // Invariant of the Golfer class:
   //    1. The data members store information about the stats of a golfer 
   //    2. Handicap must be a value between 0-20
   private String lastname;
   private int numberOfRounds;
   private int handicap;
   private double averageScore;
   
   /**
   * An empty constructor
   * @postcondition
   *  A new Golfer object has been created with null values
   **/
   public Golfer() 
   {
      lastname = "none";
      numberOfRounds = 0;
      handicap = 0;
      averageScore = 0;
   } 
   
   /**
   * A constructor that takes a last name as a parameter
   * @param - str
   *  The golfers' last name
   * @postcondition
   *  A new Golfer object has been created with just a last name
   **/
   public Golfer(String str)
   {
      lastname = str;
      numberOfRounds = 0;
      handicap = 0;
      averageScore = 0;
   }
   
   /**
   * A constructor that takes all data members as parameters
   * @param - str
   *  The golfers' last name
   * @param - num
   *  The golfers' number of rounds
   * @param - handi
   *  The golfers' handicap
   * @param - avg
   *  The golfers' average score
   * @postcondition
   *  A new Golfer object has been created
   **/
   public Golfer(String str, int num, int handi, double avg)
   {
      lastname = str;
      numberOfRounds = num;
      handicap = handi;
      averageScore = avg;
   }
   
   /**
   * Accessor method for the Golfers' last name
   * @return
   *  The golfers' last name
   **/
   public String getName()
   {
      return lastname;
   }
   
   /**
   * Accessor method for the Golfers' number of rounds
   * @return
   *  The golfers' number of rounds
   **/
   public int getRounds()
   {
      return numberOfRounds;
   }
   
   /**
   * Accessor method for the Golfers' average score
   * @return
   *  The golfers' average score
   **/
   public double getAverage()
   {
      return averageScore;
   }
   
   /**
   * Accessor method for the Golfers' handicap
   * @return
   *  The golfers' handicap
   **/
   public int getHandicap()
   {
      return handicap;
   }
   
   /**
   * Mutator method for the Golfers' last name
   * @param - str
   *  The new name of the golfer
   * @postconditon
   *  The golfers' name has been updated
   **/
   public void setName(String str)
   {
      lastname = str;
   }
   
   /**
   * Mutator method for the Golfers' number of rounds
   * @param - num
   *  The new number of rounds
   * @postcondition
   *  The golfers' number of rounds has been updated
   **/
   public void setRounds(int num) 
   {
      numberOfRounds = num;
   }
   
   /**
   * Mutator method for the Golfers' average score
   * @param - avg
   *  The new average score
   * @postcondition
   *  The golfers' average score has been updated
   **/
   public void setAverage(double avg)
   {
      averageScore = avg;
   }
   
   /**
   * Mutator method for the Golfers' handicap
   * @param - handi
   *  The new handicap
   * @postcondition
   *  The golfers' handicap has been updated
   **/
   public void setHandicap(int handi)
   {
      handicap = handi;
   }
   
   /**
   * Adds a score to the golfers stats
   * @param - score
   *  The score to be added
   * @postcondition
   *  The score has been added and averageScore and
   *  numberOfRounds have been updated
   **/
   public void addScore(int score) 
   {
      averageScore = averageScore * numberOfRounds;
      averageScore += score;
      numberOfRounds++;
      averageScore /= numberOfRounds;
   }
   
   /**
   * Compares two Golfer objects by last name
   * @param - obj
   *  The object being compared to
   * @return 
   *  0 if the objects are the same, 1 if the passed in object
   *  is greater than this, -1 if the passed in object is less 
   *  than this
   **/
   public int compareTo(Object obj)
   {
      Golfer golf = new Golfer();
      String thisName = this.lastname;
      String golfName;
      
      if(obj instanceof Golfer)
         golf = (Golfer) obj;
         
      golfName = golf.getName();
         
      if(golfName.compareToIgnoreCase(thisName) == 0)
         return 0;
      else
         return (golfName.compareToIgnoreCase(thisName) > 0) ? 1 : -1;
   }
   
   /**
   * Creates a string with a Golfers' information
   * @return
   *  A string displaying all of the Golfers' information
   **/
   public String toString()
   {
      DecimalFormat df = new DecimalFormat("0.00");
      String str = "Name: " + lastname + ", Number of Rounds: " + numberOfRounds + ", Handicap " + handicap + ", Average Score: " + df.format(averageScore); 
      return str;
   }

}