public class Lizard extends Choice {
  // TODO Implement a specific version of getName() for each choice
  // Hint: Make use of GameChoices to get a nice representation of the name!
  @Override
  public String getName() {
    // return the Lizard emoji
    return GameChoices.LIZARD;
  }

  // TODO Implement a specific version of competeExplanation() for each choice
  // Should return a String of the game round's explanation (e.g., "Rock crushes
  // Lizard")

  @Override
  public String competeExplanation(Choice otherPlayerChoice) {
    if (otherPlayerChoice == null) {
      throw new IllegalArgumentException("Choice cannot be null");

    }
    if (otherPlayerChoice.getName().equals(GameChoices.ROCK)) {
      return "Rock crushes lizard";
    }
    if (otherPlayerChoice.getName().equals(GameChoices.SPOCK)) {
      return "Lizard poisons Spock";
    } else if (otherPlayerChoice.getName().equals(GameChoices.PAPER)) {
      return "Lizard eats paper";
    } else if (otherPlayerChoice.getName().equals(GameChoices.SCISSORS)) {
      return "Scissors decapitate lizard";
    } else if (otherPlayerChoice.getName().equals(GameChoices.LIZARD)) {
      return "Lizard and Lizard is a Tie";
    } else {
      throw new IllegalArgumentException("Choice cannot be null" + otherPlayerChoice.getName());
    }

  }

  // TODO Implement a specific version of determineWin() for each choice
  /*
   * Compares the choice with the other player's choice
   * - Should return an `int`:
   * - `0`: choice is equal to otherPlayerChoice
   * - `1`: choice wins agains otherPlayerChoice
   * - `-1`: choice looses to otherPlayerChoice
   */

  @Override
  public int determineWin(Choice otherPlayerChoice) {

    if (otherPlayerChoice == null) {
      throw new IllegalArgumentException("Choice cannot be null");

    }
    if (otherPlayerChoice.getName().equals(GameChoices.SPOCK)
        || otherPlayerChoice.getName().equals(GameChoices.PAPER)) {
      return 1; // win
    } else if (otherPlayerChoice.getName().equals(GameChoices.ROCK)
        || otherPlayerChoice.getName().equals(GameChoices.SCISSORS)) {
      return -1; // loss
    } else if (otherPlayerChoice.getName().equals(GameChoices.LIZARD)) {
      return 0; // tie

    } else {
      throw new IllegalArgumentException("Choice cannot be null" + otherPlayerChoice.getName());
    }

  }
}
