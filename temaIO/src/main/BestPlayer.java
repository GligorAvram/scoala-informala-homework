package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BestPlayer {
    public static void main(String[] args) {
        RecordsKeeper records = new RecordsKeeper();

        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\GitRep\\SIIT\\scoala-informala-homework\\temaIO\\src\\fisiere\\players.csv"))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                Player p = records.playerCreator(currentLine);
                records.addPlayer(p);
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }

        records.displayWinners();
    }


}
