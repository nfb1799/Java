/* Nik Barbero
   This program will create an array of strings as big as the user wishes.
   The program will allow to user to set each of the strings in the array.
   After the array is saved, the user can navigate a menu to manipulate to array.
*/
import java.util.*;

class WordPlayNB {
   public static void main(String[] args) {
      
      /* introduces all of the variables and objects needed for the program
         all flags start as true 
         all user inputs start as 0
      */
      Scanner key = new Scanner(System.in);
      key.useDelimiter(System.getProperty("line.separator"));
      boolean flag = true;
      boolean flag2 = true;
      boolean flag3 = true;
      boolean flag4 = true;
      boolean flag5 = true;
      boolean flag6 = true;
      boolean flag7 = true;
      int strings = 0;
      int choice = 0;
      int choice2 = 0;
      int choice3 = 0;
      int choice4 = 0;
      int choice5 = 0;
      String replacement = new String();
      String addString = new String();
      
      System.out.println("This program will allow you to create and manipulate a set of strings.");
      
      while(flag) {
         try {
            System.out.println("How many strings will you be entering?"); //asks the user how many strings they will be entering
            strings = key.nextInt();
            if(strings < 0) {
               throw new Exception("Please enter a positive integer."); //new exception for negative inputs
            }
            flag = false; //exits the while loop when a valid input is entered
         } catch(Exception e) {//covers input mismatch and negative numbers
            System.out.println(e.getMessage());
            key.next(); //clears the scanner for input mismatches
         }
      }
      
      String[] bank = new String[strings]; //creates a new array called bank with as many strings as the user entered  
      
      //the user enters a string for each element in the array 
      System.out.println("Please enter your strings.");
      for(int i = 0; i < bank.length; i++) {
         System.out.print("String " + (i+1) + ": "); 
         bank[i] = key.next();
      }
      
      System.out.println("Array has been filled. Please select a menu option to continue.");
      
      while(flag3){
         while(flag2){ 
            //the menu is all one print statement
            System.out.println("\n\t1. Display all strings\n\t2. Display strings that contain non-letter characters\n\t3. Display strings that are longer than 5 characters\n\t4. Display strings that start with a capital letter\n\t5. Replace a string\n\t6. Remove a string\n\t7. Add a string\n\t8. Combine two strings\n\t9. Exit");
            try {
               choice = key.nextInt(); //asks the user to enter a menu option 1-9
               if(choice < 1 || choice > 9) {
                  throw new Exception("Please select a valid menu option.");//new exception for numbers that are not 1-9
               }
               flag2 = false; //exits the loop when a correct input is entered
            } catch(InputMismatchException e) {
               System.out.println("Please enter a number 1-9.");
               key.next(); //clears scanner
            } catch(Exception e) {
               System.out.println(e.getMessage()); //retrieves message for numbers not 1-9
            }
         }//inner while
         flag2 = true; //resets the flag for next loop
         
         switch(choice){
            case 1:  System.out.println("The strings you entered are:"); //diplays the string entered
                     for(int j = 0; j < bank.length; j++){
                        System.out.println((j+1) + ". " + bank[j]);
                     }
                     break;
            case 2:  System.out.println("The strings that contain non-letter characters are:"); //diplays strings with non-letter characters
                     String[] bank2 = nonLetters(bank);
                     int x = 1;
                     for(int j = 0; j < bank2.length; j++){
                        if(bank2[j].equals("0")){ //the nonLetters() method returns strings with only letters as "0", the program won't print those
                        } else {
                           System.out.println(x + ". " + bank2[j]);//prints the strings with non-letter character
                           x++;
                        }
                     }
                     if(x == 1) { //if no strings have non-letter characters
                        System.out.println("None");
                     }
                     break;
            case 3:  System.out.println("The strings that are longer than 5 characters are:"); //diplays strings that are more than 5 characters
                     String[] bank3 = fiveChar(bank);
                     x = 1;
                     for(int k = 0; k < bank3.length; k++) {
                        if(bank3[k].equals("0")){ //the fiveChar() method returns strings with 5 or less letters as "0", the program won't print those
                        } else { 
                           System.out.println(x + ". " + bank3[k]);//prints strings with more than 5 characters
                           x++;
                        }
                     }
                     if(x == 1) { //if no strings have more than 5 characters
                        System.out.println("None");
                     }
                     break;
            case 4:  System.out.println("The strings that start with a capital letter are:"); //displays strings that start with a capital letter
                     String[] bank4 = capStart(bank);
                     x = 1;
                     for(int l = 0; l < bank4.length; l++) {
                        if(bank4[l].equals("0")){//the capStart() method returns strings that don't start with a capital as "0", the program won't print those
                        } else {
                           System.out.println(x + ". " + bank4[l]);//prints the strings that start with a capital letter
                           x++;
                        }
                     }
                     if(x == 1) { //if no strings start with a capital letter
                        System.out.println("None");
                     }
                     break;
            case 5:  while(flag4){//displays all strings with the proper number assigned and asks the user which they would like to replace
                        System.out.println("Enter the number of the string you would like to replace.");
                        int m = 1;
                        for(String list : bank) {
                           System.out.println("\t" + m + ". " + list);
                           m++;
                        }
                        try{
                           choice2 = key.nextInt();
                           if(choice2 < 1 || choice2 > bank.length) {
                              throw new Exception("Please enter a number 1 - " + bank.length); //the number cannot be greater than the size of the array
                           }
                           flag4 = false; //exits the loop when a correct input is entered
                        } catch(InputMismatchException e) {
                           System.out.println("Please enter a number 1 - " + bank.length);
                           key.next(); //clears the scanner
                        } catch(Exception e) {
                           System.out.println(e.getMessage());
                        }
                     }
                     flag4 = true;//resets the flag for the next loop
                     System.out.println("Please enter the string you would like to replace it with.");//asks the user what they would like the replace the string with
                     replacement = key.next();//saves the next input as a string
                     replace(bank,choice2,replacement);//replaces the string in a method
                     System.out.println("Your string has been replaced.");//confirms replacement
                     break;
            case 6:  while(flag5){//displays all strings with the proper number assigned and asks the user which they would like to remove
                        System.out.println("Enter the number of the string you would like to remove.");
                        int m = 1;
                        for(String list : bank) {
                           System.out.println("\t" + m + ". " + list);
                           m++;
                        }
                        try{
                           choice3 = key.nextInt();
                           if(choice3 < 1 || choice3 > bank.length) {
                              throw new Exception("Please enter a number 1 - " + bank.length);//the input cannot be greater than the total size of the array
                           }
                           flag5 = false; //exits the loop when a correct input is entered
                        } catch(InputMismatchException e) {
                           System.out.println("Please enter a number 1 - " + bank.length);
                           key.next();//clears the scanner
                        } catch(Exception e) {
                           System.out.println(e.getMessage());
                        }
                     }
                     flag5 = true;//resets the flag for next loop
                     bank = remove(bank,choice3);//the remove() function deletes the string that the user chose and returns a new array
                     System.out.println("String has been removed.");//confirms removal
                     break;
            case 7:  System.out.println("Enter the string you would like to add."); //asks the user to enter a new string
                     addString = key.next();
                     bank = add(bank,addString); //the add() function adds creates a new array with one more element and adds the new string
                     System.out.println("String has been added.");//confirmation
                     break;
            case 8:  System.out.println("Enter the numbers of the two strings you would like to combine.");//asks the user to select two strings to combine
                     for(int i = 0; i < bank.length; i++) {
                        System.out.println("\t" + (i+1) + ". " + bank[i]);//prints and formats all the strings with a number
                     }
                     while(flag6) {
                        try { //try blocks are separated here so the user doesn't have to re-enter both choices if they mess up on the second one
                           choice4 = key.nextInt();
                           if(choice4 < 1 || choice4 > bank.length) { //new exception for numbers not listed 
                              throw new Exception("Please enter a number 1 - " + bank.length);
                           }
                           flag6 = false;
                        } catch(InputMismatchException e) {
                           System.out.println("Please enter a number 1 - " + bank.length);
                           key.next();//clears scanner
                        } catch(Exception e) {
                           System.out.println(e.getMessage());//retrieves message for numbers less than 1 and greater than the size of the array
                        }
                     } //while
                     flag6 = true;
                     while(flag7){
                        try {
                           choice5 = key.nextInt();
                           if(choice5 < 1 || choice5 > bank.length || choice4 == choice5) {
                              throw new Exception("Please enter a new number 1 - " + bank.length);//new exception for numbers not listed and double inputs
                           }
                           flag7 = false;
                        } catch(InputMismatchException e) {
                           System.out.println("Please enter a new number 1 - " + bank.length);
                           key.next();//clears scanner
                        } catch(Exception e) {
                           System.out.println(e.getMessage());//retrieves message for numbers less than 1 and greater than the size of the array
                        }
                     } //while
                     flag7 = true;
                     bank = combine(bank,choice4,choice5);//the combine() function returns an array with one less element and combines the two that the user chose into one element
                     System.out.println("Strings have been combined."); //confirmation
                     break;
            case 9:  flag3 = false; //exits the program
                     break;
         }//switch
      }//outer while
      System.out.println("Thank you. Goodbye.");
   }//main
   
