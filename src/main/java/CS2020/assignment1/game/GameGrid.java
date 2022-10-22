package CS2020.assignment1.game;

import java.util.Random;

public class GameGrid extends AbstractGameGrid {

    public GameGrid(int width, int height, int numberOfShips) {
        super(width, height, numberOfShips);
        initializeGrid(width, height);
        generateShips(numberOfShips);
        /*
        for(int i = 1; i < numberOfShips; i++) {
            placeShip(ships[i-1]);
        }
        */
    }

    @Override
	public final void initializeGrid(int width, int height) {
        for (int i = 0; i < this.gameGrid.length; i++) {
            for (int j = 0; j < this.gameGrid[i].length; j++) {
                this.gameGrid[i][j] = ".";
            }
        }
    }
    
    // method not working at the moment
	@Override
	public final void placeShip (BattleShip ship) {
        Random random = new Random(); // create Random object
        
        for(int i = 1; i < this.gameGrid.length; i++) { // iterate through the rows of the grid
            for(int j = 1; j < this.gameGrid[i].length; j++) { // iterate through the columns of the grid
                if(ship.shipOrientation == "horizontal") { // check if the orientation is horizontal
                    int[][] shipCoordinatesRandomH = new int[ship.size][2]; // generate an array to store locations
                    int randX = random.nextInt(this.gameGrid.length + 1); // generate a random x-coordinate
                    int randY = random.nextInt(this.gameGrid[i].length + 1); // generate a random y-coordinate
                    for(int z = 0; z < ship.size; z++) { // iterate through the length of the ship
                        this.gameGrid[randX][randY-z] = "*"; // assign a ship marker to the random location
                        shipCoordinatesRandomH[z][0] = randX; // assign an x-location in locations array
                        shipCoordinatesRandomH[z][1] = randY-z; // assign a y-location in locations array
                    }
                    ship.setShipCoordinates(shipCoordinatesRandomH); // update ships array with all coordinates
                }
                else { // if the ship is not horizontal, it can only be vertical
                    int[][] shipCoordinatesRandomV = new int[ship.size][2]; // generate an array to store locations
                    int randX = random.nextInt(this.gameGrid.length + 1); // generate a random x-coordinate
                    int randY = random.nextInt(this.gameGrid[i].length + 1); // generate a random y-coordinate
                    for(int z = 0; z < ship.size; z++) { // iterate through the length of the ship
                        this.gameGrid[randX-z][randY] = "*"; // assign a ship marker to the random location
                        shipCoordinatesRandomV[z][0] = randX-z; // assign an x-location in locations array
                        shipCoordinatesRandomV[z][1] = randY; // assign a y-location in locations array
                    }
                    ship.setShipCoordinates(shipCoordinatesRandomV); // update ships array with all coordinates
                }
            }  
        }
    }
    
	@Override
	public final void generateShips (int numberOfShips) {
        for (int s = 0; s < ships.length; s++) {
            this.ships[s] = new BattleShip("Ship "+(s+1));
        }
    }
}