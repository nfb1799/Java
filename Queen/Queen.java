class Queen {
   
   // Invariant of the Queen class
   //    1. The row of the queen
   //    2. The column of the queen
   private int row;
   private int column;
   
   /**
   * Initialize a new Queen with row and column set to 0
   * @postcondition
   *     a new Queen is created at row 0, column 0
   **/
   public Queen() {
      row = 0;
      column = 0;
   }
   
   /**
   * Initialize a new Queen at a given location
   * @param r
   *     the row the Queen is placed at
   * @param c
   *     the column the Queen is placed at
   * @postcondition
   *     a new Queen is created at the given location
   **/
   public Queen(int r, int c) {
      row = r;
      column = c;
   }
   
   /**
   * Returns the row of the current Queen
   * @return row
   *     the row of the current Queen
   **/
   public int getRow() {
      return row;
   }
   
   /**
   * Returns the column of the current Queen
   * @return column
   *     the column of the current Queen
   **/
   public int getColumn() {
      return column;
   }
   
   /**
   * Set the row of the current Queen
   * @param n
   *     the row to be set
   * @postcondition
   *     the current Queen is placed on a new row
   **/
   public void setRow(int n) {
      row = n;
   }
   
   /**
   * Set the column of the current Queen
   * @param n
   *     the column to be set
   * @postcondition
   *     the current Queen is placed on a new column
   **/
   public void setColumn(int n) {
      column = n;
   }
   
   /**
   * Prints the location of the current Queen
   * @return str
   *     the location of the Queen as a string
   **/
   public String toString() {
      String str = "row = " + row + ", column = " + column;
      return str;
   }
   
   /**
   * Checks if the current Queen conflicts with a given Queen
   * @param check
   *     the Queen that is checked against
   * @return 
   *     true (if there is a conflict) or false (if there is no conflict)
   **/
   public boolean conflict(Queen check) {
      boolean ans = false;
      if(row == check.row)
         ans = true;
      
      if(column == check.column)
         ans = true;
         
      for(int i = 0; i < 20; i++) {
         if(row == check.row + i && column == check.column + i)
            ans = true;
            
         if(row == check.row - i && column == check.column - i)
            ans = true;
            
         if(row == check.row + i && column == check.column - i)
            ans = true;
            
         if(row == check.row - i && column == check.column + i)
            ans = true;
      }
      
      if(row == check.row && column == check.column)
         ans = false; 
      
      if(column < 0)
         ans = false;    
           
      return ans;
   }
}