   public static String[] nonLetters(String[] a) {
      boolean flag = true;//a flag for strings that have non-letter characters
      String[] b = new String[a.length];
      for(int i = 0; i < a.length; i++) {
         flag = true; //resets the flag for the next element
         for(int j = 0; j < a[i].length(); j++){
            if((int)a[i].charAt(j) < 65 || ((int)a[i].charAt(j) > 90 && (int)a[i].charAt(j) < 97) || (int)a[i].charAt(j) > 123) {//if any character of a string isn't a letter
               flag = false; //flag is set to false if any character in the string is a non-letter, including spaces
            }
         }
         if(flag) {
            b[i] = "0";//returns strings with only letters as "0"
         } else {
            b[i] = a[i];//returns strings that have non-letter characters
         }
      }
      return b;
   }//nonLetters
   
   public static String[] fiveChar(String[] a) {
      String[] b = new String[a.length];
      for(int i = 0; i < a.length; i++) {
         if(a[i].length() > 5){//if the string has more than 5 characters
            b[i] = a[i];
         } else {
            b[i] = "0"; //if the string has 5 or less characters "0" is returned
         }
      }
      return b;
   }//fiveChar
   
   public static String[] capStart(String[] a) {
      String[] b = new String[a.length];
      for(int i = 0; i < a.length; i++){
         if((int)a[i].charAt(0) > 64 && (int)a[i].charAt(0) < 91) { //if the first character is capital
            b[i] = a[i];
         } else { 
            b[i] = "0";//if the first character is not capital "0" is returned
         }
      }
      return b;
   }//capStart
   
