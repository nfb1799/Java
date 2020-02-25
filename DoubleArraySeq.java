/* 
   Program: DoubleArraySeq.java
   Authors: Nik Barbero, Traylin
   Date: 3/2/2019
   Description: ADT that allows easily manipulation of an array of doubles.
*/
public class DoubleArraySeq implements Cloneable
{
   // Invariant of the DoubleArraySeq class:
   //   1. The number of elements in the seqeunces is in the instance variable 
   //      manyItems.
   //   2. For an empty sequence (with no elements), we do not care what is 
   //      stored in any of data; for a non-empty sequence, the elements of the
   //      sequence are stored in data[0] through data[manyItems-1], and we
   //      don’t care what’s in the rest of data.
   //   3. If there is a current element, then it lies in data[currentIndex];
   //      if there is no current element, then currentIndex equals manyItems. 
   private double[ ] data;
   private int manyItems;
   private int currentIndex; 
   
   /**
   * Initialize an empty sequence with an initial capacity of 10.  Note that
   * the addAfter and addBefore methods work
   * efficiently (without needing more memory) until this capacity is reached.
   * @postcondition
   *   This sequence is empty and has an initial capacity of 10.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for: 
   *   new double[10].
   **/   
   public DoubleArraySeq( )
   {
      data = new double[10];
      manyItems = 0;
      currentIndex = -1;
   }
     

   /**
   * Initialize an empty sequence with a specified initial capacity. Note that
   * the addAfter and addBefore methods work
   * efficiently (without needing more memory) until this capacity is reached.
   * @param initialCapacity
   *   the initial capacity of this sequence
   * @precondition
   *   initialCapacity is non-negative.
   * @postcondition
   *   This sequence is empty and has the given initial capacity.
   * @exception IllegalArgumentException
   *   Indicates that initialCapacity is negative.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for: 
   *   new double[initialCapacity].
   **/   
   public DoubleArraySeq(int initialCapacity)
   {
      if(initialCapacity >= 0) {
         data = new double[initialCapacity];
         manyItems = 0;
         currentIndex = -1;
      } else {
         throw new IllegalArgumentException("The capacity cannot be negative.");
      }
   }
        
 
   /**
   * Add a new element to this sequence, after the current element. 
   * If the new element would take this sequence beyond its current capacity,
   * then the capacity is increased before adding the new element.
   * @param element
   *   the new element that is being added
   * @postcondition
   *   A new copy of the element has been added to this sequence. If there was
   *   a current element, then the new element is placed after the current
   *   element. If there was no current element, then the new element is placed
   *   at the end of the sequence. In all cases, the new element becomes the
   *   new current element of this sequence. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for increasing the sequence's capacity.
   * @note
   *   An attempt to increase the capacity beyond
   *   Integer.MAX_VALUE will cause the sequence to fail with an
   *   arithmetic overflow.
   **/
   public void addAfter(int element)
   {
      if(manyItems == data.length) 
         ensureCapacity(manyItems * 2 + 1);
         
      if(currentIndex <= 0)
         currentIndex = 0;
      else
         currentIndex++;
      
      for(int i = manyItems; i > currentIndex; i--) {
        data[i + 1] = data[i];
      }
      
      data[currentIndex] = element;
      manyItems++;
   }


