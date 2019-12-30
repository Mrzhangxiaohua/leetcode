package Prob_1_to_Prob_50;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * @Author: zf
 * @Date: 2019/10/14 0:30
 */

public class prob_36 {
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + "    ");
            }
            System.out.println("\n");
        }
        boolean judge_row_and_column = judge_row_and_column(board);
        boolean judge_every_tangle = judge_every_tangle(board);
        if (judge_row_and_column && judge_every_tangle) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean judge_row_and_column(char[][] board) {
        // 判断行是否满足条件
        for (int i = 0; i < board.length; i++) {
            int cout_char_nums = 0;
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    cout_char_nums += 1;
                    set.add(board[i][j]);
                }
            }
            if (cout_char_nums != set.size()) {
                return false;
            }
        }
        // 判断列是否满足条件
        for (int i = 0; i < board.length; i++) {
            int cout_char_nums = 0;
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] != '.') {
                    cout_char_nums += 1;
                    set.add(board[j][i]);
                }
            }
            if (cout_char_nums != set.size()) {
                return false;
            }
        }
        return true;
    }

    public static boolean judge_every_tangle(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int cout_char_nums = 0;
                Set<Character> set = new HashSet<>();
                for (int k = i * 3; k < i * 3 + 3; k++) {
                    for (int l = j * 3; l < j * 3 + 3; l++) {
                        if (board[k][l] != '.') {
                            cout_char_nums += 1;
                            set.add(board[k][l]);
//                            System.out.println(k + " " + l);
                        }
                    }
                }
                if (cout_char_nums != set.size()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] nums = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean temp = isValidSudoku(nums);
        System.out.println(temp);
    }
}