   public static String[] replace(String[] a, int b, String c) {
      a[b-1] = c;//replaces the string at the chosen number with a new string
      return a;
   }//replace
   
   public static String[] remove(String[] a, int b) {
      String[] c = new String[(a.length)-1];//creates a new array with one less element
      b--;//the index is 1 less than the users input
      int j = 0;
      for(int i = 0; i < a.length; i++) {
         if(i != b) {//every string that was not the number the user entered will remeain.
            c[j] = a[i];
            j++;//j increments for all strings that aren't the users input, j will be 1 less than i at the end of the loop
         }
      }
      return c;//returns an array with one less element that before
   }//remove
   
   public static String[] add(String[] a, String c) {
      String[] b = new String[(a.length)+1];//creates a new array with one more element
      for(int i = 0; i < a.length; i++) { //reassigns all the values from the previous array to the new one
         b[i] = a[i];
      }
      b[a.length] = c; //adds the new string to the end of the new array
      return b;
   }//add
   
   public static String[] combine(String[] a, int b, int c) {
      String[] d = new String[(a.length)-1]; //creates a new array with one less element
      int j = 0;
      int m = (a.length)-1;
      if(b < c) {
         for(int i = 0; i < d.length; i++) {
            if(i == (b-1)){ //if i = the first value selected by the user
               d[i] = a[b-1] + a[c-1]; //sets d[i] to the combination of the users selections
               j++;
            } else if(i == (c-1)){
               d[i] = a[c];
               j+=2; //skips an element for the lesser size of the array and another element for the count of the loop
            } else {
               d[i] = a[j]; //keeps the rest of the array the same
               j++;
            }
         }
      }//if b < c
      if(b > c) { //CURRENTLY FAILS WHEN C IS 1 LESS THAN B
         for(int i = (d.length)-1; i > -1; i--) { //starts at the last index of d and ends at 0
            if(i == (b-2)) { //b-2 because d is one less element and the index is one less than the user input
               d[i] = a[b-1]+a[c-1];//set
               m--;
               System.out.println("String saved to String " + (i+1) + ".");
            } else if(i == (c-1) && (b-c) != 1) {//c-1 because c < b and the size or the array has already been accounted for
               d[i] = a[c];
               m-=2; //decrement 2 because its one less element and one for the loop count
            } else if(i == (c-1) && (b-c) == 1) {
               d[i] = a[c-1];
               m-=2;
            } else {
               d[i] = a[m];//sets the rest of the array the same or one element less
               m--;
            }
         }
      }//if b > c
      return d;
   }
   
}//class