   /**
   * Add a new element to this sequence, before the current element. 
   * If the new element would take this sequence beyond its current capacity,
   * then the capacity is increased before adding the new element.
   * @param element
   *   the new element that is being added
   * @postcondition
   *   A new copy of the element has been added to this sequence. If there was
   *   a current element, then the new element is placed before the current
   *   element. If there was no current element, then the new element is placed
   *   at the start of the sequence. In all cases, the new element becomes the
   *   new current element of this sequence. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for increasing the sequence's capacity.
   * @note
   *   An attempt to increase the capacity beyond
   *   Integer.MAX_VALUE will cause the sequence to fail with an
   *   arithmetic overflow.
   **/
   public void addBefore(int element)
   {
      if(manyItems == data.length)
         ensureCapacity(manyItems * 2 + 1);
         
      if(!isCurrent())
         currentIndex = 0;  
      
      for(int i = manyItems; i >= currentIndex; i--)
         data[i+1] = data[i];
      
      data[currentIndex] = element;
      manyItems++;
   }
   
   
   /**
   * Place the contents of another sequence at the end of this sequence.
   * @param addend
   *   a sequence whose contents will be placed at the end of this sequence
   * @precondition
   *   The parameter, addend, is not null. 
   * @postcondition
   *   The elements from addend have been placed at the end of 
   *   this sequence. The current element of this sequence remains where it 
   *   was, and the addend is also unchanged.
   * @exception NullPointerException
   *   Indicates that addend is null. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory to increase the size of this sequence.
   * @note
   *   An attempt to increase the capacity beyond
   *   Integer.MAX_VALUE will cause an arithmetic overflow
   *   that will cause the sequence to fail.
   **/
   public void addAll(DoubleArraySeq addend)
   {
      if(addend == null)  
         throw new NullPointerException("The sequence is null.");
      
      this.ensureCapacity(manyItems + addend.manyItems);
      System.arraycopy(addend.data, 0, this.data, this.manyItems, addend.manyItems);
      manyItems += addend.manyItems;
   }   
   
   
   /**
   * Move forward, so that the current element is now the next element in
   * this sequence.
   * @precondition
   *   isCurrent() returns true. 
   * @postcondition
   *   If the current element was already the end element of this sequence 
   *   (with nothing after it), then there is no longer any current element. 
   *   Otherwise, the new element is the element immediately after the 
   *   original current element.
   * @exception IllegalStateException
   *   Indicates that there is no current element, so 
   *   advance may not be called.
   **/
   public void advance( )
   {
      if(!isCurrent())
         throw new IllegalStateException("There is no current element.");
      
      currentIndex++;
   }
   
   
   /**
   * Generate a copy of this sequence.
   * @return
   *   The return value is a copy of this sequence. Subsequent changes to the
   *   copy will not affect the original, nor vice versa.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for creating the clone.
   **/ 
   public DoubleArraySeq clone( )
   {  // Clone a DoubleArraySeq object.
      DoubleArraySeq answer;
      
      try
      {
         answer = (DoubleArraySeq) super.clone( );
      }
      catch (CloneNotSupportedException e)
      {  // This exception should not occur. But if it does, it would probably
         // indicate a programming error that made super.clone unavailable.
         // The most common error would be forgetting the "Implements Cloneable"
         // clause at the start of this class.
         throw new RuntimeException
         ("This class does not implement Cloneable");
      }
      
      answer.data = data.clone( );
      
      return answer;
   }
   

   /**
   * Create a new sequence that contains all the elements from one sequence
   * followed by another.
   * @param s1
   *   the first of two sequences
   * @param s2
   *   the second of two sequences
   * @precondition
   *   Neither s1 nor s2 is null.
   * @return
   *   a new sequence that has the elements of s1 followed by the
   *   elements of s2 (with no current element)
   * @exception NullPointerException
   *   Indicates that one of the arguments is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for the new sequence.
   * @note
   *   An attempt to create a sequence with a capacity beyond
   *   Integer.MAX_VALUE will cause an arithmetic overflow
   *   that will cause the sequence to fail.
   **/   
   public static DoubleArraySeq concatenation(DoubleArraySeq s1, DoubleArraySeq s2)
   {
      if(s1 == null || s2 == null)
         throw new NullPointerException("One or both of the sequences are null.");
         
      DoubleArraySeq s3 = new DoubleArraySeq(s1.manyItems + s2.manyItems);
      System.arraycopy(s1.data, 0, s3.data, 0, s1.manyItems);
      System.arraycopy(s2.data, 0, s3.data, s1.manyItems, s2.manyItems);
      s3.manyItems = s3.data.length;
      return s3;
   }


