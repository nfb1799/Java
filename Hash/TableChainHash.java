/*
   File: TableChainHash.java
   Author: Michael Main
   Co-Author: Nik Barbero
   Date: 5/19/2019
   Description: Table class that uses chained hashing
*/
public class TableChainHash< K , E >
{
   // Invariant of the Table class:
   //   1. The number of items in the table is in the instance variable manyItems.
   //   2. The preferred location for an element with a given key is at index
   //      hash(key). If a collision occurs, then the element itself is placed
   //      at the end of the linked list at data[i]. The corresponding key is 
   //      placed at the end of the linked list at keys[i].
   //   3. An index i that is not currently used has data[i] and key[i] set to
   //      null.
   //   4. If an index i has been used at some point (now or in the past), then
   //      hasBeenUsed[i] is true; otherwise it is false.
   //   5. The number of collisions for each item placed is tracked by manyCollisions.
   //      manyCollisions tracks the collisions by a specific placement rather than
   //      collisions at a certain index.
   private int manyItems;
   private Node<K>[ ] keys;
   private Node<E>[ ] data;
   private Node<K> keyCursor;
   private Node<E> dataCursor;
   private boolean[ ] hasBeenUsed; 
   private int[ ] manyCollisions;  

   /**
   * Initialize an empty table with a specified capacity.
   * @param <CODE>capacity</CODE>
   *   the capacity for this new open-address hash table
   * <dt><b>Postcondition:</b><dd>
   *   This table is empty and has the specified capacity.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for the specified capacity. 
   **/   
   public TableChainHash(int capacity)
   {
      // The manyItems instance variable is automatically set to zero.
      // which is the correct initial value. The three arrays are allocated to
      // be the specified capacity. The boolean array is automatically
      // initialized to falses, and the other two arrays are automatically
      // initialized to all null.
      if (capacity <= 0)
         throw new IllegalArgumentException("Capacity is negative");
      keys = (Node<K>[ ]) new Node[capacity];
      data = (Node<E>[ ]) new Node[capacity];
      hasBeenUsed = new boolean[capacity];
      manyCollisions = new int[capacity];
   }
   
   
   /**
   * Determines whether a specified key is in this table.
   * @param <CODE>key</CODE>
   *   the non-null key to look for
   * <dt><b>Precondition:</b><dd>
   *   <CODE>key</CODE> cannot be null.
   * @return
   *   <CODE>true</CODE? (if this table contains an object with the specified 
   *   key); <CODE>false</CODE> otherwise. Note that <CODE>key.equals( )</CODE>
   *   is used to compare the <CODE>key</CODE> to the keys that are in the 
   *   table.
   * @exception NullPointerException
   *   Indicates that <CODE>key</CODE> is null.
   **/
   public boolean containsKey(K key)
   {
      return findIndex(key) != -1;
   }
   
   
   private int findIndex(K key)
   // Postcondition: If the specified key is found in the table, then the return
   // value is the index of the specified key. Otherwise, the return value is -1.
   {
      int i = hash(key);
      keyCursor = keys[i];
      boolean found = false;
      
      while(keyCursor != null && !found) {
         if(keyCursor.getData().equals(key)) 
            found = true;
         else
            keyCursor = keyCursor.getLink();   
      }
      
      if(found)   
         return i;
      else
         return -1;
   }
      
   
   /** Retrieves an object for a specified key.
   * @param <CODE>key</CODE>
   *   the non-null key to look for
   * <dt><b>Precondition:</b><dd>
   *   <CODE>key</CODE> cannot be null.
   * @return
   *   a reference to the object with the specified <CODE>key</CODE (if this 
   *   table contains an such an object);  null otherwise. Note that 
   *   <CODE>key.equals( )</CODE> is used to compare the <CODE>key</CODE>
   *   to the keys that are in the table.
   * @exception NullPointerException
   *   Indicates that <CODE>key</CODE> is null.
   **/
   public E get(K key)
   {
      int index = findIndex(key);
      
      if (index == -1)
         return null;
      else {
         keyCursor = keys[index];
         dataCursor = data[index];
         while(!keyCursor.getData().equals(key) && keyCursor.getLink() != null) {
            keyCursor = keyCursor.getLink();
            dataCursor = dataCursor.getLink();
         }
      }
      return (E) dataCursor.getData();   
   }
   
   
   private int hash(Object key)
   // The return value is a valid index of the tables arrays. The index is
   // calculated as the remainder when the absolute value of the keys
   // hash code is divided by the size of the tables arrays.
   {
      return Math.abs(key.hashCode( )) % data.length;
   }
   
   
   private int nextIndex(int i)
   // The return value is normally i+1. But if i+1 is data.length, then the 
   // return value is zero instead.
   {
      if (i+1 == data.length)
         return 0;
      else
         return i+1;
   }
   
   
   /**
   * Add a new element to this table, using the specified key.
   * @param <CODE>key</CODE>
   *   the non-null key to use for the new element
   * @param <CODE>element</CODE>
   *   the new element thats being added to this table
   * <dt><b>Precondition:</b><dd>
   *   If there is not already an element with the specified <CODE>key</CODE>,
   *   then this tables size must be less than its capacity 
   *   (i.e., <CODE>size() < capacity()</CODE>). Also, neither <CODE>key</CODE>
   *   nor </CODE>element</CODE> is null.
   * <dt><b>Postcondition:</b><dd>
   *   If this table already has an object with the specified <CODE>key</CODE>,
   *   then that object is replaced by </CODE>element</CODE>, and the return 
   *   value is a reference to the replaced object. Otherwise, the new 
   *   </CODE>element</CODE> is added with the specified <CODE>key</CODE>
   *   and the return value is null.
   * @exception IllegalStateException
   *   Indicates that there is no room for a new object in this table.
   * @exception NullPointerException
   *   Indicates that <CODE>key</CODE> or <CODE>element</CODE> is null.   
   **/
   public E put(K key, E element)
   {
      int index = findIndex(key);
      
      if (index != -1)
      {  // The key is already in the table.
         dataCursor = data[index];
         while(dataCursor.getLink() != null)
            dataCursor = dataCursor.getLink();
         return dataCursor.getData();
      }
      else if (manyItems < data.length)
      {  // The key is not yet in this Table.
         index = hash(key);
         keyCursor = keys[index];
         dataCursor = data[index];
         if(keyCursor == null) {
            keys[index] = new Node<K>(key, null);
            data[index] = new Node<E>(element, null);
            hasBeenUsed[index] = true;
            manyItems++;
         } else {
            manyCollisions[index]++;
            while (keyCursor.getLink() != null) {
               manyCollisions[manyItems]++;
               keyCursor = keyCursor.getLink();
               dataCursor = dataCursor.getLink();
            }
            keyCursor.addNodeAfter(key);
            dataCursor.addNodeAfter(element);
            hasBeenUsed[index] = true;
            manyItems++;
            return null;
         }
      }
      else
      {  // The table is full.
         throw new IllegalStateException("Table is full.");
      }
      return null;
   }
      
   
   /**
   * Removes an object for a specified key.
   * @param <CODE>key</CODE>
   *   the non-null key to look for
   * <dt><b>Precondition:</b><dd>
   *   <CODE>key</CODE> cannot be null.
   * <dt><b>Postcondition:</b><dd>
   *   If an object was found with the specified </CODE>key</CODE>, then that
   *   object has been removed from this table and a copy of the removed object
   *   is returned; otherwise, this table is unchanged and the null reference
   *   is returned.  Note that 
   *   <CODE>key.equals( )</CODE> is used to compare the <CODE>key</CODE>
   *   to the keys that are in the table.
   * @exception NullPointerException
   *   Indicates that </CODE>key</CODE> is null.
   **/
   public E remove(K key)
   {
      int index = findIndex(key);
      E answer = null;
      
      if (index != -1)
      {
         keyCursor = keys[index];
         dataCursor = data[index];
         while(!keyCursor.getData().equals(key)) {
            keyCursor = keyCursor.getLink();
            dataCursor = dataCursor.getLink();  
         }
         answer = dataCursor.getData();
         keyCursor = null;
         dataCursor = null;
         manyItems--;
      }
      
      return answer;
   }
   
   /**
   * Returns the number of collisions for a certain placement
   * @param index
   *  The index of the placement 
   * @return
   *  The number of collisions caused by a certain placement
   **/
   public int getCollisions(int index) 
   {
      return manyCollisions[index];
   }
        
}
           
