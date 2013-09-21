public class Battleship
{
   
   BattleBoard theBoard;
   PlaceShips theShips;
   Player theUser;

   
   
   public Battleship()
   {
      theBoard = new BattleBoard(10, 10);
      theShips = new PlaceShips();
      theUser  = new Player();
      
      System.out.println("Get ready to play!!");
   }

    /**
    *  Method playGame initializes the game status, number of shots and ship size, then goes through a switch statment using the shoot method to determine the output
    * 
    *  
    *  @param none
    *  @return the output from the switch statement
    */
   public void playGame()
   {
      
	   boolean gameOn = true;
	   int numShots = 0;
	   int shipSize = 4;
      
     
	  if (!theShips.placeShip(theBoard, shipSize))
      {
         System.out.println("Error placing ship!");
         return;
         
         
      }
      
      
	  while ( gameOn )
      {
         switch ( theUser.shoot(theBoard) )
         {
            case Player.HIT:
            	numShots++;
                System.out.println("Hit!!");
                if (theBoard.hasShipBeenSunk())
                {
                   System.out.println("You've sunk my battleship!!");
                   System.out.println("It took you " + numShots + " turns.");
                   gameOn = false;
                }
                break;
            	     
            case Player.MISS:
            	 System.out.println("Miss!!");
                 numShots++;
                 break;
            	       
                
            case Player.INVALID:
            	 System.out.println("You have specified an invalid coordinate.");
                 break;
            	
                 
            case Player.USED:
            	 System.out.println("That coordinate has already been used.");
                 break;
            	      
                 
            case Player.QUIT:
            	 System.out.println("Quittng game.");
                 gameOn = false;     
                 break;
            	        
                
         }
   
      }
   
   }
   
   /*
    * The main method that will be used to run the game
    */
   public static void main(String[] args)
	{
		Battleship theBattleshipGame = new Battleship();
	      
		theBattleshipGame.playGame();
		
	
	      
	 }

}
