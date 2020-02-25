import java.util.*;
import java.text.*;

class TownOfSalem {
   public static void main(String[] args) {
      
      Scanner key = new Scanner(System.in);
      key.useDelimiter(System.getProperty("line.separator"));
      Random ran = new Random();
      boolean flag = true;
      String name = new String();
      int roleNum;
      String j = new String();
      String ti1 = new String();
      String ti2 = new String();
      String tp = new String();
      String tk = new String();
      String ts = new String();
      String rt1 = new String();
      String rt2 = new String();
      String rt3 = new String();
      String gf = new String();
      String maf = new String();
      String rm1 = new String();
      String rm2 = new String();
      String ne = new String();
      String nk = new String();
      
      System.out.println("Welcome to Town of Dabs!");
      
      while(flag) {
         try{
            System.out.println("Please enter a name to begin.");
            name = key.next();
            if(((int)name.charAt(0) < 65 || (int)name.charAt(0) > 122) || ((int)name.charAt(0) > 90 && (int)name.charAt(0) < 97)) {
               throw new Exception("Names must start with a letter.");
            }
            flag = false;
         } catch (Exception e) {
            System.out.println(e.getMessage());
         }
      }
      roleNum = ran.nextInt(29)+1;
      String role = new String(role(roleNum));
      System.out.println("You are " + name + " the " + role + ".");
      
      j = role(1);
      ti1 = role(ran.nextInt(3)+2);
      ti2 = role(ran.nextInt(3)+2);
      tp = role(ran.nextInt(2)+6);
      tk = role(ran.nextInt(2)+8);
      ts = role(ran.nextInt(5)+11);
      rt1 = role(ran.nextInt(12)+2);
      rt2 = role(ran.nextInt(12)+2);
      rt3 = role(ran.nextInt(12)+2);
      gf = role(15);
      maf = role(16);
      rm1 = role(ran.nextInt(7)+17);
      rm2 = role(ran.nextInt(7)+17);
      ne = role(ran.nextInt(2)+24);
      nk= role(ran.nextInt(2)+26);
      
      if(roleNum >= 2 && roleNum <=5) {
         ti1 = role;
      } else if(roleNum == 6 || roleNum == 7) {
         tp = role;
      } else if(roleNum == 8 || roleNum == 9) { 
         tk = role;
      } else if(roleNum >= 10 || roleNum <=14) {
         ts = role;
      } else if(roleNum >= 16 || roleNum <= 23) {  
         rm1 = role;
      } else if(roleNum >= 24 || roleNum <= 26) {
         ne = role;
      } else if(roleNum >= 27) {
         nk = role;
      } else {
      }
      
      System.out.println(jailor(key));
      
      
   }//main
   public static String role(int a) {
      String role = new String();
      switch(a) {
         case 1:  role = "Jailor";
                  break;
         case 2:  role = "Investigator";
                  break;
         case 3:  role = "Lookout";
                  break;
         case 4:  role = "Sheriff";
                  break; 
         case 5:  role = "Spy";
                  break;
         case 6:  role = "Bodyguard";
                  break;
         case 7:  role = "Doctor";
                  break;
         case 8:  role = "Veteran";
                  break;
         case 9:  role = "Vigilante";
                  break;
         case 10: role = "Escort";
                  break;
         case 11: role = "Mayor";
                  break;
         case 12: role = "Medium";
                  break;
         case 13: role = "Retributionist";
                  break;
         case 14: role = "Transporter";
                  break;
         case 15: role = "Godfather";
                  break;
         case 16: role = "Mafioso";
                  break;
         case 17: role = "Janitor";
                  break;
         case 18: role = "Framer";
                  break;
         case 19: role = "Forger";
                  break;
         case 20: role = "Disguiser";
                  break;
         case 21: role = "Consort";
                  break;
         case 22: role = "Consigliere";
                  break;
         case 23: role = "Blackmailer";
                  break;
         case 24: role = "Executioner";
                  break;
         case 25: role = "Jester";
                  break;
         case 26: role = "Witch";
                  break;
         case 27: role = "Arsonist";
                  break;
         case 28: role = "Serial Killer";
                  break;
         case 29: role = "Werewolf";
                  break;
      }
      return role;
   }//role
   
   public static int jailor(Scanner scan) {
      boolean flag = true;
      int a = 0;
      while(flag) {
         try {
            System.out.println("Select a target to jail.");
            a = scan.nextInt();
            if(a < 1 || a > 15) {
               throw new Exception("Please make a valid selection.");
            }
            flag = false;
         } catch(InputMismatchException e) {
            System.out.println("Please enter a number.");
            scan.next();
         } catch(Exception e) {
            System.out.println(e.getMessage());
         }
      }
      return a;
   }//jailor
}//class