package CS2020.assignment1.game;

import java.lang.Integer;
import java.util.Random;

public class Game implements GameControls {

    public PlayerGameGrid player; // Instantiates a PlayerGameGrid object
    public OpponentGameGrid opponent; // Instantiates an OpponentGameGrid object

    public Game (int width, int height, int numberOfShips) {
        this.player = new PlayerGameGrid(width, height, numberOfShips); // assigns the constructor of the player variable
        this.opponent = new OpponentGameGrid(width, height, numberOfShips); // assigns the constructor of the opponent variable
    }

    /*
    The playRound() method is the core functionality behind the game. It has to take a string input
    and convert it into usable coordinates for the program to check if a ship lies on that position.

    After parsing the string to get the integer values of the coordinates, it is then passed through
    the player and opponent grid arrays to check if a ship lies on the specified coordinates. The opponent
    uses the Random() object to generate a set of coordinates within the bounds of the rows and columns of
    the gameGrid.

    The checkAttack() method is used to verify if a ship is on the grid at that position, and if so, marks it
    with an 'X', and a '%' if not. Messages are displayed to the user to communicate the outcome of their turn.

    Once the turn is over, the opponent and player grids are printed to the terminal with updated values.
    */
    public void playRound (String input) {
        
        String[] splitCoordinates = input.split(","); // split the input string to create a String array
        int xCoordinates = 0; // initialise local variable for x-coordinate
        int yCoordinates = 0; // initialise local variable for y-coordinate

        if(splitCoordinates.length == 2) { // check that there are only two coordinates (i.e. x,y)
            xCoordinates = Integer.parseInt(splitCoordinates[0]); // retrieves the x-coordinate from input
            yCoordinates = Integer.parseInt(splitCoordinates[1]); // retrieves the y-coordinate from input
        }
        else {
            System.out.println("Your input is in an invalid format: enter coordinates in the format 'x,y'."); // informative error telling the user to input the coordinates in the correct format
        }

        System.out.println("Player is attacking");

        // iterate through opponent's ship array
        for(int ship = 0; ship < opponent.ships.length; ship++) { // iterate through the rows of the opponent ships array
            if(opponent.ships[ship].checkAttack(xCoordinates, yCoordinates) == true) { // check if the ship lies on the specified coordinates
                opponent.gameGrid[xCoordinates][yCoordinates] = "X"; // replace the value at the given coordinates with an 'X'
                System.out.println("HIT "+opponent.ships[ship].name+"!!!"); // inform the user of the outcome
            }
            else {
                if(opponent.gameGrid[xCoordinates][yCoordinates] != "X"){ // check if the position is already an 'X' value
                    opponent.gameGrid[xCoordinates][yCoordinates] = "%"; // if it is not already attacked, replace with a '%' character
                }
            }
        }

        if(opponent.gameGrid[xCoordinates][yCoordinates] == "%") { // check if the user missed their target
            System.out.println("MISS!!!"); // inform the user of the outcome
        }

        System.out.println("Opponent is attacking");

        Random random = new Random(); // create new Random() object

        int yCoord = random.nextInt(player.gameGrid.length); // randomly select a value between 0 and the number of rows in the array
        int xCoord = random.nextInt(player.gameGrid[0].length); // randomly select a value between 0 and the number of columns in the array

        for(int ship = 0; ship < player.ships.length; ship++) { // iterate through the player's ship array
            if(player.ships[ship].checkAttack(xCoord, yCoord) == true) { // check if the random coordinates match the position of a player's ship
                player.gameGrid[xCoord][yCoord] = "X"; // update the value on the gameGrid to 'X'
                System.out.println("HIT "+player.ships[ship].name+"!!!"); // inform user of outcome
            }
            else {
                if(player.gameGrid[xCoord][yCoord] != "X"){ // check if the position is already an 'X' value
                    player.gameGrid[xCoord][yCoord] = "%"; // if it is not already attacked, replace with a '%' character
                }
            }
        }
        if(player.gameGrid[xCoord][yCoord] == "%") { // check if the opponent missed their target
            System.out.println("MISS!!!"); // infrom the user of the outcome
        }
        System.out.println("Player's Grid");
        player.printGrid(); // print the updated player's grid

        System.out.println("Opponent's Grid");
        opponent.printGrid(); // print the updated opponent's grid
    }
	
    /*

    */
	public boolean checkVictory () {
        int playerHits = 3 * player.ships.length; // local variable of the maximum number of hits the player can have
        int opponentHits = 3 * opponent.ships.length; // local variable of the maximum number of hits the opponent can have
        for(int ship = 0; ship < opponent.ships.length; ship++) { // iterate through the length of the opponent's ship array
            int opponenthit = opponent.ships[ship].getHits(); // get the number of hits that the current ship has
            if(opponenthit > 0) {
                opponentHits -= opponenthit; // decrease the maximum hits of the opponent by the number of hits the current ship has
            }
        }
        for(int ship = 0; ship < player.ships.length; ship++) { // iterate through the length of the player's ship array
            int playerhit = player.ships[ship].getHits(); // get the number of hits that the current ship has
            if(playerhit > 0) {
                playerHits -= playerhit; // decrease the maximum hits of the player by the number of hits the current ship has
            }
        }
        if(playerHits == 0) { // check if the player has any hits left
            System.out.println("You have lost!");
            return false;
        }
        else if(opponentHits == 0) { // check if the opponent has any hits left
            System.out.println("You have won!");
            return true;
        }
        return false;
    }
	
    // exit method which terminates the program if the input string reads "exit"
	public void exitGame (String input) {
        String userInput = input.toLowerCase(); // ensures that the command is in lower case
        if(userInput.contains("exit")) {
            System.exit(0); // exits the program
        }
    }
	
    // getter method for the player's grid
	public GameGrid getPlayersGrid () {
        return this.player;
    }
	
    // getter method for the opponent's grid
	public GameGrid getOpponentssGrid () {
        return this.opponent;
    }
}