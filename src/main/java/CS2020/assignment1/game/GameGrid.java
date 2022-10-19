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
        Random random = new Random(); // create Random object

        for(int i = 0; i < gameGrid.length; i++) { // iterate through the rows of the grid
            for(int j = 0; j < gameGrid[i].length; j++) { // iterate through the columns of the grid
                if(ship.shipOrientation == "horizontal") { // check if the orientation is horizontal
                    int[][] shipCoordinatesRandomH = new int[ship.size][2]; // generate an array to store locations
                    for(int z = 0; z < ship.size; z++) { // iterate through the length of the ship
                        int randX = random.nextInt(gameGrid.length + 1); // generate a random x-coordinate
                        int randY = random.nextInt(gameGrid[i].length + 1); // generate a random y-coordinate
                        gameGrid[randX][randY-1] = "*"; // assign a ship marker to the random location
                        shipCoordinatesRandomH[z][0] = randX; // assign an x-location in locations array
                        shipCoordinatesRandomH[z][1] = randY; // assign a y-location in locations array
                    }
                    ship.setShipCoordinates(shipCoordinatesRandomH); // update ships array with all coordinates
                }
                else { // if the ship is not horizontal, it can only be vertical
                    int[][] shipCoordinatesRandomV = new int[ship.size][2]; // generate an array to store locations
                    for(int z = 0; z < ship.size; z++) { // iterate through the length of the ship
                        int randX = random.nextInt(gameGrid.length + 1); // generate a random x-coordinate
                        int randY = random.nextInt(gameGrid[i].length + 1); // generate a random y-coordinate
                        gameGrid[randX-1][randY] = "*"; // assign a ship marker to the random location
                        shipCoordinatesRandomV[z][0] = randX; // assign an x-location in locations array
                        shipCoordinatesRandomV[z][1] = randY; // assign a y-location in locations array
                    }
                    ship.setShipCoordinates(shipCoordinatesRandomV); // update ships array with all coordinates
                }
            }
        }

        /*
        // iterate through the ships list
        for(int i = 0; i < ships.length; i++) {
            // assuming it is a square array, these are the random parameters
            int randX = random.nextInt(gameGrid.length + 1);
            int randY = random.nextInt(gameGrid.length + 1);
            // check if the ship is horizontal
            if(ship.shipOrientation == "horizontal") {
                int[][] coordinatesRandom = new int[1][2];
                // iterate through the length of the ship to determine the number of values to create
                for(int j = 1; j < ship.size; j++) {
                    gameGrid[randX][randY+j] = "*";
                    coordinatesRandom[i][j-1] = randX;
                    coordinatesRandom[i][j] = randY;
                }
                ship.setShipCoordinates(coordinatesRandom);
            }
            // if it is not horizontal, then it has to be vertical
            else {
                int[][] coordinatesRandom = new int[1][2];
                for(int j = 1; j < ship.size; j++) {
                    gameGrid[randX+j][randY] = "*";
                    coordinatesRandom[i][j] = randX;
                    coordinatesRandom[i][j-1] = randY;
                }
                ship.setShipCoordinates(coordinatesRandom);
            }
        }
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