package CS2020.assignment1.game;

public class PlayerGameGrid extends GameGrid {

    public PlayerGameGrid(int width, int height, int numberOfShips) {
        super(width, height, numberOfShips); // initialises a GameGrid constructor with the passed parameters
    }

    /*
    This printGrid() method iterates through the player's gameGrid and prints
    each entry. This will show all characters including 'X', '%', and '.'.
    */
    public void printGrid() {
        for(int i = 0; i < gameGrid.length; i++) { // iterate through the rows of the array
            for(int j = 0; j < gameGrid[i].length; j++) { // iterate through the columns of the array
                System.out.print(gameGrid[i][j]+" "); // print each item in the array
            }
            System.out.println(); // start new line
        }
    }
}