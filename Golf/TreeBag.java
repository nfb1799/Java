// File: TreeBag.java 

// The implementation of most methods in this file is left as a student
// exercise from Section 9.5 of "Data Structures and Other Objects Using Java"


/******************************************************************************
* This class is a homework assignment;
* An <CODE>TreeBag</CODE> is a collection of int numbers.
*
* <dl><dt><b>Limitations:</b> <dd>
*   Beyond <CODE>Integer.MAX_VALUE</CODE> elements, <CODE>countOccurrences</CODE>,
*   and <CODE>size</CODE> are wrong. 
*
* <dt><b>Note:</b><dd>
*   This file contains only blank implementations ("stubs")
*   because this is a Programming Project for my students.
*
* @version
*   Jan 24, 2016
******************************************************************************/
public class TreeBag<E extends Comparable> implements Cloneable
{
   // The Term E extends Comparable is letting the compiler know that any type
   // used to instantiate E must implement Comparable. i. e. that means that whatever
   // type E is must have a compareTo method so that elements can be compared against one another
   // This is required becuase we are doing comparisons in our methods


   // Invariant of the TreeBag class:
   //   1. The elements in the bag are stored in a binary search tree.
   //   2. The instance variable root is a reference to the root of the
   //      binary search tree (or null for an empty tree).
   private BTNode<E> root;   


   /**
   * Insert a new element into this bag.
   * @param <CODE>element</CODE>
   *   the new element that is being inserted
   * <dt><b>Postcondition:</b><dd>
   *   A new copy of the element has been added to this bag.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory a new BTNode.
   **/
   public void add(E element)
   {      
      BTNode<E> addNode = new BTNode<E>(element, null, null);
      BTNode<E> cursor;
      
      if(root == null)
         root = addNode;
      else {
         cursor = root;
         
         //Sorts through the tree alphabetically and places the element
         //in the first available spot
         while(cursor != null) {
            if(cursor.getData().compareTo(element) == -1) {
               
               //Places the node or advances to the left
               if(cursor.getLeft() == null) {
                  cursor.setLeft(addNode);
                  cursor = null;
               } else {
                  cursor = cursor.getLeft();
               }
            } else if(cursor.getData().compareTo(element) == 1) {
               
               //Places the node or advances to the right
               if(cursor.getRight() == null) {
                  cursor.setRight(addNode);
                  cursor = null;
               } else {
                  cursor = cursor.getRight();
               }
            } else { //element already exists
               cursor = null;
            }
         }
      }
   }

