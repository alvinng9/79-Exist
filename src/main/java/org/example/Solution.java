package org.example;

public class Solution {
    //boolean result = false;
    public boolean exist(char[][] board, String word) {
        //create a flag to signal if the word has been found
        boolean[] flag = new boolean[1];
        //iterate through the 2d array
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //check if the word has been found
                //check if the first letter of the word matches the current letter of the board
                if (!flag[0] && board[i][j] == word.charAt(0)) {
                    helper(board, word, i, j, 0, flag);
                }
            }
        }
        return flag[0];
    }

    public void helper(char[][] board, String word, int x, int y, int index, boolean[] flag) {
        //check for out of bounds
        //check if the letters match
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || index >= word.length()
                  || board[x][y] != word.charAt(index) || flag[0]) {
            return;
        }

        //if the index is at the last letter of the word, a match has been found
        //set the flag to true
        if (index == word.length() - 1) {
            flag[0] = true;
        }
        //set the current value of the board to a temporary char
        char temp = board[x][y];
        board[x][y] = ' ';
        helper(board, word, x + 1, y, index + 1, flag);
        helper(board, word, x - 1, y, index + 1, flag);
        helper(board, word, x, y + 1, index + 1, flag);
        helper(board, word, x, y - 1, index + 1, flag);
        //set the current value of the board to its original character
        board[x][y] = temp;
    }
}
