package model;

import java.util.Timer;

public class Score {
    private final int boardNumber;
    private final Timer score;
    private final String nick;

    private Score(int boardNumber, Timer score, String nick) {
        this.boardNumber = boardNumber;
        this.score = score;
        this.nick = nick;
    }
}
