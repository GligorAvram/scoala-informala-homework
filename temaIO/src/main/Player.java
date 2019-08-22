package main;

public class Player implements Comparable<Player> {

    private final String nr, name, country, time, firstShot, ndShot, rdShot;
    private final int finalTime, timeAdded;

    public String getNr() {
        return nr;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getTime() {
        return time;
    }

    public String getFirstShot() {
        return firstShot;
    }

    public String getNdShot() {
        return ndShot;
    }

    public String getRdShot() {
        return rdShot;
    }

    public int getTimeAdded() {
        return timeAdded;
    }

    public Player(String nr, String name, String country, String time, String firstShot, String ndShot, String rdShot) {
        this.nr = nr;
        this.name = name;
        this.country = country;
        this.time = time;
        this.firstShot = firstShot;
        this.ndShot = ndShot;
        this.rdShot = rdShot;
        //calculate the time added and assign it
        int penalties = 0;
        penalties += penaltyCalc(firstShot);
        penalties += penaltyCalc(ndShot);
        penalties += penaltyCalc(rdShot);
        timeAdded = penalties;
        //calculate the final time, penalties included, in seconds
        this.finalTime = finalTimeCalc(time, penalties);
    }

    private int finalTimeCalc(String time, int penalties) {
        int minutes;
        int seconds;
        try{
        String[] t = time.split(":");
            try {
                minutes = Integer.parseInt(t[0]);
                seconds = Integer.parseInt(t[1]);
                return (minutes * 60 + seconds + penalties);
            } catch (IllegalArgumentException e) {
                System.out.println(String.format("the value that was passed in was incorrect or player %s was disqualified", name));

            }
        } catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Some of the data might be corrupt");
        }
        return -1;
    }

    public int getFinalTime() {
        return finalTime;
    }

    @Override
    public String toString() {
        int finalMinutes = finalTime / 60;
        int finalSeconds = finalTime % 60;
        String zero = "";
        if (finalSeconds < 10) {
            zero = "0";
        }
        return name +
                ", Final Time:" + finalMinutes + ":" + zero + finalSeconds +
                " (Run time:" + time +
                ", Penalty time:" + timeAdded +
                ")}";
    }

    private int penaltyCalc(String shots) {
        if(shots == null){
            throw new NullPointerException();
        }
        int penalty = 0;
        for (int i = 0; i < shots.length(); i++) {
            if (shots.charAt(i) == 'o') {
                penalty += 10;
            }
        }
        return penalty;
    }

    @Override
    public int compareTo(Player o) {
        if (this.finalTime > o.finalTime) {
            return 1;
        } else if (this.finalTime == o.finalTime) {
            return 0;
        }
        return -1;
    }
}
