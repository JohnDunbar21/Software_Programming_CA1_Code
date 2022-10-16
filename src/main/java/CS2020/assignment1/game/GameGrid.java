package CS2020.assignment1.game;

import java.util.Random;

public class GameGrid extends AbstractGameGrid {

    public GameGrid(int width, int height, int numberOfShips) {
        initializeGrid(width, height);
        generateShips(numberOfShips);
    }
    @Override
	public void initializeGrid(int width, int height) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
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
        for (int s = 0; s < numberOfShips; s++) {
            this.ships[s] = new BattleShip("Ship "+s);
        }
    }
}