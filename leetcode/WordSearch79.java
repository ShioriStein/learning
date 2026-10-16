package leetcode;


import java.util.*;

public class WordSearch79 {
    char[][] board;
    String word;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist2(i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist2(int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        Character temp = board[i][j];
        board[i][j] = '#';

        boolean result = exist2(i + 1, j, index + 1) || exist2(i - 1, j, index + 1) || exist2(i, j + 1, index + 1) || exist2(i, j - 1, index + 1);

        board[i][j] = temp;
        return result;
    }

    public static void main(String[] args) {
        var test = new WordSearch79();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        char[][] board2 = {
                {'a', 'b'},
        };

        char[][] board3 = {
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        };

        char[][] megaBoard = {
                {'a', 'a', 'b', 'a', 'a', 'b'},
                {'a', 'a', 'b', 'b', 'b', 'a'},
                {'a', 'a', 'a', 'a', 'b', 'a'},
                {'b', 'a', 'b', 'b', 'a', 'b'},
                {'a', 'b', 'b', 'a', 'b', 'a'},
                {'b', 'a', 'a', 'a', 'a', 'b'}
        };
//        System.out.println(test.exist(board, "ABCCED"));
//        System.out.println(test.exist(megaBoard, "bbbaabbbbbab"));
        System.out.println(test.exist(board2, "ba"));
    }
}