   /**
   * Change the current capacity of this sequence.
   * @param minimumCapacity
   *   the new capacity for this sequence
   * @postcondition
   *   This sequence's capacity has been changed to at least minimumCapacity.
   *   If the capacity was already at or greater than minimumCapacity,
   *   then the capacity is left unchanged.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for: new int[minimumCapacity].
   **/
   public void ensureCapacity(int minimumCapacity)
   {
      double biggerArray[];
      if(data.length < minimumCapacity) {
         biggerArray = new double[minimumCapacity];
         System.arraycopy(data, 0, biggerArray, 0, manyItems);
         data = biggerArray;
      }
   }

   
   /**
   * Accessor method to get the current capacity of this sequence. 
   * The add method works efficiently (without needing
   * more memory) until this capacity is reached.
   * @return
   *   the current capacity of this sequence
   **/
   public int getCapacity()
   {
      return data.length;
   }


   /**
   * Accessor method to get the current element of this sequence. 
   * @precondition
   *   isCurrent() returns true.
   * @return
   *   the current element of this sequence
   * @exception IllegalStateException
   *   Indicates that there is no current element, so 
   *   getCurrent may not be called.
   **/
   public double getCurrent( )
   {
      if(isCurrent())
         return data[currentIndex];
      else
         throw new IllegalStateException("There is no current element.");
   }


   /**
   * Accessor method to determine whether this sequence has a specified 
   * current element that can be retrieved with the 
   * getCurrent method. 
   * @return
   *   true (there is a current element) or false (there is no current element at the moment)
   **/
   public boolean isCurrent( )
   {
      return currentIndex >= 0;
   }
              
   /**
   * Remove the current element from this sequence.
   * @precondition
   *   isCurrent() returns true.
   * @postcondition
   *   The current element has been removed from this sequence, and the 
   *   following element (if there is one) is now the new current element. 
   *   If there was no following element, then there is now no current 
   *   element.
   * @exception IllegalStateException
   *   Indicates that there is no current element, so 
   *   removeCurrent may not be called. 
   **/
   public void removeCurrent( )
   {
      if(!isCurrent())
         throw new IllegalStateException("There is no current element.");
      
      for(int i = currentIndex; i < manyItems; i++)
         try {
            data[i] = data[i+1];
         } catch(ArrayIndexOutOfBoundsException e) {
         }
      
      manyItems--;
      if(currentIndex == manyItems)
         currentIndex = -1;
   }
                 
   
   /**
   * Determine the number of elements in this sequence.
   * @return
   *   the number of elements in this sequence
   **/ 
   public int getSize( )
   {
      return manyItems;
   }
   
   
   /**
   * Set the current element at the front of this sequence.
   * @postcondition
   *   The front element of this sequence is now the current element (but 
   *   if this sequence has no elements at all, then there is no current 
   *   element).
   **/ 
   public void start( )
   {
      if(data.length > 0)
         currentIndex = 0;
   }
   
   
   /**
   * Reduce the current capacity of this sequence to its actual size (i.e., the
   * number of elements it contains).
   * @postcondition
   *   This sequence's capacity has been changed to its current size.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for altering the capacity. 
   **/
   public void trimToSize( )
   {
      double[ ] trimmedArray;
      
      if (data.length != manyItems)
      {
         trimmedArray = new double[manyItems];
         System.arraycopy(data, 0, trimmedArray, 0, manyItems);
         data = trimmedArray;
      }
   }
   
   /**
   * Add a new element to the front of a sequence.
   * @param element
   *   The new element that is being added.     
   * @postcondition
   *   A new element has been added to the front of the sequence
   *   and has been set as the current element.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for altering the capacity.
   **/
   public void addFront(double element) 
   {
      if((manyItems + 1) >= data.length)
         ensureCapacity(manyItems * 2 + 1);
      
      for(int i = manyItems; i >= 0; i--)
         data[i+1] = data[i];
      
      data[0] = element;
      manyItems++;
      currentIndex = 0; 
   }
   
