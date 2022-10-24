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

    @Override
	public final void initializeGrid(int width, int height) {
        for (int i = 0; i < this.gameGrid.length; i++) {
            for (int j = 0; j < this.gameGrid[i].length; j++) {
                this.gameGrid[i][j] = ".";
            }
        }
    }
    
	@Override
	public final void placeShip (BattleShip ship) {
        Random random = new Random(); // create Random object

        int randX = random.nextInt((super.gameGrid.length + 1)/2);
        int randY = random.nextInt((super.gameGrid[0].length + 1)/2);

        int[][] coordinates = new int[3][2];
    
        if(ship.shipOrientation == "horizontal") {
            for(int i = 0; i < super.gameGrid.length; i++) {
                for(int j = 0; j < super.gameGrid[i].length; j++) {
                    if(super.gameGrid[randX][randY] == "."){
                            this.gameGrid[randX][randY] = "*";
                            this.gameGrid[randX][randY+1] = "*";
                            this.gameGrid[randX][randY+2] = "*";
                            coordinates[0][0] = randX;
                            coordinates[0][1] = randY;
                            coordinates[1][0] = randX;
                            coordinates[1][1] = randY+1;
                            coordinates[2][0] = randX;
                            coordinates[2][1] = randY+2;
                    }
                }
            }
        }
        else if(ship.shipOrientation == "vertical") {
            int[][] verticalCoordinates = new int[3][2];
            for(int i = 0; i < super.gameGrid.length; i++) {
                for(int j = 0; j < 3; j++) {
                    if(super.gameGrid[randX][randY] == "."){
                            this.gameGrid[randX][randY] = "*";
                            this.gameGrid[randX+1][randY] = "*";
                            this.gameGrid[randX+2][randY] = "*";
                            coordinates[0][0] = randX;
                            coordinates[0][1] = randY;
                            coordinates[1][0] = randX+1;
                            coordinates[1][1] = randY;
                            coordinates[2][0] = randX+2;
                            coordinates[2][1] = randY;
                    }
                }
            }
        }
        ship.setShipCoordinates(coordinates);
    }
    
	@Override
	public final void generateShips (int numberOfShips) {
        for (int s = 0; s < ships.length; s++) {
            BattleShip battleship = new BattleShip("Ship "+(s+1));
            this.ships[s] = battleship;
            //placeShip(battleship);
        }
    }
}