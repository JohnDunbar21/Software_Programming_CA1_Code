package CS2020.assignment1.game;

import java.util.Scanner;

public class RunGame {

    /*
    This is the main utility method for the program that implements user functionality,
    allowing the game to be played (implementing class instances and class methods to do so).
    */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // create new Scanner() object
        System.out.println("Welcome to Battleships!");

        System.out.println("Enter the width of your ocean: ");
        int width = input.nextInt(); // get the width of the gameGrid array from the user

        System.out.println("Enter the height of your ocean: ");
        int height = input.nextInt(); // get the height of the gameGrid array from the user

        System.out.println("Enter the number of ships you want: ");
        int numberOfShips = input.nextInt(); // get the number of ships to be generated from the user

        // generate game object that initialises player and oponent grids
        Game game = new Game(width, height, numberOfShips);

        System.out.println("Player's Grid");
        game.player.printGrid(); // prints the player's unmodified grid
        System.out.println();
        System.out.println("Opponent's Grid");
        game.opponent.printGrid(); // prints the opponent's unmodified grid

        String attack = input.nextLine(); // prompt the user for their coordinate input

        while(!(game.checkVictory())) { // check if the player has won or lost
            
            try {
                System.out.println("Enter your attack coordinates in 'x,y' format: ");
                attack = input.nextLine(); // prompt the user for their coordinate input
                game.exitGame(attack); // check if the user input exits the code
                game.playRound(attack); // play a round of the game with the user input if it does not exit
            } catch(ArrayIndexOutOfBoundsException e) { // catch an error where the user coordinates exceed the grid's boundaries
                System.out.println("Out of bounds, get back over here!");
                System.out.println("Enter your attack coordinates in 'x,y' format: ");
                attack = input.nextLine(); // prompt the user for their coordinate input
                game.playRound(attack); // play a round of the game
            }
            
        }
    }

}