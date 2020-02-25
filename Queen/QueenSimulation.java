/*
   Program:       QueenSimulation.java
   Author:        Nik Barbero
   Date:          4/12/2019
   Description:   A program to solve the problem of N-Queens.
                  The program finds all possible solutions to the problem.
*/
import java.util.*;

class QueenSimulation {
   public static void main(String[] args) {
      
      /*
      *  Initializes necessary variables for the progam
      *  copy is used to print the solution without altering 
      *    the main stack
      */
      Scanner key = new Scanner(System.in);
      int boardSize = 0;
      int ansCount = 1;
      int printMethod = 1;
      boolean flag = true;
      LinkedStack<Queen> answer = null;
      LinkedStack<Queen> copy = null;
      
      System.out.println("Welcome to the N-Queens Problem Solver.");
      System.out.println("Enter the board size (one number): ");
      
      // This loop ensures that the user will enter a positive integer
      while(flag) {
         try {
            boardSize = key.nextInt();
            if(boardSize < 1) {
               throw new Exception("Please enter a positive integer.");
            }
            flag = false;
         } catch(InputMismatchException e) {
            System.out.println("The board is a square.\nPlease enter one number.");
            key.next();
         } catch(Exception e) {
            System.out.println(e.getMessage());
         }
      }
      
      
      if(boardSize == 2 || boardSize == 3) { // Board sizes 2 and 3 contain no possible solutions
         System.out.println("No solutions");
      } else {
         answer = solution(boardSize);
         System.out.println("Please select a print method:\n1.\ttoString()\n2.\ttoBoard()");
         printMethod = menu(2,key); //asks the user what print method they would like to see
         
         switch(printMethod) {
            case 1:  copy = answer.clone(); 
                     System.out.println("-----Solution " + ansCount + "-----");
                     
                     // Pops each queen from the copy and prints it
                     for(int i = 0; i < boardSize; i++) {
                        System.out.println((copy.pop()).toString());
                     } 
                     break;
                     
            case 2:  System.out.println("-----Solution " + ansCount + "-----");
                     toBoard(answer); 
                     break;
         } 
      }
      
      if(boardSize > 3) { // Board size 1 only has 1 solution and sizes 2 and 3 have been filtered out
         switch(printMethod) {
            case 1:  answer = solveFurther(answer, boardSize);
                     copy = answer.clone();
                     ansCount++;
         
                     while(answer != null) {
                        System.out.println("-----Solution " + ansCount + "-----");
            
                        // Pops each queen from the copy and prints it
                        for(int i = 0; i < boardSize; i++) {
                           System.out.println((copy.pop()).toString());
                        }
                        answer = solveFurther(answer, boardSize);
                        
                        // Cloning doesn't occur if there was no answer
                        if(answer != null)
                           copy = answer.clone();
                        ansCount++;
                     }
                     break;
                     
            case 2:  answer = solveFurther(answer, boardSize);
                     ansCount++;
                     while(answer != null) {
                        System.out.println("\n-----Solution " + ansCount + "-----");
                        toBoard(answer);
                        answer = solveFurther(answer, boardSize);
                        ansCount++;  
                     }
                     break;
         }
      }
       
   }//main
   
   // Finds the first solution to the problem
   public static LinkedStack<Queen> solution(int size) {
      
      /*
      *  Initializes necessary variables for the method
      *  answer will be the return
      *  queens holds the queens in an array before pushing them
      *     on the stack
      *  solution tracks if a queen can be placed in a certain
      *     position
      */
      LinkedStack<Queen> answer = new LinkedStack();
      Queen[] queens = new Queen[size];
      int currentQ = 1;
      boolean solution = false;
      
      // Places the first queen and fills the array with void values
      // When comparing for conflict, the conflict() method will
      //    return false on negative values
      queens[0] = new Queen(1,1);
      for(int x = 1; x < size; x++) {
         queens[x] = new Queen(0,-1);
      }
      answer.push(queens[0]);
      
      while(answer.size() < size) { //exits when all queens are placed
         for(int j = 2; j <= size; j++) { //cycles columns
            for(int i = queens[currentQ].getRow() + 1; i <= size && !solution; i++) { //cycles rows of the board, exits at a solution
               solution = isValid(queens, currentQ, i, j);
               
               // If a solution is found it is pushed on the stack
               if(solution) {
                  queens[currentQ] = new Queen(i,j); 
                  answer.push(queens[currentQ]);
                  currentQ++; 
               }
            }
            
            // If no solution is found the previous queen is popped off the stack
            if(!solution) { //backtrack
               queens[currentQ] = new Queen(0,-1);
               currentQ--;
               answer.pop();
               j--;
                  
               for(int k = queens[currentQ].getRow() + 1; k <= size && !solution; k++) {
                  solution = isValid(queens, currentQ, k, j);
                  
                  // If a solution is found it is pushed on the stack   
                  if(solution) {
                     queens[currentQ] = new Queen(k,j); 
                     answer.push(queens[currentQ]);
                     currentQ++;
                  } 
               }
               
               // If no solution is found the previous queen is popped off the stack
               if(!solution) { 
                  queens[currentQ] = new Queen(0,-1);
                  currentQ--;
                  answer.pop();
                  j-=2; 
               }                  
            } // end backtrack
            solution = false;
         }
      }
      return answer;      
   }
   
