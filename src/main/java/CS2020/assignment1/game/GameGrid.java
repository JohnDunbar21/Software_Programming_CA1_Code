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
                gameGrid[i][j] = ".";
            }
        }
    }
	@Override
	public void placeShip (AbstractBattleShip ship) {
        // fill in later
    }
	@Override
	public void generateShips (int numberOfShips) {
        for (int s = 1; s <= numberOfShips; s++) {
            ships[s] = "Ship "+s;
        }
    }
}