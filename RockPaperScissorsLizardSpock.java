/*
 * Created on 2024-11-02
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsLizardSpock {

    private Player player;
    private Player computer;
    private Leaderboard learderboard = new Leaderboard();

    private final int minWins = 2;

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    protected RockPaperScissorsLizardSpock() {
        computer = new Player("Computer");

        learderboard.addPlayer(computer);
    }

    // TODO: implement playRound and round win check here
    public void playRound() {
        Choice playerChoice = null;

        while (playerChoice == null) {

            System.out.printf(player.getName() + ", please enter %s, %s, %s, %s, or %s: %n", GameChoices.ROCK,
                    GameChoices.PAPER, GameChoices.LIZARD,
                    GameChoices.SCISSORS, GameChoices.SPOCK);
            String playerInput = scanner.nextLine();
            playerChoice = getChoice(playerInput);

            if (playerChoice == null) {
                System.out.println("Invalid choice, enter a valid choice!");
            }
        }

        // Select a random choice for the computer
        Choice computerChoice = getRandomChoice();
        System.out.println("Computer selects " + computerChoice.getName());

        // Get the current round result
        int result = playerChoice.determineWin(computerChoice);
        if (result == 1) {
            System.out.println("Outcome: " + playerChoice.competeExplanation(computerChoice));
            System.out.println("Round Result: " + player.getName() + " wins this round!");
            player.addToScore();
        } else if (result == -1) {
            System.out.println("Outcome: " + computerChoice.competeExplanation(playerChoice));
            System.out.println("Round Result: Computer wins this round!");
            computer.addToScore();
        } else {
            System.out.println("Outcome is a tie");
        }
    }

    // TODO: implement a method to convert the player's input into a choice
    private Choice getChoice(String choice) {
        choice = choice.toLowerCase();
        // Check the passed string and return a Choice object (i.e., Rock, Paper,
        // Scissors, Lizard, or Spock)

        switch (choice) {
            case "rock":
                return new Rock();
            case "paper":
                return new Paper();
            case "lizard":
                return new Lizard();
            case "scissors":
                return new Scissors();
            case "spock":
                return new Spock();
            // Pick a default case
            default:
                return new Rock();

        }

    }

    // TODO: implement a method to get a random choice for the computer
    private Choice getRandomChoice() {
        // Based on a random number, return a Choice object (i.e., Rock, Paper,
        // Scissors, Lizard, or Spock)
        int computerRandomChoice = random.nextInt(5);
        switch (computerRandomChoice) {
            case 0:
                return new Rock();
            case 1:
                return new Paper();
            case 2:
                return new Lizard();
            case 3:
                return new Scissors();
            case 4:
                return new Spock();
            // Pick a default case
            default:
                return new Paper();

        }
    }

    public void startGame() {
        System.out.println("Welcome to Rock Paper Scissors Lizard Spock, Choose from one options below");

        while (true) {
            System.out.println("\nOptions 1-4  in the Menu");
            System.out.println("\n 1-Play a new game");
            System.out.println("\n 2-Show leaderboard");
            System.out.println("\n 3-Search for a player");
            System.out.println("\n 4-Exit the game");

            try {
                System.out.println("\n Choose an option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Player, please enter your name:");
                        String playerName = scanner.nextLine();
                        player = new Player(playerName);
                        learderboard.addPlayer(player);
                        newGame();
                        break;
                    case 2:
                        learderboard.showLeaderboard();
                        break;
                    case 3:
                        searchPlayer();
                        break;
                    case 4:
                        System.out.println("Exit the game");
                        scanner.close();
                        return;
                    // Pick a default case
                    default:
                        System.out.println("Choose a valid option");

                }
            } catch (NumberFormatException e) {
                System.out.println(" Invalid choice, Enter a number between 1-4");

            }

        }

    }

    // TODO: implement the main game loop and overall game win check here
    public void newGame() {
        // reset the game score for the new session
        player.resetPlayerScore();
        computer.resetPlayerScore();

        while (player.getScore() < minWins && computer.getScore() < minWins) {
            playRound();
            System.out.println("Current Score of : " + player.getName() + " is: " + player.getScore()
                    + ", Computer score is " + computer.getScore());
        }

        // Check the the game winner then upade the leaderboard
        if (player.getScore() >= minWins) {
            System.out.println(player.getName() + " won the game");
            learderboard.trackWin(player);
        } else {
            System.out.println("Computer have won the game");
            learderboard.trackWin(computer);
        }

        // Show final score and leaderboard at end
        System.out.printf("Final score: %s: %d vs Computer: %d%n", player.getName(), player.getScore(),
                computer.getScore());
        learderboard.showLeaderboard();

    }

    // Search for a player by their name
    private void searchPlayer() {
        System.out.println("Enter the player name that you want to search ");
        String playerName = scanner.nextLine().trim();
        Integer playerWins = learderboard.searchPlayer(playerName);
        if (playerWins != null) {
            System.out.println("Player " + playerName + " has " + playerWins + " wins");

        } else {
            System.out.println("Player not found in the leaderboard");
        }
    }

    // NO NEED TO TOUCH main()
    public static void main(String[] args) {
        RockPaperScissorsLizardSpock game = new RockPaperScissorsLizardSpock();
        game.startGame();
        game.scanner.close();
    }
}