   public static LinkedStack<Queen> solveFurther(LinkedStack<Queen> answer, int size) {
      Queen[] queens = new Queen[size];
      int currentQ = size - 1;
      boolean solution = false;
      
      // Fills the array by popping values from a copy of answer
      LinkedStack<Queen> copy = answer.clone();
      for(int x = (size - 1); x >= 0; x--) {
         queens[x] = copy.pop();
      }
      
      answer.pop(); //pops the top queen to enter the while loop
      while(answer.size() < size) { //exits when all quens are placed
         for(int j = size; j <= size; j++) { //cycles columns
            for(int i = queens[currentQ].getRow() + 1; i <= size && !solution; i++) { //cycles rows of the board, exits at a solution
               solution = isValid(queens, currentQ, i, j);
               
               // If a solution is found it is pushed on the stack
               if(solution) {
                  queens[currentQ] = new Queen(i,j); 
                  answer.push(queens[currentQ]);
                  currentQ++; 
               }
            }
            
            // If no solution is found the previous queen is popped off the stack
            if(!solution) { //backtrack
               queens[currentQ] = new Queen(0,-1);
               currentQ--;
               if(finalPop(answer.peek(),size))
                  return null;
               answer.pop();
               j--;
                  
               for(int k = queens[currentQ].getRow() + 1; k <= size && !solution; k++) {
                  solution = isValid(queens, currentQ, k, j);
                   
                  // If a solution is found it is pushed on the stack   
                  if(solution) {
                     queens[currentQ] = new Queen(k,j); 
                     answer.push(queens[currentQ]);
                     currentQ++;
                  } 
               }
               
               // If no solution is found the previous queen is popped off the stack
               if(!solution) { 
                  queens[currentQ] = new Queen(0,-1);
                  currentQ--;
                  if(finalPop(answer.peek(),size))
                     return null;
                  answer.pop();
                  j-=2; 
               }                  
            } // end backtrack
            solution = false;
         }
      }
      return answer;
   }
   
   public static boolean isValid(Queen[] q, int size, int row, int col) {
      boolean ans = true;
      
      for(int i = 0; i < size && ans == true; i++) { //checks the incoming queen with all previous 
         if(q[i].conflict(new Queen(row,col)))
            ans = false;
      }
      
      return ans;
   }
   
   // Returns true if q is a queen on column 1 and the final row
   public static boolean finalPop(Queen q, int size) {
      if(q.getRow() == size && q.getColumn() == 1) 
         return true;
      else
         return false;
   }
   
   // Takes a linked stack of Queens and prints a board to represent their positions
   public static void toBoard(LinkedStack<Queen> a) {
      int size = a.size();
      LinkedStack<Queen> q = a.clone(); //parameter is cloned as to not mess with the data
      Queen[] qArray = new Queen[size];
      boolean p = false;
      for(int x = (size - 1); x >= 0; x--) {
         qArray[x] = q.pop();
         System.out.print(" _");
      }
      System.out.println();
      
      for(int i = 1; i <= size; i++) {
         for(int j = 1; j<= size; j++) {
            for(int y = 0; y < size; y++) {
               if(qArray[y].getRow() == i && qArray[y].getColumn() == j)
                  p = true;
            }
            System.out.print("|");
            if(p)
               System.out.print("Q");
            else
               System.out.print("_");
            p = false;
         }
         System.out.println("|");
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
}//class

