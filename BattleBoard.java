public class BattleBoard
{
       private int theWidth;
       private int theHeight;
       private int[][] board;
       private int battleShip;
       private int numberOfShots;
   
       public static final int  BLANK = 0;
       public static final int  SHIP  = 1;
       public static final int  MISS  = 2;
       public static final int  HIT   = 3;
       public static final int  HORZIZONTAL = 0;
       public static final int  VERTICAL = 1;

   
   
   /**
    *  The constructor creates the board and sets all coord inates to BLANK.
    * 
    */
   public BattleBoard(int width, int height)
   {
      if ( width  < 0 || width  > 40 )
      {
          width  = 40;
      }
      if ( height < 0 || height > 40 )
      {
          height = 40;
      }
      
      theWidth  = width;
      theHeight = height;

      board = new int[height][width];
      
      for ( int i = 0; i < height; i++ )
      {
         for ( int j = 0; j < width; j++ )
         {
            board[i][j] = BLANK;        
         }
      }
      battleShip = 0;
      numberOfShots  = 0;

      System.out.println("The game board size is: " + height + ", " + width);
   }
   
   
   /**
    *  Method placeShip places the ship at specified coordinate.
    *  @param x, y, direction, ship
    *  @return true/false
    **/
   
   public boolean placeShip(int x, int y, int direction, int ship)
   {
     

      if ( x >= theWidth || y >= theHeight ) 
      {
          return false;
      }
      
      if (direction == HORZIZONTAL) 
      { 
          if (x + ship > theWidth)
              return false;
      }
      
      else if ( y + ship > theHeight)
          return false; 
       
         
      
   
     battleShip = ship;
      
      for ( int i = 0; i < ship; i++ )
      {
         board[y][x] = SHIP;
         
       
         
       if (direction == HORZIZONTAL)
           x++;
       else
           y++;
      }
      
      return true; 
   }
   
   /**
    *  Method shootShip is used to take a shot at the ship. A message is then displayed whether the shot was a 
    *  hit, miss, already taken, or out of the board range.
    *  
    *  @param x,y
    *  @return board[y][x];
    */
   
   
   public int shootShip(int x, int y)
   {
      if ( x >= theWidth || y >= theHeight ) 
          return -1;
      
      if ( board[y][x] == HIT || board[y][x] == MISS ) 
          return -2;
      
      if ( board[y][x] == SHIP ) 
      { 
          board[y][x] = HIT;
          numberOfShots++; 
      }
            
      else
          board[y][x] = MISS;
      
      
      return board[y][x];
      
   }
   
    /**
    *  Method shootShip is used to take a shot at the ship. A message is then displayed whether the shot was a 
    *  hit, miss, already taken, or out of the board range.
    *  
    *  @param none
    *  @return true/false
    */
   public boolean hasShipBeenSunk()
   {
      return (boolean)(numberOfShots == battleShip);
   }
   
    /**
    *  
    *  
    *  @param none
    *  @return none
    */
   public int getWidth()  
   {
       return theWidth;
   }
    
   /**
    *  
    *  
    *  @param none
    *  @return none
    */
   public int getHeight() 
   {
       return theHeight; 
       
   }


}
