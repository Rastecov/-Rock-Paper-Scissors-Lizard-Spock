/*
 * Created on 2024-11-02
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

// TODO: implement Choice
// Choice should function as the Base class for all the choices
// There is no default Choice!
public abstract class Choice {

    // Get name of the choice
    public abstract String getName();

    // Explanation of the competition
    public abstract String competeExplanation(Choice otherPlayerChoice);

    // Check win, loss or tie
    public abstract int determineWin(Choice otherPlayerChoice);

    // NO NEED TO TOUCH compete()
    public int compete(Choice otherPlayerChoice) {
        System.out.println("Outcome: " + competeExplanation(otherPlayerChoice));
        return determineWin(otherPlayerChoice);
    }
}
