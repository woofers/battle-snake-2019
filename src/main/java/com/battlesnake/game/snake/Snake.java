package com.battlesnake.game.snake;

import java.util.List;

import com.battlesnake.game.Board;
import com.battlesnake.game.BoardMove;
import com.battlesnake.game.Move;
import com.battlesnake.game.Taunt;
import com.battlesnake.game.math.Point;

/**
 * @author Ben Austin
 * @author Jaxson Van Doorn
 * @author Zak White
 */
public class Snake {
    public static enum Mode {
        ATTACK_STATE,
        BAIT_STATE,
        HUNGRY_STATE,
        NO_BEST_MOVE_STATE,
        PASSIVE_STATE
    }

    private static final String COLOR = "#f2c55c";
    private static final String DUST_TAUNT = "Snake, I'll crush you into dust!";
    private static final String GEAR_TAUNT = "Good. Then no one can stop Metal Gear now.";
    private static final Head HEAD_TYPE = Head.shades;
    private static final String HOLE_TAUNT = "So, the Snake's finally come out of his hole! Are you ready now, my brother!";
    private static final int HUNGER_ZONE = 50;
    private static final String IMAGE = "https://i.imgur.com/FX5ZLYE.png";
    private static final int MAX_HEALTH = 100;
    private static final int MIN_HEALTH = 0;

    private static final String NAME = "Liquid Snake";
    private static final String START_TAUNT = "Sleeping late as usual, ...eh Snake?";
    private static final Tail TAIL_TYPE = Tail.skinny;

    public static SnakeConfig startResponse() {
        SnakeConfig config = new SnakeConfig();
        config.setColor(COLOR);
        config.setHeadUrl(IMAGE);
        config.setName(NAME);
        config.setTaunt(START_TAUNT);
        config.setTailType(TAIL_TYPE);
        config.setHeadType(HEAD_TYPE);
        return config;
    }

    private List<Point> body;
    private int health;

    private String id;
    private int length;
    private String name;
    private transient String taunt;
    private transient int turn;

    public Snake() {
        setTaunt(HOLE_TAUNT);
    }

    public List<Point> body() {
        return body;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Snake) return equals((Snake) other);
        return false;
    }

    public boolean equals(Snake other) {
        return id().equals(other.id());
    }

    public Point head() {
        return body.get(0);
    }

    public int health() {
        return health;
    }

    public String id() {
        return id;
    }

    public boolean isDead() {
        return health() < MIN_HEALTH;
    }

    public boolean isLongest(Board board) {
        return longerThan(board.longestSnakeLength());
    }

    public boolean justAte() {
        return health() == MAX_HEALTH;
    }

    public int length() {
        return length;
    }

    private boolean longerThan(int length) {
        return length() > length;
    }

    public boolean longerThan(Snake snake) {
        return longerThan(snake.length());
    }

    public Mode mode(Board board) {
        if (health() <= HUNGER_ZONE)
            return Mode.HUNGRY_STATE;
        else if (length() > board
            .longestSnakeLength()) return Mode.ATTACK_STATE;
        return Mode.HUNGRY_STATE;
    }

    public Move move(Board board) {
        Move move = null;
        switch (mode(board)) {
        case HUNGRY_STATE:
            move = board.goToFood(head());
            if (move == null) {
                move = board.goToAttack(head());
            }
            if (move == null) {
                move = board.goToTail(head());
            }
            break;
        case PASSIVE_STATE:
            move = board.goToTail(head());
            if (move == null) {
                move = board.goToFood(head());
            }
            if (move == null) {
                move = board.goToAttack(head());
            }
            break;
        case ATTACK_STATE:
            move = board.goToAttack(head());
            if (move == null) {
                move = board.goToFood(head());
            }
            if (move == null) {
                move = board.goToTail(head());
            }
            break;
        }
        if (move == null) {
            move = Move.left;
        }
        return move;
    }

    public BoardMove moveResponse(Board board) {
        BoardMove moveResponse = new BoardMove();
        moveResponse.setMove(move(board));
        moveResponse.setTaunt(new Taunt(taunt(), turn).toString());
        return moveResponse;
    }

    public String name() {
        return name;
    }

    public void setTaunt(String taunt) {
        this.taunt = taunt;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public String taunt() {
        return taunt;
    }
}