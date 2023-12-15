package snakesAndLadder.service;

import snakesAndLadder.entity.Board;
import snakesAndLadder.entity.Player;

import static snakesAndLadder.util.DiceRoller.rollDice;

public class BoardService {

    private Board board;
    private boolean isGameOngoing = true;
    private int playerTurn = 0;

    public BoardService() {
        this.board = new Board();
    }

    public void startGame() {

        while(isGameOngoing) {

            Player currPlayer = board.getPlayers().get(playerTurn);
            int rollCount = rollDice();
            int startPosition = currPlayer.getPosition();
            currPlayer.setPosition(currPlayer.getPosition() + rollCount);
            if (currPlayer.getPosition() == 100) {
                System.out.println(currPlayer.getName() + " rolled a " + rollCount + " and moved from "
                        + startPosition + " to 100");
                System.out.println(currPlayer.getName() + " wins the game");
                isGameOngoing = false;
            } else if (currPlayer.getPosition() > 100) {
                currPlayer.setPosition(currPlayer.getPosition() - rollCount);
                System.out.println(currPlayer.getName() + " rolled a " + rollCount + " and moved from "
                        + startPosition + " to " + currPlayer.getPosition());
            } else {
                while(board.getLadders().containsKey(currPlayer.getPosition()) ||
                        board.getSnakes().containsKey(currPlayer.getPosition())) {
                    if (board.getLadders().containsKey(currPlayer.getPosition())) {
                        currPlayer.setPosition(board.getLadders().get(currPlayer.getPosition()));
                    } else if (board.getSnakes().containsKey(currPlayer.getPosition())) {
                        currPlayer.setPosition(board.getSnakes().get(currPlayer.getPosition()));
                    }
                }
                if (currPlayer.getPosition() == 100) {
                    System.out.println(currPlayer.getName() + " rolled a " + rollCount + " and moved from "
                            + startPosition + " to 100");
                    System.out.println(currPlayer.getName() + " wins the game");
                    isGameOngoing = false;
                } else {
                    System.out.println(currPlayer.getName() + " rolled a " + rollCount + " and moved from "
                            + startPosition + " to " + currPlayer.getPosition());
                }
            }
            if ((playerTurn + 1) == board.getPlayers().size()) {
                playerTurn = 0;
            } else {
                playerTurn++;
            }
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
