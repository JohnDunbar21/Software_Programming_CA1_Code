package CS2020.assignment1.game;

import java.util.Scanner;

public class RunGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Battleships!");

        System.out.println("Enter the width of your ocean: ");
        int width = input.nextInt();

        System.out.println("Enter the height of your ocean: ");
        int height = input.nextInt();

        System.out.println("Enter the number of ships you want: ");
        int numberOfShips = input.nextInt();

        // generate game object that initialises player and oponent grids
        Game game = new Game(width, height, numberOfShips);

        System.out.println("Player's Grid");
        game.player.printGrid();
        System.out.println();
        System.out.println("Opponent's Grid");
        game.opponent.printGrid();

        String attack = input.nextLine();

        while(!(attack.contains("exit"))) {

            // assign the next value of 'attack' to the user's input
            try {
                attack = input.nextLine();
                game.playRound(attack);
            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("Out of bounds, boy!");
                attack = input.nextLine();
                game.playRound(attack);
            }
            
        }
    }

}