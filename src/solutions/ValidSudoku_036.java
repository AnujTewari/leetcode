package solutions;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/valid-sudoku/
 *
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled
 * with the character '.'.
 *
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only
 * the filled cells need to be validated.
 */
public class ValidSudoku_036 {
    public boolean isValidSudoku(char[][] board) {
        if (board == null) return false;
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') continue;
                if (set.contains(board[i][j])) return false;
                if (board[i][j] - '0' < 1 || board[i][j] - '0' > 9) return false;
                set.add(board[i][j]);
            }
            set.clear();
        }
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[j][i] == '.') continue;
                if (set.contains(board[j][i])) return false;
                if (board[j][i] - '0' < 1 || board[j][i] - '0' > 9) return false;
                set.add(board[j][i]);
            }
            set.clear();
        }
        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                for (int i = r; i < r + 3; ++i) {
                    for (int j = c; j < c + 3; ++j) {
                        if (board[i][j] == '.') continue;
                        if (set.contains(board[i][j])) return false;
                        if (board[i][j] - '0' < 1 || board[i][j] - '0' > 9) return false;
                        set.add(board[i][j]);
                    }
                }
                set.clear();
            }
        }
        return true;
    }
}
