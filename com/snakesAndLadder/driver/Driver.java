package snakesAndLadder.driver;

import snakesAndLadder.entity.Player;
import snakesAndLadder.service.BoardService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        BoardService boardService = new BoardService();
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> snakes = new HashMap<>();
        HashMap<Integer, Integer> ladders = new HashMap<>();
        List<Player> players = new ArrayList<>();
        int playerCount;
        int snakeCount;
        int ladderCount;

        System.out.println("Enter no of Snakes:");
        snakeCount = sc.nextInt();
        System.out.println("Enter Snakes Head and Tail positions:");
        for (int i=0; i < snakeCount; i++) {
            snakes.put(sc.nextInt(), sc.nextInt());
        }

        System.out.println("Enter no of Ladders:");
        ladderCount = sc.nextInt();
        System.out.println("Enter Ladders End and Start positions:");
        for (int i=0; i < ladderCount; i++) {
            ladders.put(sc.nextInt(), sc.nextInt());
        }

        System.out.println("Enter no of Players:");
        playerCount = sc.nextInt();
        System.out.println("Enter Player names:");
        for (int i=0; i < playerCount; i++) {
            players.add(new Player(sc.next()));
        }

        boardService.getBoard().setSnakes(snakes);
        boardService.getBoard().setLadders(ladders);
        boardService.getBoard().setPlayers(players);
        boardService.startGame();
    }
}
