package CS2020.assignment1.game;

import java.util.Random;

public class BattleShip extends AbstractBattleShip {

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

    /*
    Needing to implement Task 1.3 properly
    */
    @Override
    public boolean checkAttack (int row,int column){
        
        /*
        for (int i = 0; i < shipCoordinates.length; i++) {
            for (int j = 0; j < shipCoordinates[i].length; j++) {
                if (shipCoordinates[i][j] == column) {
                    if (hits < 3){
                        hits += 1;
                        return true;
                    }
                }
            }
        }
        return false;
        */
        /*
        if (shipCoordinates[row - 1][column - 1] != '.') {
            if (hits < 3) {
                hits += 1;
                return true;
            } else {
                return false;
            }
        }
        return false;
        */
        return false; // placeholder return statement
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