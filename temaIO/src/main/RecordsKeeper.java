package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class that handles the list of players
 *
 * @author Gligor Avram
 * @version 1.0.0
 */
public class RecordsKeeper {
    private List<Player> playersList = new ArrayList<>();

    public void addPlayer(Player p){
        if (p != null || p.getFinalTime() != -1) {
            playersList.add(p);
        }
    }

    /**
     * Sorts the list and prints the first 3 elements of the list of players
     */
    public void displayWinners(){
        Collections.sort(playersList);
        System.out.println("Winner: " + playersList.get(0));
        System.out.println("Biggest loser: " + playersList.get(1));
        System.out.println("2nd biggest loser: " + playersList.get(2));
    }

    /**
     * Creates players from the line that is fed into the method. Throws an error if the line doesn't have enough "fields" (7)
     *
     * @param currentLine
     * @return
     */
    public Player playerCreator(String currentLine) {
        try {
            String[] line = currentLine.split(",");
            String nr = line[0];
            String name = line[1];
            String country = line[2];
            String time = line[3];
            String firstShot = line[4];
            String ndShot = line[5];
            String rdShot = line[6];
            return new Player(nr, name, country, time, firstShot, ndShot, rdShot);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Some of the data might be corrupt");
        }
        return null;
    }

    /**
     * @return the number of players in the list
     */
    public int currentlyInList(){
        return playersList.size();
    }
}
