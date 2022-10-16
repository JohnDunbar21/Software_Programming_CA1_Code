package CS2020.assignment1.game;

public abstract class AbstractGameGrid {
	
	public String [][] gameGrid;
	public BattleShip[] ships;
		
    //populate the grid with "." characters
	public abstract void initializeGrid (int width, int height) ;
	
	//this should place the ship on the grid using "*" symbol
	public abstract void placeShip (BattleShip ship) ;
	
	//this should generate ships for both player and the opponent 
	public abstract void generateShips (int numberOfShips) ;
	
}
