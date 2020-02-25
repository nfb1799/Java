// File: IntTreeBag.java

// The implementation of most methods in this file is left as a student
// exercise from Section 9.5 of "Data Structures and Other Objects Using Java"


/******************************************************************************
* This class is a homework assignment;
* An <CODE>IntTreeBag</CODE> is a collection of int numbers.
*
* <dl><dt><b>Limitations:</b> <dd>
*   Beyond <CODE>Integer.MAX_VALUE</CODE> elements, <CODE>countOccurrences</CODE>,
*   and <CODE>size</CODE> are wrong. 
*
* <dt><b>Outline of Java Source Code for this class:</b><dd>
*   <A HREF="../../../../edu/colorado/collections/IntTreeBag.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/collections/IntTreeBag.java
*   </A>
*
* <dt><b>Note:</b><dd>
*   This file contains only blank implementations ("stubs")
*   because this is a Programming Project for my students.
*
* @version
*   Jan 24, 1999
*
* @see IntArrayBag
* @see IntLinkedBag
******************************************************************************/
public class IntTreeBag implements Cloneable
{
   // Invariant of the IntTreeBag class:
   //   1. The elements in the bag are stored in a binary search tree.
   //   2. The instance variable root is a reference to the root of the
   //      binary search tree (or null for an empty tree).
   private IntBTNode root;   


   /**
   * Insert a new element into this bag.
   * @param <CODE>element</CODE>
   *   the new element that is being inserted
   * <dt><b>Postcondition:</b><dd>
   *   A new copy of the element has been added to this bag.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory a new IntBTNode.
   **/
   public void add(int element)
   {
      IntBTNode cursor;
      if (root == null)
         root = new IntBTNode(element, null, null);
      else
      {
         cursor = root;
         while (cursor != null)
         {
            if (element <= cursor.getData())
               cursor = cursor.getLeft();
            else
               cursor = cursor.getRight();
         }
         cursor = new IntBTNode(element, null, null);
      }
   }

   /**
   * Remove one copy of a specified element from this bag.
   * @param <CODE>target</CODE>
   *   the element to remove from the bag
   * <dt><b>Postcondition:</b><dd>
   *   If <CODE>target</CODE> was found in the bag, then one copy of
   *   <CODE>target</CODE> has been removed and the method returns true. 
   *   Otherwise the bag remains unchanged and the method returns false. 
   **/
   public boolean remove(int target)
   {
      IntBTNode cursor = root;
      IntBTNode parent = root;
      boolean result = false;
      
      while(!result) {
      
         if(target < cursor.getData()) { //if target is on left side
            if(cursor.getLeft() == null) { //if left side is a leaf
               return false;
            } else { //if left side is not a leaf
               parent = cursor;
               cursor = cursor.getLeft();
            }
         } else { //target is equal or on the right side
            if(target == cursor.getData()) { //found target
               if(cursor.getLeft() == null && cursor.getRight() == null) { //true if target is a leaf
                  if(parent.getLeft() == cursor) { //if target is on left side of parent
                     parent.setLeft(null);
                  } else { //if target is on right side of parent
                     parent.setRight(null);
                  }
               } else { //target is not a leaf
                  if(parent.getLeft() == cursor) { //if target is on left side of parent
                     parent.setLeft(cursor.getRight());
                  } else { //target is on right side of parent
                     parent.setRight(cursor.getLeft());
                  }
               }
               return true;
            } else { //target > cursor.getData()
               if(cursor.getRight() == null) {
                  return false;
               } else {
                  parent = cursor;
                  cursor = cursor.getRight();
               }
            }
         }
      }
      return false;
   }
   
      
   /**
   * Determine the number of elements in this bag.
   * @param - none
   * @return
   *   the number of elements in this bag
   **/   
                           
   public int size( )
   {
      return IntBTNode.treeSize(root);
   }
   /**
   * Add the contents of another bag to this bag.
   * @param <CODE>addend</CODE>
   *   a bag whose contents will be added to this bag
   * <dt><b>Precondition:</b><dd>
   *   The parameter, <CODE>addend</CODE>, is not null.
   * <dt><b>Postcondition:</b><dd>
   *   The elements from <CODE>addend</CODE> have been added to this bag.
   * @exception IllegalArgumentException
   *   Indicates that <CODE>addend</CODE> is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory to increase the size of the bag.
   **/
   public void addAll(IntTreeBag addend)
   {
      // Implemented by student.
   }
   
   
   /**
   * Generate a copy of this bag.
   * @param - none
   * @return
   *   The return value is a copy of this bag. Subsequent changes to the
   *   copy will not affect the original, nor vice versa. Note that the return
   *   value must be type cast to an <CODE>IntTreeBag</CODE> before it can be used.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for creating the clone.
   **/ 
   public IntTreeBag clone( )
   {  // Clone an IntTreeBag object.
      // Student will replace this return statement with their own code:
      return null; 
   }
   

   /**
   * Accessor method to count the number of occurrences of a particular element
   * in this bag.
   * @param <CODE>target</CODE>
   *   the element that needs to be counted
   * @return
   *   the number of times that <CODE>target</CODE> occurs in this bag
   **/
   public int countOccurrences(int target)
   {
      // Student will replace this return statement with their own code:
      return 0;
   }
              

   /**
   * Create a new bag that contains all the elements from two other bags.
   * @param <CODE>b1</CODE>
   *   the first of two bags
   * @param <CODE>b2</CODE>
   *   the second of two bags
   * <dt><b>Precondition:</b><dd>
   *   Neither b1 nor b2 is null.
   * @return
   *   the union of b1 and b2
   * @exception IllegalArgumentException
   *   Indicates that one of the arguments is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for the new bag.
   **/   
   public static IntTreeBag union(IntTreeBag b1, IntTreeBag b2)
   {
      // Student will replace this return statement with their own code:
      return null;
   }
         
}    