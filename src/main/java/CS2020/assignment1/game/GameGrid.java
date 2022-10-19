package CS2020.assignment1.game;

import java.util.Random;

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
	@Override
	public void placeShip (BattleShip ship) {
        // fill in later
    }
	@Override
	public void generateShips (int numberOfShips) {
        for (int s = 0; s < ships.length; s++) {
            this.ships[s] = new BattleShip("Ship "+(s+1));
        }
    }
}