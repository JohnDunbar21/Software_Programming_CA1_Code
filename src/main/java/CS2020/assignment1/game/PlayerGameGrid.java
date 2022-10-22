package CS2020.assignment1.game;

public class PlayerGameGrid extends GameGrid {

    public PlayerGameGrid(int width, int height, int numberOfShips) {
        super(width, height, numberOfShips);
    }

    public void printGrid() {
        for(int i = 0; i < gameGrid.length; i++) {
            for(int j = 0; j < gameGrid[i].length; j++) {
                System.out.print(gameGrid[i][j]+" ");
            }
            System.out.println(); // start new line
        }
    }
}