package CS2020.assignment1.game;

public class Game implements GameControls {

    public PlayerGameGrid player;
    public OpponentGameGrid opponent;

    public Game (int width, int height, int numberOfShips) {
        this.player = new PlayerGameGrid(width, height, numberOfShips);
        this.opponent = new OpponentGameGrid(width, height, numberOfShips);
    }

    public void playRound (String input) {
        // fill in
    }
	
	public boolean checkVictory () {
        for(int ship = 0; ship < player.ships.length; ship++) {
            if(player.ships[ship].hits < 3 && opponent.ships[ship].hits == 3) {
                System.out.println("You have won!");
                return true;
            }
        }
        System.out.println("You have lost!");
        return false;
    }
	
	public void exitGame (String input) {
        String userInput = input.toLowerCase(); // ensures that the command is in lower case
        if(userInput == "exit") {
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