package CS2020.assignment1.game;

import java.util.Random;

public class BattleShip extends AbstractBattleShip {
    int size = 3; // default size value

    public BattleShip(String name) {
        // set the name of the name class attribute to the passed parameter
        this.name = name;
        Random orientation = new Random();
        int selector = orientation.nextInt(2); // upperbound value is n-1
        try {
            if (selector == 0) {
                this.shipOrientation = "vertical";
            } else if (selector == 1) {
                this.shipOrientation = "horizontal";
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Try again...");
        }
    }

    @Override
    public boolean checkAttack (int row,int column){
        for(int i = 0; i < this.shipCoordinates.length; i++) {
            for(int j = 1; j < this.shipCoordinates[i].length; j++) {
                if(this.shipCoordinates[i][j-1] == row) {
                    if(this.shipCoordinates[i][j] == column) {
                        if(this.hits < 3) {
                            this.hits += 1;
                            this.shipCoordinates[i][j-1] = -1;
                            this.shipCoordinates[i][j] = -1;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    @Override
	public String getName(){
        return this.name;
    }
    @Override
	public int getHits() {
        return this.hits;
    }
    @Override
	public String getShipOrientation() {
        return this.shipOrientation;
    }
    @Override
	public void setHits(int numberOfHits) {
        this.hits = numberOfHits;
    }
    @Override
	public int[][] getShipCoordinates() {
        return this.shipCoordinates;
    }
    @Override
	public void setShipCoordinates(int [][] coordinates) {
        this.shipCoordinates = coordinates;
    }

}