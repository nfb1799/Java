/*
   Program:       UnboundedInt.java
   Author:        Nik Barbero
   Date:          3/22/2019
   Description:   ADT to store integers of any size and not 
                  limited to 32 or 64 bits of storage.
*/
public class UnboundedInt implements Cloneable {
   
   // Invariant of the UnboundedInt class:
   //    1. The number of nodes in an UnboundedInt is manyNodes.
   //       Each node contains a number 0-999 with placeholder 0's
   //       when necessary.
   //    2. The head node contains the hundreds place of an UnboundedInt.
   //       It is also the start of the linked list containing the UnboundedInt.       
   //    3. The tail node contains the highest power of ten of an UnboundedInt.
   //       It is also the last node of the linked list containing an UnboundedInt.
   //    4. The instance variable cursor points to the currently selected node
   //       of the linked list. If there is no current node, cursor is null.
   private IntNode head;
   private IntNode tail;
   private IntNode cursor;
   private int manyNodes;
   
   /**
   *  Initialize an UnboundedInt with all nodes set to null
   *  and manyNodes set to 0. Note that the addEnd method works.
   *  @postcondition
   *     This UnboundedInt is empty. 
   **/
   public UnboundedInt() {
      head = null;
      tail = null;
      cursor = null;
      manyNodes = 0;
   }
   
   /**
   *  Initialize an UnboundedInt from a string of integers.
   *  @param str
   *     A string to be converted to an UnboundedInt.
   *  @precondition
   *     Every character in str is an integer.
   *  @postcondition
   *     This UnboundedInt is filled with the number from str.
   *  @exception OutOfMemoryError
   *     Indicates insufficient memory for this UnboundedInt.
   **/
   public UnboundedInt(String str) {
      manyNodes = 0;
      
      int[] array = new int[str.length()];
      
      for(int i = 0; i < array.length; i++) {
         array[i] = (int)(str.charAt(i)) - 48;
      }
      
      for(int k = (array.length - 1); k >= 0; k -= 3) {
         if(k - 2 >= 0) {
            addEnd(array[k] + array[k-1]*10 + array[k-2]*100);
         } else if(k - 1 >= 0) {
            addEnd(array[k] + array[k-1]*10);
         } else {
            addEnd(array[k]);
         }
      }
      
      
   }
   
   /**
   *  Add the integer value of an UnboundedInt to another to create
   *  a new UnboundedInt.
   *  @param adding
   *     The UnboundedInt to be added to this.
   *  @return
   *     An UnboundedInt containing the sum of the integers stored
   *     in this UnboundedInt and adding. The cursor of the return
   *     is set to the head of the linked list.
   *  @exception OutOfMemoryError
   *     Indicates insufficient memory for the new UnboundedInt.
   **/
   public UnboundedInt add(UnboundedInt adding) {
      int sum;
      boolean remainder = false;
      UnboundedInt finalSum = new UnboundedInt();
      
      start();
      adding.start();
      
      while(cursor != null && adding.cursor != null) {
         sum = getNodeValue() + adding.getNodeValue();
         
         if(remainder == true)
            sum = sum + 1;
            
         if(sum > 999) {
            sum = sum - 1000;
            finalSum.addEnd(sum);
            remainder = true;
         } else {
            finalSum.addEnd(sum);
            remainder = false;
         }
         
         advance();
         adding.advance();
      }
      
      while(cursor != null || adding.cursor != null || remainder == true) {
         if(remainder == true) {
            if(cursor == null && adding.cursor == null) {
               finalSum.addEnd(1);
               remainder = false;
            } else if(cursor != null) {
               sum = getNodeValue() + 1;
               if(sum > 999) {
                  sum = sum - 1000;
                  finalSum.addEnd(sum);
                  remainder = true;
               } else {
                  finalSum.addEnd(sum);
                  remainder = false;
               }
            } else if(adding.cursor != null) {
               sum = adding.getNodeValue() + 1;
               if(sum > 999) {
                  sum = sum - 1000;
                  finalSum.addEnd(sum);
                  remainder = true;
               } else {
                  finalSum.addEnd(sum);
                  remainder = false;
               }
            }
         } else if(remainder == false) {
            if(cursor != null) {
               finalSum.addEnd(getNodeValue());
            } else if(adding.cursor != null) {
               finalSum.addEnd(adding.getNodeValue());
            }
         }
         
         advance();
         adding.advance();
      } 
      
      finalSum.start();
      return finalSum;
   }
   
