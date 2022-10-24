package CS2020.assignment1.game;

import java.lang.Integer;
import java.util.Random;

public class Game implements GameControls {

    public PlayerGameGrid player;
    public OpponentGameGrid opponent;

    public Game (int width, int height, int numberOfShips) {
        this.player = new PlayerGameGrid(width, height, numberOfShips);
        this.opponent = new OpponentGameGrid(width, height, numberOfShips);
    }

    public void playRound (String input) {
        
        String[] splitCoordinates = input.split(",");
        int xCoordinates = 0; // initialise local variable for x-coordinate
        int yCoordinates = 0; // initialise local variable for y-coordinate

        if(splitCoordinates.length == 2) {
            xCoordinates = Integer.parseInt(splitCoordinates[0]); // retrieves the x-coordinate from input
            yCoordinates = Integer.parseInt(splitCoordinates[1]); // retrieves the y-coordinate from input
        }
        else {
            System.out.println("Your input is in an invalid format: enter coordinates in the format 'x,y'.");
        }

        System.out.println("Player is attacking");

        // iterate through opponent's ship array
        for(int ship = 0; ship < opponent.ships.length; ship++) {
            if(opponent.ships[ship].checkAttack(xCoordinates, yCoordinates) == true) {
                opponent.gameGrid[xCoordinates][yCoordinates] = "X";
                System.out.println("HIT "+opponent.ships[ship].name+"!!!");
            }
            else {
                if(opponent.gameGrid[xCoordinates][yCoordinates] != "X"){
                    opponent.gameGrid[xCoordinates][yCoordinates] = "%";
                }
            }
        }

        if(opponent.gameGrid[xCoordinates][yCoordinates] == "%") {
            System.out.println("MISS!!!");
        }

        System.out.println("Opponent is attacking");

        Random random = new Random();

        int xCoord = random.nextInt(player.gameGrid.length);
        int yCoord = random.nextInt(player.gameGrid[0].length);

        for(int ship = 0; ship < player.ships.length; ship++) {
            if(player.ships[ship].checkAttack(xCoord, yCoord) == true) {
                player.gameGrid[xCoord][yCoord] = "X";
                System.out.println("HIT "+player.ships[ship].name+"!!!");
            }
            else {
                if(player.gameGrid[xCoord][yCoord] != "X"){
                    player.gameGrid[xCoord][yCoord] = "%";
                }
            }
        }
        if(player.gameGrid[xCoord][yCoord] == "%") {
            System.out.println("MISS!!!");
        }
        System.out.println("Player's Grid");
        player.printGrid();

        System.out.println("Opponent's Grid");
        opponent.printGrid();
    }
	
	public boolean checkVictory () {
        /*
        for(int ship = 0; ship < player.ships.length; ship++) {
            if(player.ships[ship].hits < 3 && opponent.ships[ship].hits == 3) {
                System.out.println("You have won!");
                return true;
            }
        }
        System.out.println("You have lost!");
        return false;
        */
        
        int playerHits = 3 * player.ships.length;
        int opponentHits = 3 * opponent.ships.length;
        for(int ship = 0; ship < opponent.ships.length; ship++) {
            int opponenthit = opponent.ships[ship].getHits();
            if(opponenthit > 0) {
                opponentHits -= opponenthit;
            }
        }
        for(int ship = 0; ship < player.ships.length; ship++) {
            int playerhit = player.ships[ship].getHits();
            if(playerhit > 0) {
                playerHits -= playerhit;
            }
        }

        if(playerHits == 0) {
            System.out.println("You have lost!");
            return false;
        }
        else if(opponentHits == 0) {
            System.out.println("You have won!");
        }
        return false;
    }
	
	public void exitGame (String input) {
        String userInput = input.toLowerCase(); // ensures that the command is in lower case
        if(userInput.contains("exit")) {
            System.exit(0); // exits the program
        }
    }
	
	public GameGrid getPlayersGrid () {
        return this.player;
    }
	
	public GameGrid getOpponentssGrid () {
        return this.opponent;
    }
}