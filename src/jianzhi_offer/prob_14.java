package jianzhi_offer;

import java.util.Arrays;

/**
 * @Description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @Author: zf
 * @Date: 2020/1/3 21:08
 */
public class prob_14 {
    public void reOrderArray(int [] array) {
        // 1. 特殊情况判断
        if (array.length == 0) array=new int[]{};
        // 2. 定义两个奇数和偶数数组
        int[] odd = new int[array.length];
        int[] even = new int[array.length];
        // 3. 遍历放
        int oddIndex = 0;
        int evenIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0){
                array[oddIndex++] = array[i];
            }else {
                even[evenIndex++] = array[i];
            }
        }
        for (int i = oddIndex; i < array.length; i++) {
            array[i] = even[i - oddIndex];
        }
        System.out.println(array);
    }

    public static void main(String[] args) {
        prob_14 solution = new prob_14();
        int[] array = {};
        solution.reOrderArray(array);
    }
}
