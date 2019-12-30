package Prob_1_to_Prob_50; /**
 * @Description: 给定一个 n × n 的二维矩阵表示一个图像。将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。 其实就是将坐标(i,j) , (j, n-i-1), (n-i-1, n-j-1), (n -j-1, i)进行变换
 * @Author: zf
 * @Date: 2019/11/5 8:59
 */
import java.lang.Math;

public class prob_48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < Math.floor(n / 2); i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp1 = 0, temp2 = 0;
                temp1 = matrix[i][j];
                temp2 = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp1;
                temp1 = temp2;
                temp2 = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = temp1;
                temp1 = temp2;
                temp2 = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = temp1;
                temp1 = temp2;
                matrix[i][j] = temp1;
                System.out.println("\n");
                for (int ii = 0; ii < matrix.length; ii++) {
                    for (int jj = 0; jj < matrix[ii].length; jj++) {
                        System.out.print(matrix[ii][jj] + "\t");
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = {{5, 1, 9,11}, {2, 4, 8,10}, {13, 3, 6, 7}, {15,14,12,16}};
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        prob_48 solution = new prob_48();
        solution.rotate(matrix);
    }
}
