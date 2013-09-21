public class PlaceShips
{
   public PlaceShips()
   {
      
   }
   
    /**
    *  Method placeShip uses the Math.random() method to place the ship randomly either vertically or horizontally
    *  
    *  @param board, shipsize
    *  @return direction, shipSize);
    */
   boolean placeShip(BattleBoard board, int shipSize)
   {
      int boardHeight = board.getHeight();
      int boardWidth  = board.getWidth();
      
      if (shipSize > boardHeight || shipSize > boardWidth) 
          return false;
      
     
      int direction = (Math.random() > 0.5) ? BattleBoard.HORZIZONTAL : BattleBoard.VERTICAL; // uses the ? : operator as a shorcut to the if...else statement
      
      int x, y;
      
      if (direction == BattleBoard.HORZIZONTAL)
      {
         x = (int)(Math.random() * (boardWidth-shipSize+1));
         y = (int)(Math.random() * boardHeight);
      }
      else
      {
         x = (int)(Math.random() * boardWidth);
         y = (int)(Math.random() * (boardHeight-shipSize+1));
      }
     
      
      return board.placeShip(x, y, direction, shipSize);
        
   }
   
}



