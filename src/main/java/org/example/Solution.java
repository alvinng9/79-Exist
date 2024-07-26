package org.example;

public class Solution {
    //boolean result = false;
    public boolean exist(char[][] board, String word) {
        boolean[] flag = new boolean[1];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!flag[0] && board[i][j] == word.charAt(0)) {
                    helper(board, word, i, j, 0, flag);
                }
            }
        }
        return flag[0];
    }

    public void helper(char[][] board, String word, int x, int y, int index, boolean[] flag) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || index >= word.length()
                  || board[x][y] != word.charAt(index)) {
            return;
        }
        if (index == word.length() - 1) {
            flag[0] = true;
        }
        char temp = board[x][y];
        board[x][y] = ' ';
        helper(board, word, x + 1, y, index + 1, flag);
        helper(board, word, x - 1, y, index + 1, flag);
        helper(board, word, x, y + 1, index + 1, flag);
        helper(board, word, x, y - 1, index + 1, flag);
        board[x][y] = temp;
    }
}