   /**
   * Retrieve location of a specified element from this bag.
   * @param <CODE>target</CODE>
   *   the element to locate in the bag
   * @return 
   *  the return value is a reference to the found element in the tree
   * <dt><b>Postcondition:</b><dd>
   *   If <CODE>target</CODE> was found in the bag, then method returns
   *   a reference to a comparable element. If the target was not found then
   *   the method returns null.
   *   The bag remains unchanged.
   **/
   public E retrieve(E target)
   {
      if(root == null)
         return null;
      else { 
         BTNode<E> cursor = root;
         
         //Advances alphabetically through the tree until
         //the end of the tree or the target is reached
         while(cursor != null) {
            if(cursor.getData().compareTo(target) == 0) 
               return cursor.getData();
            else if(cursor.getData().compareTo(target) == -1)
               cursor = cursor.getLeft();
            else
               cursor = cursor.getRight();
         }
      }
      return null;
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
   public boolean remove(E target)
   {
      BTNode<E> cursor = root;
      BTNode<E> parent = null;
      boolean found = false;
      boolean rightSide = false;
      
      //Searches the tree for the target
      //Sets the cursor at the target and the parent before the target
      //Tracks whether the cursor is on the left or right of the parent
      while(cursor != null && !found) {
         if(cursor.getData().compareTo(target) == 0) {
            found = true;
         } else if(cursor.getData().compareTo(target) == -1) {
            rightSide = false;
            parent = cursor;
            cursor = cursor.getLeft();
         } else {
            rightSide = true;
            parent = cursor;
            cursor = cursor.getRight();
         }
      }
      
      if(found) {
         
         //There is only one node
         if(parent == null && cursor.isLeaf()) { 
            root = null;
            
         //Target is root node with no left subtree   
         } else if(parent == null && cursor.getLeft() == null) {
            root = root.getRight();
            
         //Target is root node with no right subtree   
         } else if(parent == null && cursor.getRight() == null) {
            root = root.getLeft();
            
         //Target has no right subtree   
         } else if(cursor.getRight() == null) {
            if(rightSide)
               parent.setRight(cursor.getLeft());
            else 
               parent.setLeft(cursor.getLeft());
               
         //Target has no left subtree      
         } else if(cursor.getLeft() == null) {
            if(rightSide)
               parent.setRight(cursor.getRight());
            else
               parent.setLeft(cursor.getRight());
               
         //All other cases      
         } else {
            cursor.setData(cursor.getLeft().getRightmostData());
            cursor.setLeft(cursor.getLeft().removeRightmost());
         }
         return true;
      }
      return false;
   }
   
   /**
   * Removes a leaf from the tree and returns the object in the leaf
   * @return
   *  The data contained in the leaf that is removed
   * @postcondition
   *  A leaf has been removed from the tree
   **/
   public E extractLeaf() 
   {
      if(root == null) 
         return null;
         
      BTNode<E> cursor = root;
      BTNode<E> parent = null;
      E answer = null;
      boolean rightSide = false;
      
      if(cursor.isLeaf())
         return cursor.getData();
      
      //Traverses the tree until a leaf is reached
      //Removes the leaf and returns the data
      while(cursor != null) {
         if(cursor.getLeft() != null) {
            rightSide = false;
            parent = cursor;
            cursor = cursor.getLeft();
         } else if(cursor.getRight() != null) {
            rightSide = true;
            parent = cursor;
            cursor = cursor.getRight();
         } else {
            answer = cursor.getData();
            if(rightSide)
               parent.setRight(null);
            else
               parent.setLeft(null);
            cursor = null;
         }
      } 
      return answer;  
   }
   
   /**
   * Displays the entire tree of Node elements in a order specified
   * by the elements compareTo method
   * 
   * @param 
   *   none
   * <dt><b>Postcondition:</b><dd>
   *   Outputs all elements in the tree to Screen.
   *   Does not change the structure 
   **/
   public void display()
   {
      root.inorderPrint();    
   } 
     
   /**
   * Displays the entire tree of Node elements using the
   * built in print method of BTNode
   * which displays the entire tree in tree format
   * 
   * @param 
   *   none
   * <dt><b>Postcondition:</b><dd>
   *   Outputs all elements in the tree to Screen.
   *   Does not change the structure 
   **/   
   public void displayAsTree() {
      root.print(0);
   }
      
   
   
   /**
   * Generate a copy of this bag.
   * @param - none
   * @return
   *   The return value is a copy of this bag. Subsequent changes to the
   *   copy will not affect the original, nor vice versa. Note that the return
   *   value must be type cast to an <CODE>TreeBag</CODE> before it can be used.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for creating the clone.
   **/ 
   public TreeBag<E> clone( )
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
   public int countOccurrences(E target)
   {
      // Student will replace this return statement with their own code:
      return 0;
   }
   
       
   /**
   * Determine the number of elements in this bag.
   * @param - none
   * @return
   *   the number of elements in this bag
   **/                           
   public int size( )
   {
      return BTNode.treeSize(root);
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
   public void addAll(TreeBag<E> addend)
   {
      // Implemented by student.
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
   public static TreeBag union(TreeBag b1, TreeBag b2)
   {
      // Student will replace this return statement with their own code:
      return null;
   }
      
}
           
