import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player
{
   public static final int HIT = 1;
   public static final int MISS = 2;
   public static final int INVALID = 3;
   public static final int USED = 4;
   public static final int QUIT = 5;

   public Player()
   {
      
   }
   
   /**
    *  Method shoot takes the input of the user and places the shot on the board
    *  
    *  @param board
    *  @return result of the users input and whether it was miss or hit
    **/
   public int shoot(BattleBoard board)
   {
     
      // Ask the user to enter the x coordinate.
      int xCoord = receiveCoordinate("x");  
      
      if (xCoord == -1)
    	  return QUIT;
      
    	 
      
      // Ask the user to enter the y coordinate.
      int yCoord = receiveCoordinate("y");  
      
      if ( yCoord == -1 )
    	  return QUIT;
      
    	 
      switch (board.shootShip(xCoord, yCoord))
      {
         case BattleBoard.MISS: 
        	 return MISS;
         case BattleBoard.HIT:  
        	 return HIT;
         case -2:                               
        	 return USED;
      }
      
      return INVALID;
   }
   
   
   private int receiveCoordinate(String coordinate)
   {
      BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

      System.out.print("Please enter the " + coordinate + " coordinate 0-9 ('Q' to quit):");
      
      do
      {
         try 
         {
            String characterInput = keyboard.readLine();
         
            if (characterInput.length() > 0)
            {
               if ( Character.toUpperCase(characterInput.charAt(0)) == 'Q' ) 
            	   return -1; 
         
               int coord = Integer.parseInt(characterInput);
            
               return coord;
            }
	      }
	      catch ( IOException e )
	      {
	         System.out.println("IOException occurred. Aborting.");
	         
	         System.exit(1);
	      }
	      catch ( NumberFormatException e1 )
	      {
            System.out.print("Please enter a number or 'Q' to quit:");
	      }
         
      	  }
      while ( true ) ;
      
       
   }      
}