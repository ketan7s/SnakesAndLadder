package snakesAndLadder.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {

    private int size;
    private HashMap<Integer,Integer> snakes;
    private HashMap<Integer, Integer> ladders;
    private List<Player> players;

    public Board() {
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
        this.players = new ArrayList<>();
    }

    public HashMap<Integer, Integer> getSnakes() {
        return snakes;
    }

    public void setSnakes(HashMap<Integer, Integer> snakes) {
        this.snakes = snakes;
    }

    public HashMap<Integer, Integer> getLadders() { return ladders; }

    public void setLadders(HashMap<Integer, Integer> ladders) {
        this.ladders = ladders;
    }

    public int getSize() { return size; }

    public void setSize(int size) { this.size = size; }

    public List<Player> getPlayers() { return players; }

    public void setPlayers(List<Player> players) { this.players = players; }
}
