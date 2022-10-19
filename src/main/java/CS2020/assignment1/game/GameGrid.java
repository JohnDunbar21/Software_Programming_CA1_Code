package CS2020.assignment1.game;

import java.util.Random;
import java.lang.Math;

public class GameGrid extends AbstractGameGrid {

    public GameGrid(int width, int height, int numberOfShips) {
        super(width, height, numberOfShips);
        initializeGrid(width, height);
        generateShips(numberOfShips);
    }
    @Override
	public void initializeGrid(int width, int height) {
        //this.gameGrid = new String[width][height];
        for (int i = 0; i < this.gameGrid.length; i++) {
            for (int j = 0; j < this.gameGrid[i].length; j++) {
                this.gameGrid[i][j] = ".";
            }
        }
    }
    
    // method not working at the moment
	@Override
	public void placeShip (BattleShip ship) {
        /*
        // create a for-loop to iterate throught the number of ships created
        for(int i = 0; i < ships.length; i++) {
            // check if the ship is horizontal
            if(ship.shipOrientation == "horizontal") {
                // generate a random numbers for the x and y coordinates
                int xCoordinate = (int) (Math.random() * (this.gameGrid.length)); // sets the x-coordinate
                int yCoordinate = (int) (Math.random() * (this.gameGrid.length - ship.size)); // sets the y-coordinate
                
                for(int j = 0; j < ship.size; j++) {
                    this.gameGrid[xCoordinate][yCoordinate+j] = "*";
                    ship.setShipCoordinates(new int[xCoordinate][yCoordinate+j]);
                }
            }
            // check if the ship is vertical
            else if (ship.shipOrientation == "vertical") {
                // generate a random numbers for the x and y coordinates
                int xCoordinate = (int) (Math.random() * (this.gameGrid.length - ship.size)); // sets the x-coordinate
                int yCoordinate = (int) (Math.random() * (this.gameGrid.length)); // sets the y-coordinate
                
                for(int z = 0; z < ship.size; z++) {
                    this.gameGrid[xCoordinate+z][yCoordinate] = "*";
                    ship.setShipCoordinates(new int[xCoordinate+z][yCoordinate]);
                }
            }
        }
        */
    }
    
	@Override
	public void generateShips (int numberOfShips) {
        for (int s = 0; s < ships.length; s++) {
            this.ships[s] = new BattleShip("Ship "+(s+1));
        }
    }
}