package jianzhi_offer;

import java.util.ArrayList;

/**
 * @Description: 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * @Author: zf
 * @Date: 2020/1/13 17:07
 */
public class prob_43 {
    // 注意已经是排序的了，因此，从S - array[i]即为我们要查找的数，因此用二分法，如果有则直接返回即为最小的
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array.length < 2) return result;
        for (int i = 0; i < array.length; i++) {
            int rest = sum - array[i];
            int other = binsearch(array, rest, i);
            if (other != -1) {
                result.add(array[i]);
                result.add(array[other]);
                return result;
            }
        }
        return result;
    }
    public int binsearch(int[] array, int rest, int idx) {
        // 二分查找有没有
        int start = idx + 1;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (array[mid] == rest)
                return mid;
            else if (array[mid] > rest)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        prob_43 solution = new prob_43();
        int[] array = {1,2,4,7,11,15};
        int sum = 15;
        solution.FindNumbersWithSum(array, sum);
    }
}
