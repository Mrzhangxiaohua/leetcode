package jianzhi_offer;

/**
 * @Description: 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 * @Author: zf
 * @Date: 2020/1/19 16:32
 */
public class prob_68 {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold <= 0 || rows < 1 || cols < 1) return 0;
        boolean[][] visited = new boolean[rows][cols];
        return movingCountCore(threshold, 0, 0, rows, cols, visited);
    }

    public int movingCountCore(int threshold, int row, int col, int rows, int cols, boolean[][] visited) {
        int count = 0;
        if (check(threshold, row, col, rows, cols, visited)) {
            visited[row][col] = true;
            count = 1 + movingCountCore(threshold, row - 1, col, rows, cols, visited)
                    + movingCountCore(threshold, row + 1, col, rows, cols, visited)
                    + movingCountCore(threshold, row, col - 1, rows, cols, visited)
                    + movingCountCore(threshold, row, col + 1, rows, cols, visited);
        }
        return count;
    }

    public boolean check(int threshold, int row, int col, int rows, int cols, boolean[][] visited){
        if (row < 0 || col < 0 || row >= rows || col >= cols || visited[row][col] == true)
            return false;
        int num = 0;
        while (row != 0 || col != 0) {
            num += row % 10;
            num += col % 10;
            row /= 10;
            col /= 10;
        }
        if (num > threshold){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        prob_68 solution = new prob_68();
        solution.movingCount(18, 50, 50);
    }
}
