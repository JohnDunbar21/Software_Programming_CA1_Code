package CS2020.assignment1.game;

import java.util.Random;

public class BattleShip extends AbstractBattleShip {
    int size = 3; // default size value

    public BattleShip(String name) {
        // set the name of the name class attribute to the passed parameter
        this.name = name;
        Random orientation = new Random(); // create a new Random object
        int selector = orientation.nextInt(2); // upperbound value is n-1
        try {
            if (selector == 0) { // selector for if the ship is vertical
                this.shipOrientation = "vertical";
            } else if (selector == 1) { // selector for if the ship is horizontal
                this.shipOrientation = "horizontal";
            }
        } catch (Exception e) { // basic error handling: uneccessary, but implemented in the event of a fatal error
            System.out.println("FATAL ERROR: IMPORTED RANDOM OBJECT NOT FUNCTIONING AS EXPECTED");
        }
    }

    /*
    The checkAttack() method takes two integer parameters: row and column.

    The purpose of this method is to iterate through the two-dimensional array that
    stores the BattleShip object's location on the gameGrid. This is done by comparing
    the value stored at [0][0] and [0][1], and can functionally iterate through an nxm array.

    When comparing the row and column values to the stored shipCoordinates array values, if they
    match, then the loop progresses to check if the ship being investigated has less than 3 hits
    as this is the maximum amount of damage a single BattleShip object can take.

    Once this condidition is satisfied, the hit counter is incremented by 1, and the values of that
    ship's position are changed to -1,-1 as they will no longer be accessed by the game (a user will not be
    typing -1,-1 into the coordinates selector).

    If the above conditions are not met, the function automatically fails and returns a false boolean value.
    */
    @Override
    public boolean checkAttack (int row,int column){
        for(int i = 0; i < this.shipCoordinates.length; i++) { // iterate through the rows of the shipCoordinates array
            for(int j = 1; j < this.shipCoordinates[i].length; j++) { // iterate through the columns of the shipCoordinates array
                if(this.shipCoordinates[i][j-1] == row) { // check if the value stored in the shipCoordinates array is equal to the row input
                    if(this.shipCoordinates[i][j] == column) { // check if the value stored in the inner shipCoordinates array is equal to the column input
                        if(this.hits < 3) { // check if the hit counter is less than 3
                            this.hits += 1; // increment the hit counter by 1
                            this.shipCoordinates[i][j-1] = -1; // reassign the x-coordinate of the current ship's position
                            this.shipCoordinates[i][j] = -1; // reassign the y-coordinate of the current ship's position
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    // getter method for the ship's name
    @Override
	public String getName(){
        return this.name;
    }
    // setter method for the ship's hit counter
    @Override
	public int getHits() {
        return this.hits;
    }
    // getter method for the ship's orientation
    @Override
	public String getShipOrientation() {
        return this.shipOrientation;
    }
    // setter method for the number of hits of the current ship object
    @Override
	public void setHits(int numberOfHits) {
        this.hits = numberOfHits;
    }
    // getter method for the coordinates of the current ship object
    @Override
	public int[][] getShipCoordinates() {
        return this.shipCoordinates;
    }
    // setter method for the coordinates of the current ship object
    @Override
	public void setShipCoordinates(int [][] coordinates) {
        this.shipCoordinates = coordinates;
    }

}