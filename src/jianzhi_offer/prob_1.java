package jianzhi_offer;

/**
 * @Description: 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @Author: zf
 * @Date: 2019/12/30 21:11
 */
public class prob_1 {
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length < 1 || array[0].length < 1) {
            return false;
        }
        // 2. 进行判断
        int rows = array.length;
        int cols = array[0].length;

        int row = 0;
        int col = array[0].length - 1;
        while (row >= 0 && row < rows && col >= 0 && col < cols) {
            if (array[row][col] == target) return true;
            else if (array[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        prob_1 solution = new prob_1();
        int target = 0;
//        int[][] array = {{1,2,8,9}, {3,4,9,12},{4,5,10,13},{5,6,11,15}};
        int[][] array = {{1,2,8,9}, {2,4,9,12}};
        boolean IsContain = solution.Find(target, array);
        System.out.println(IsContain);
    }
}
