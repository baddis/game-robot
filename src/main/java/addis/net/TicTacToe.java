package addis.net;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe {

    class BadMoveException extends Exception {
    }
    private static final int WIDTH = 3;
    private static final int HEIGHT = 3;
    private int[][] board = new int[WIDTH][HEIGHT];
    public TicTacToe() {
    }

    List<Integer> possibleMoves() {
        List<Integer> rval = new ArrayList<Integer>();
        for (int i=0; i<WIDTH*HEIGHT; i++) {
            if (0==board[x(i)][y(i)]) {
                 rval.add(i);
            }
        }
        return rval;
    }

    void makeMove(int position, int side) throws BadMoveException {
        if (0!=board[x(position)][y(position)]) {
            throw new BadMoveException();
        }
        board[x(position)][y(position)] = side;
    }

    int x(int i) {
        if (i<0) {
            return 0;
        } else if (i>=WIDTH*HEIGHT) {
            return WIDTH-1;
        } else {
            return i / WIDTH;
        }
    }
    int y(int i) {
        if (i<0) {
            return 0;
        } else if (i>=WIDTH*HEIGHT) {
            return HEIGHT-1;
        } else {
            return i % HEIGHT;
        }
    }
}
