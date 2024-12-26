import java.util.ArrayList;

public class Leaderboard {
    private ArrayList<Player> players;

    // Initialize learderboard constructor with an empty array List
    public Leaderboard() {
        this.players = new ArrayList<>();
    }

    // Add a player to the leaderboard
    public void addPlayer(Player player) {
        // look if the player exist
        for (Player aPlayer : players) {
            if (aPlayer.getName().equals(player.getName())) {
                // Player exist so we don't need to add
                return;
            }
        }
        // add a new player with default win 0
        players.add(player);

    }

    // Add a player or update their win count if the palyer exist
    public void trackWin(Player player) {

        // Add a player if it does not exist
        addPlayer(player);
        // Add 1 to the total win of the player game count in the leaderboard.
        player.addToGame();

    }

    // Implement a Bubblesort to order player winning by descending order
    private void bubbleSortPlayers() {
        int n = players.size();
        boolean isSwapped;
        for (int i = 0; i < n - 1; i++) {
            isSwapped = false;

            for (int j = 0; j < n - 1 - i; j++) {

                if (players.get(j).getGameWins() < players.get(j + 1).getGameWins()) {
                    // swap player j and player j+1
                    Player temp = players.get(j);
                    players.set(j, players.get(j + 1));
                    players.set(j + 1, temp);

                    isSwapped = true;
                }
            }

            // when there is no swap break
            if (!isSwapped) {
                break;
            }

        }

    }

    // Show player name in leaderboard in descending order

    public void showLeaderboard() {
        System.out.println("Leaderboad: ");
        // sort players
        bubbleSortPlayers();
        // show the new sorted players
        for (Player player : players) {
            System.out.println(player.getName() + " now has\t" + player.getGameWins() + " wins");
        }

    }

    // Search player method
    public Integer searchPlayer(String name) {
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(name)) {
                // return the player win if the player is found
                return player.getGameWins();
            }
        }
        // return null if not found
        return null;
    }

}
