package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void existTest() {
        Solution solution = new Solution();
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        assertTrue(solution.exist(board, "ABCCED"));

        assertTrue(solution.exist(board, "SEE"));

        assertFalse(solution.exist(board, "ABCBGGGGGGG"));
    }

}