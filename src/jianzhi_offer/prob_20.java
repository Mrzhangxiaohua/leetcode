package jianzhi_offer;

import java.util.ArrayList;

/**
 * @Description: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
 * 如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @Author: zf
 * @Date: 2020/1/6 22:05
 */
public class prob_20 {
    // 方法1，依次顺时针
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        // 特殊判断
        if (matrix.length == 0) return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<Integer> ();
        // n代表有多少行，m代表有多少列
        int n = matrix.length, m = matrix[0].length;
        int layer = (Math.min(n, m)-1) / 2 + 1;
        for (int i = 0; i < layer; i++) {
            // 1.从左到右
            for (int k = i; k < m - i; k++) {
                result.add(matrix[i][k]);
            }
            // 2.从右上到右下
            for (int j = i + 1; j < n - i; j++) {
                result.add(matrix[j][m - i - 1]);
            }
            // 3.从右下到左下
            for (int k = m - i - 2; (k >=i) && (n - i -1 !=i); k--) {
                result.add(matrix[n - i - 1][k]);
            }
            // 4.从左下到左上
            for (int j = n - 2 - i; (j > i) && (m - i - 1 !=i) ; j--) {
                result.add(matrix[j][i]);
            }
        }
        return result;
    }
    // 方法2，考虑标志数组、旋转模仿方法
    public ArrayList<Integer> printMatrix1(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer> ();
        while (matrix.length != 0){
            // n表示矩阵的行，m表示矩阵的列
            int n = matrix.length, m = matrix[0].length;
            for (int i = 0; i < m; i++) {
                result.add(matrix[0][i]);
//                System.out.println(matrix[0][i]);
            }
            // 进行左旋90度
            matrix = transpose(matrix, n, m);
        }
        return result;
    }
    // 旋转函数
    public int[][] transpose(int[][] matrix, int n, int m){
        // 创建一个n-1 * m的数组
        int[][] newmatrix = new int[n - 1][m];
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                newmatrix[i][j] = matrix[i + 1][j];
            }
        }
        // 旋转
        int[][] newmatrixT = new int[m][n-1];
        for (int i = 0; i < newmatrixT.length; i++) {
            for (int j = 0; j < newmatrixT[0].length; j++) {
                newmatrixT[i][j] = newmatrix[j][m - i - 1];
            }
        }
        return newmatrixT;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        prob_20 solution = new prob_20();
        solution.printMatrix1(matrix);
    }
}