   /**
   *  Add an integer to the end of a linked listed contained
   *  in an UnboundedInt.
   *  @param element
   *     The integer to be added to the list.
   *  @precondition
   *     element is a positive integer less than 999.
   *  @postcondition
   *     An integer 0-999 has been added to the end of the linked list
   *     contained by this UnboundedInt. The cursor has been set to
   *     this element.
   *  @exception IllegalStateException
   *     Indicates the element is negative or greater than 999.
   *  @exception OutOfMemoryError
   *     Indicates insufficient memory for this UnboundedInt.
   **/
   public void addEnd(int element) {
      
      if(element < 0)
         throw new IllegalStateException("The element entered is a negative number.");
      
      if(element > 999)
         throw new IllegalStateException("The element enetered is longer than 3 digits.");
         
      if(tail == null) {
         tail = new IntNode(element, null);
         head = tail;
         cursor = tail;
      } else {
         tail.addNodeAfter(element);
         tail = tail.getLink();
         cursor = tail;
      }
      
      manyNodes++;
   }
   
   /**
   *  Generate a copy of this UnboundedInt.
   *  @return
   *     The return value is a copy of this UnboundedInt. Subsequent changes to the
   *     copy will not affect the original, nor vice versa.
   *  @exception OutOfMemoryError
   *     Indicates insufficient memory for creating the clone.
   *  @exception RuntimeException
   *     Indicates the class does not implement cloneable.
   **/ 
   public UnboundedInt clone() {
      UnboundedInt cloned;
      IntNode[] nodeArray;
      
      try {
         cloned = (UnboundedInt) super.clone();
      } catch (CloneNotSupportedException e) {
         throw new RuntimeException("This class does not implement cloneable.");
      }
      
      nodeArray = IntNode.listCopyWithTail(head);
      
      cloned.head = nodeArray[0];
      cloned.tail = nodeArray[1];
      cloned.cursor = cloned.tail;
      cloned.start();
      
      return cloned;
   }
   
   /**
   *  Compare two UnboundedInt objects and determine whether they are equal.
   *  @param obj
   *     The UnboundedInt being compared to this UnboundedInt.
   *  @return
   *     True (if the integers are equal) or false (if the integers are not equal).
   **/
   public boolean equals(Object obj) {
      boolean equal = false;
      
      if(obj instanceof UnboundedInt) {
         UnboundedInt check = (UnboundedInt) obj;
         
         if(manyNodes == check.manyNodes) {
            equal = true;
            start();
            check.start();
            
            while(cursor != null && equal) {
               if(getNodeValue() != check.getNodeValue()) {
                  equal = false;
               }
               advance();
               check.advance();
            }
         } 
      }
      
      return equal;
   }
   
   /**
   *  Convert an UnboundedInt to a string with commas.
   *  @precondition
   *     The UnboundedInt is not empty.
   *  @return
   *     A string of the integer stored in this UnboundedInt with
   *     commas separating every three digits.
   *  @exception IllegalStateException
   *     Indicates this UnboundedInt is empty.
   **/
   public String toString() {
      if(head == null) 
         throw new IllegalStateException("The Unbounded Int is empty.");
      
      String unboundedInt = "";
      start();
      
      unboundedInt = Integer.toString(cursor.getData());
      if(manyNodes == 1) {
         unboundedInt = Integer.toString(getNodeValue());
      } else if(cursor.getData() < 10) {
         unboundedInt = "00" + unboundedInt;
      } else if(cursor.getData() < 100) {
         unboundedInt = "0" + unboundedInt;
      }
      
      advance();
      
      while(cursor != null) {
         if(getNodeValue() < 10 && cursor.getLink() == null) {
            unboundedInt = Integer.toString(getNodeValue()) + "," + unboundedInt;
         } else if(getNodeValue() < 10) {
            unboundedInt = "00" + Integer.toString(getNodeValue()) + "," + unboundedInt;
         } else if(getNodeValue() < 100 && cursor.getLink() == null) {
            unboundedInt = Integer.toString(getNodeValue()) + "," + unboundedInt;
         } else if(getNodeValue() < 100) {
            unboundedInt = "0" + Integer.toString(getNodeValue()) + "," + unboundedInt;
         } else if(getNodeValue() >= 100) {
            unboundedInt = Integer.toString(getNodeValue()) + "," + unboundedInt;  
         }
         
         advance();
      }
      
      return unboundedInt;
   }
   
