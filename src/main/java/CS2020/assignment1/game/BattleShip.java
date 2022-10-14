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
    @Override
    public boolean checkAttack (int row,int column){
        return true; // temporary for now
    }
    @Override
	public String getName(){
        return name;
    }
    @Override
	public int getHits() {
        return hits;
    }
    @Override
	public String getShipOrientation() {
        return shipOrientation;
    }
    @Override
	public void setHits(int numberOfHits) {
        this.hits = hits;
    }
    @Override
	public int[][] getShipCoordinates() {
        return shipCoordinates;
    }
    @Override
	public void setShipCoordinates(int [][] coordinates) {
        this.shipCoordinates = coordinates;
    }

}