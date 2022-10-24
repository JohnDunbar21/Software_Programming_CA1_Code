package CS2020.assignment1.game;

import java.util.Random;

public class GameGrid extends AbstractGameGrid {

    public GameGrid(int width, int height, int numberOfShips) {
        super(width, height, numberOfShips);
        initializeGrid(width, height);
        generateShips(numberOfShips);
        
        for(BattleShip ship: super.ships) {
            placeShip(ship);
        }
        
    }

    /*
    The initializeGrid() method iterates through the rows and columns of the gameGrid
    and sets every value to a '.' String character.
    */
    @Override
	public final void initializeGrid(int width, int height) {
        for (int i = 0; i < this.gameGrid.length; i++) { // iterate through the rows of the array
            for (int j = 0; j < this.gameGrid[i].length; j++) { // iterate through the columns of the array
                this.gameGrid[i][j] = "."; // assign each value a '.' String character
            }
        }
    }
    
    /*
    The placeShip() method takes a BattleShip object as a parameter and assigns it random x,y
    coordinates that positions it on the gameGrid.

    Initially, a for-loop to assign the values to the coordinates integer array was attempted,
    but due to technical difficulties, decided to settle on manually inserting each value into 
    its respective row-column coordinate location.

    This method utilises the setShipCoordinates method defined in the BattleShip class, allowing
    the ship's coordinates to be updated once the computations have been finalised.
    */
	@Override
	public final void placeShip (BattleShip ship) {
        Random random = new Random(); // create Random() object

        int randX = random.nextInt((super.gameGrid.length + 1)/2); // generate a value that is half of the gameGrid array's length
        int randY = random.nextInt((super.gameGrid[0].length + 1)/2); // generate a value that is half of the length of the gameGrid array's columns length

        int[][] coordinates = new int[3][2]; // create a new integer array that is 3x2 to contain three sets of x,y coordinates
    
        if(ship.shipOrientation == "horizontal") { // check if the ship is horizontal
            for(int i = 0; i < super.gameGrid.length; i++) { // iterate through the rows of the gameGrid
                for(int j = 0; j < super.gameGrid[i].length; j++) { // iterate through the columns of the gameGrid
                    if(super.gameGrid[randX][randY] == "."){ // check if the value stored at that index is a '.' character
                            this.gameGrid[randX][randY] = "*"; // assign '*' to the index
                            this.gameGrid[randX][randY+1] = "*"; // assign '*' to the index
                            this.gameGrid[randX][randY+2] = "*"; // assign '*' to the index
                            coordinates[0][0] = randX; // update the ship's coordinates in the coordinates array
                            coordinates[0][1] = randY; // update the ship's coordinates in the coordinates array
                            coordinates[1][0] = randX; // update the ship's coordinates in the coordinates array
                            coordinates[1][1] = randY+1; // update the ship's coordinates in the coordinates array
                            coordinates[2][0] = randX; // update the ship's coordinates in the coordinates array
                            coordinates[2][1] = randY+2; // update the ship's coordinates in the coordinates array
                    }
                }
            }
        }
        else if(ship.shipOrientation == "vertical") { // check if the ship is horizontal
            for(int i = 0; i < super.gameGrid.length; i++) { // iterate through the rows of the gameGrid
                for(int j = 0; j < 3; j++) { // iterate through the rows of the gameGrid
                    if(super.gameGrid[randX][randY] == "."){ // check if the value stored at that index is a '.' character
                            this.gameGrid[randX][randY] = "*"; // assign '*' to the index
                            this.gameGrid[randX+1][randY] = "*"; // assign '*' to the index
                            this.gameGrid[randX+2][randY] = "*"; // assign '*' to the index
                            coordinates[0][0] = randX; // update the ship's coordinates in the coordinates array
                            coordinates[0][1] = randY; // update the ship's coordinates in the coordinates array
                            coordinates[1][0] = randX+1; // update the ship's coordinates in the coordinates array
                            coordinates[1][1] = randY; // update the ship's coordinates in the coordinates array
                            coordinates[2][0] = randX+2; // update the ship's coordinates in the coordinates array
                            coordinates[2][1] = randY; // update the ship's coordinates in the coordinates array
                    }
                }
            }
        }
        ship.setShipCoordinates(coordinates); // sets the coordinates of the ship based on the final coordinates
    }
    
    /*
    This method generates BattleShip objects based on the number of ships being passed
    as a parameter.

    It uses concatenation to formulate the name of the object, and is added to the ships
    list contained in the AbstractGameGrid class as an instance variable.
    */
	@Override
	public final void generateShips (int numberOfShips) {
        for (int s = 0; s < ships.length; s++) { // iterate through the length of the ships array
            BattleShip battleship = new BattleShip("Ship "+(s+1)); // create a new BattleShip object
            this.ships[s] = battleship; // assign the BattleShip object to the current index of the ships array
        }
    }
}