   /**
   *  Set the cursor of an UnboundedInt to the head of the list.
   *  @postcondition
   *     The cursor of this UnboundedInt has been set to the head
   *     of the list.
   **/
   public void start() {
      cursor = head;
   }
   
   /**
   *  Set the cursor of an UnboundedInt to the next node of the list.
   *  @precondition
   *     The cursor may not be set to null when the method is called.
   *  @postcondition
   *     The cursor of this UnboundedInt has been set to the next node
   *     of the list.
   **/
   public void advance() {
      if(cursor != null)
         cursor = cursor.getLink();
   }
   
   /**
   *  Accessor method to get the value of the currently selected node.
   *  @precondition
   *     The cursor of this UnboundedInt is not null.
   *  @return
   *     The three digit value of the currently selected node.
   *  @exception IllegalStateException
   *     Indicates the cursor is null and there is no current element.
   **/
   public int getNodeValue() {
      if(cursor == null)
         throw new IllegalStateException("There is no current element.");
      
      return cursor.getData();
   }
   
   /**
   *  Convert an UnboundedInt to a string without commas.
   *  @precondition
   *     The UnboundedInt is not empty.
   *  @return
   *     A string of the integer stored in this UnboundedInt
   *     without commas.
   *  @exception IllegalStateException
   *     Indicates this UnboundedInt is empty.
   **/
   public String toStringNoCommas() {
      if(head == null) 
         throw new IllegalStateException("The Unbounded Int is empty.");
      
      String unboundedInt = "";
      start();
      
      unboundedInt = Integer.toString(cursor.getData());
      if(manyNodes == 1) {
         unboundedInt = Integer.toString(getNodeValue());
      } else if(cursor.getData() < 10) {
         unboundedInt = "00" + unboundedInt;
      } else if(cursor.getData() < 100) {
         unboundedInt = "0" + unboundedInt;
      }
      
      advance();
      
      while(cursor != null) {
         if(getNodeValue() < 10 && cursor.getLink() == null) {
            unboundedInt = Integer.toString(getNodeValue()) + unboundedInt;
         } else if(getNodeValue() < 10) {
            unboundedInt = "00" + Integer.toString(getNodeValue()) + unboundedInt;
         } else if(getNodeValue() < 100 && cursor.getLink() == null) {
            unboundedInt = Integer.toString(getNodeValue()) + unboundedInt;
         } else if(getNodeValue() < 100) {
            unboundedInt = "0" + Integer.toString(getNodeValue()) + unboundedInt;
         } else if(getNodeValue() >= 100) {
            unboundedInt = Integer.toString(getNodeValue()) + unboundedInt;  
         }
         
         advance();
      }
      
      return unboundedInt;
   }
   
   /**
   *  Multiply the integer value of an UnboundedInt with another to create
   *  a new UnboundedInt.
   *  @param multi
   *     The UnboundedInt to be multiplied with this UnboundedInt
   *  @precondition
   *     Neither this UnboundedInt nor multi is empty.
   *  @return
   *     An UnboundedInt containing the product of the integers stored
   *     in this UnboundedInt and multi. The cursor of the return
   *     is set to the head of the linked list.
   *  @exception IllegalStateException
   *     Indicates one or both UnboundedInt objects are empty.
   *  @exception OutOfMemoryError
   *     Indicates insufficient memory for the new UnboundedInt.
   **/
   public UnboundedInt multiply(UnboundedInt multi) {
   
      if(this.manyNodes == 0 || multi.manyNodes == 0)
         throw new IllegalStateException("One or both numbers are empty.");
      
      UnboundedInt product = new UnboundedInt("0");
      UnboundedInt currentTot = new UnboundedInt();
      int count = 0;
      int carry = 0;
      int currentProd = 0;
      
      for(IntNode thisCursor = this.head; thisCursor != null; thisCursor = thisCursor.getLink()) {
         carry = 0;
         currentTot = new UnboundedInt();
         
         for(int i = 0; i < count; i++) {
            currentTot.addEnd(0);
         }
         
         for(IntNode multiCursor = multi.head; multiCursor != null; multiCursor = multiCursor.getLink()) {
            currentProd = ((thisCursor.getData()) * (multiCursor.getData())) + carry;
            
            carry = currentProd/1000;
            currentProd %= 1000;
            currentTot.addEnd(currentProd);
         }
         
         if(carry > 0)
            currentTot.addEnd(carry);
            
         product = product.add(currentTot);
         count++;
      }
   
      product.start();
      return product;   
   }
}