   /**
   * Remove the element at the front of the sequence.
   * @precondition
   *   isCurrent() returns true.
   * @postcondition
   *   The first element in the sequence has been removed
   *   and the rest of the sequence has been shifted down.
   *   If there is a next element, it is the current element.
   *   Otherwise, the current element becomes null.
   * @exception IllegalStateException
   *   Indicates there is no current element so
   *   removeFront() cannot be called. 
   **/
   public void removeFront()
   {
      start();
      removeCurrent();    
   }
   
   /**
   * Adds the element to the end of the sequence.
   * @param element
   *   The element that is being added to the end of the sequence.
   * @postcondition
   *   The new element has been added to the end of the sequence
   *   and is the current element.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for altering the capacity.
   **/
   public void addEnd(double element) 
   {
      if(manyItems == data.length)
         ensureCapacity(manyItems * 2 + 1);
         
      data[manyItems] = element;
      currentIndex = manyItems;
      manyItems++;
   }
   
   /**
   * Makes the last element of the sequence the current element.
   * @precondition
   *   isCurrent() returns true.
   * @postcondition
   *   The last element of the sequence is the current element.
   * @exception IllegalStateException
   *   Indicates there is no current element so setCurrentLast()
   *   cannot be called.
   **/
   public void setCurrentLast()
   {
      if(!isCurrent())
         throw new IllegalStateException("There is no current element.");
      
      currentIndex = manyItems - 1;
   }
   
   /**
   * Returns the nth element of the sequence.
   * @precondition
   *   isCurrent() returns true and the index is within
   *   the bounds of the sequence.
   * @return
   *   The nth element of the sequence.
   * @exception IllegalStateException
   *   Indates there is no current element so getElement()
   *   cannot be called or the index is out of bounds of the
   *   sequence.
   **/
   public double getElement(int index)
   {
      if(!isCurrent())
         throw new IllegalStateException("There is no current element.");
      
      index--;
      if(index < 0 || index >= data.length)
         throw new IllegalStateException("Given index is out of bounds of the sequence.");
      
      return data[index];
   }
   
   /**
   * Make the nth element become the current element.
   * @param index
   *   The index to set the current element at
   * @precondition
   *   isCurrent() returns true and the index is within
   *   the bounds of the sequence.
   * @postcondition
   *   The nth element has become the current element.
   * @exception IllegalStateException
   *   Indicates there is no current element so setCurrent()
   *   cannot be called or the index is out of bounds of the 
   *   sequence.
   **/
   public void setCurrent(int index)
   {
      if(!isCurrent()) 
         throw new IllegalStateException("There is no current element.");
      
      index--; 
      if(index < 0 || index >= data.length)
         throw new IllegalStateException("Given index is out of bounds of the sequence.");
      
      currentIndex = index;
   }
   
   /**
   * Returns true if both sequences have the same length, order,
   * and data. (The current elements may differ.)
   * @return
   *   true (if the objects are equals) or false (if the objects
   *   are not equal)
   **/
   @Override
   public boolean equals(Object s1)
   {
      boolean flag = false;
      
      if(s1 == this)
         return true;
      
      if(!(s1 instanceof DoubleArraySeq)) 
         return false;
         
      return flag;
      
   }
   
   /**
   * Creates a string of all elements separate by a space.
   * @precondition
   *   The sequence is not empty.
   * @return
   *   A string of all elements separated by a space.
   * @exception IllegalStateException
   *   Indicates there is the sequence is empty so the toString()
   *   method cannot be called.
   **/
   @Override
   public String toString() 
   {
      if(data.length < 1)
         throw new IllegalStateException("The sequence is empty.");
      
      String dataString = new String("");
      boolean flag = true;
      int current = currentIndex;
      this.start();
      
      while(flag) {
         dataString += this.getCurrent() + " ";
         this.advance();
         if(currentIndex == manyItems)
            flag = false;
      }
      
      currentIndex = current;
      return dataString;
   }
      
}
           
