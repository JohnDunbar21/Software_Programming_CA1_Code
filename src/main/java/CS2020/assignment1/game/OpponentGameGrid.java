package CS2020.assignment1.game;

public class OpponentGameGrid extends GameGrid {

    public OpponentGameGrid(int width, int height, int numberOfShips) {
        super(width, height, numberOfShips);
    }

    public void printGrid() {
        String[][] tempArray = new String[gameGrid.length][gameGrid[0].length];
        for(int i = 0; i < gameGrid.length; i++) {
            for(int j = 0; j < gameGrid[i].length; j++) {
                if(gameGrid[i][j] == "*") {
                    tempArray[i][j] = ".";
                }
                else {
                    tempArray[i][j] = gameGrid[i][j];
                }
            }
        }
        for(int row = 0; row < tempArray.length; row++) {
            for(int column = 0; column < tempArray[row].length; column++) {
                System.out.print(tempArray[row][column]);
            }
            System.out.println(); // start new line
        }
    }
}