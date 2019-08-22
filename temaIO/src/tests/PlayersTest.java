package tests;

import main.Player;
import main.RecordsKeeper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayersTest {
    private final String line = "98,Mamian Riptide,FI,61:45,xxoox,oooxo,xooxo";
    @Test
    public void playerCreation(){
        RecordsKeeper rc = new RecordsKeeper();
        Player p = rc.playerCreator(line);
        assertEquals("98", p.getNr());
        assertEquals("Mamian Riptide", p.getName());
        assertEquals("FI", p.getCountry());
        assertEquals("xxoox", p.getFirstShot());
        assertEquals("oooxo", p.getNdShot());
        assertEquals("xooxo", p.getRdShot());
        assertEquals("61:45", p.getTime());
        assertEquals(3795, p.getFinalTime());
        assertEquals(90, p.getTimeAdded());
    }

    @Test
    public void playerDisqualifier(){
        String line = "98,Mamian Riptide,FI,258,xxoox,oooxo,xooxo";
        RecordsKeeper rc = new RecordsKeeper();
        Player p = rc.playerCreator(line);
        rc.addPlayer(p);
        assertEquals(0, rc.currentlyInList());
    }

    @Test
    public void playerDisqualifier2(){
        String line = "98,Mamian Riptide,FI,2a:w8,xxoox,oooxo,xooxo";
        RecordsKeeper rc = new RecordsKeeper();
        Player p = rc.playerCreator(line);
        assertEquals(-1, p.getFinalTime());
        assertEquals(0, rc.currentlyInList());
    }

    @Test(expected = NullPointerException.class)
    public void playerException(){
        String line = "98,Mamian Riptide,FI,25:8,oooxo,xooxo";
        RecordsKeeper rc = new RecordsKeeper();
        Player p = rc.playerCreator(line);
        assertEquals("98", p.getNr());
        assertEquals("Mamian Riptide", p.getName());
        assertEquals("FI", p.getCountry());
        assertEquals("xxoox", p.getFirstShot());
        assertEquals("oooxo", p.getNdShot());
        assertEquals("xooxo", p.getRdShot());
        assertEquals("61:45", p.getTime());
        assertEquals(3795, p.getFinalTime());
        assertEquals(90, p.getTimeAdded());
    }
}
