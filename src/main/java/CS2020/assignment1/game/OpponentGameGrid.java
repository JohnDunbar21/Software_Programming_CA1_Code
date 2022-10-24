package CS2020.assignment1.game;

public class OpponentGameGrid extends GameGrid {

    public OpponentGameGrid(int width, int height, int numberOfShips) {
        super(width, height, numberOfShips); // initialises the opponent's grid with the constructor parameters
    }

    /*
    The printGrid() method iterates through the opponent's grid and filters out the '*' characters.
    There is a temporary array that stores these values and is iterated through when printing the
    array: this is to prevent and '*' characters being printed.
    */
    public void printGrid() {
        String[][] tempArray = new String[gameGrid.length][gameGrid[0].length]; // initialise a temporary array
        for(int i = 0; i < gameGrid.length; i++) { // iterate through the rows of the gameGrid
            for(int j = 0; j < gameGrid[i].length; j++) { // iterate through the columns of the gameGrid
                if(gameGrid[i][j] == "*") { // check if the character in that location is a '*' character
                    tempArray[i][j] = "."; // add a '.' to the tempArray to hide the '*' character
                }
                else {
                    tempArray[i][j] = gameGrid[i][j]; // add the other characters to the tempArray
                }
            }
        }
        for(int row = 0; row < tempArray.length; row++) { // iterate through the rows of the tempArray
            for(int column = 0; column < tempArray[row].length; column++) { // iterate through the columns of the tempArray
                System.out.print(tempArray[row][column]+" "); // print the row of data
            }
            System.out.println(); // start new line
        }
    }
}