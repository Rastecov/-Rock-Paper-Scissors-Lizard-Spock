/*
 * Created on 2024-11-02
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

public final class Player {
    // TODO: implement.
    private String name;
    // score of the current game
    private int score;
    // track number of game won
    private int gameWins;
    private Choice choice;

    // Getters

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getGameWins() {
        return gameWins;
    }

    public Choice getChoice() {
        return choice;
    }

    // initialize the construtoe with default values
    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.gameWins = 0;
        this.choice = null;
    }

    // set the player choice for the current round
    public void playerChoice(Choice choice) {
        this.choice = choice;
    }

    // Add one to the player score if the player win
    public void addToScore() {
        this.score++;
    }

    // reset the score of the player to 0 for a new session
    // Add one to the player score if the player win
    public void resetPlayerScore() {
        this.score = 0;
    }

    // Add one to the player total number of game won if they win
    public void addToGame() {
        this.gameWins++;
    }

}
