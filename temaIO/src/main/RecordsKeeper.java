package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecordsKeeper {
    private List<Player> playersList = new ArrayList<>();

    public void addPlayer(Player p){
        if(p.getFinalTime() != -1) {
            playersList.add(p);
        }
    }

    public void displayWinners(){
        Collections.sort(playersList);
        System.out.println("Winner: " + playersList.get(0));
        System.out.println("Biggest loser: " + playersList.get(1));
        System.out.println("2nd biggest loser: " + playersList.get(2));
    }

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
        } catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Some of the data might be corrupt");
        }
        return null;
    }

    public int currentlyInList(){
        return playersList.size();
    }
}
