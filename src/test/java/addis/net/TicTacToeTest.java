package addis.net;


import org.junit.Test;
import static org.junit.Assert.fail;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class TicTacToeTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testCtor() {
        TicTacToe t = new TicTacToe();
        assertEquals(9, t.possibleMoves().size());
    }

    @Test
    public void testXandY() {
        TicTacToe t = new TicTacToe();
        assertEquals(0,t.x(-1));
        assertEquals(0,t.x(0));
        assertEquals(0,t.x(1));
        assertEquals(0,t.x(2));
        assertEquals(1,t.x(3));
        assertEquals(1,t.x(4));
        assertEquals(1,t.x(5));
        assertEquals(2,t.x(6));
        assertEquals(2,t.x(7));
        assertEquals(2,t.x(8));
        assertEquals(2,t.x(9));

        assertEquals(0,t.y(-1));
        assertEquals(0,t.y(0));
        assertEquals(1,t.y(1));
        assertEquals(2,t.y(2));
        assertEquals(0,t.y(3));
        assertEquals(1,t.y(4));
        assertEquals(2,t.y(5));
        assertEquals(0,t.y(6));
        assertEquals(1,t.y(7));
        assertEquals(2,t.y(8));
        assertEquals(2,t.y(9));
    }

    @Test (expected=TicTacToe.BadMoveException.class)
    public void testDoubleMoveShouldThrow() throws TicTacToe.BadMoveException {
        TicTacToe t = new TicTacToe();
        t.makeMove(1,1);
        t.makeMove(1,1);
        fail("double move should throw");
    }

    @Test
    public void testMakeMoveDecreasesPossibleMoves() throws TicTacToe.BadMoveException {
        TicTacToe t = new TicTacToe();
        int initialNumberOfMoves = t.possibleMoves().size();
        t.makeMove(1,1);
        assertEquals(initialNumberOfMoves-1, t.possibleMoves().size());
    }

}
