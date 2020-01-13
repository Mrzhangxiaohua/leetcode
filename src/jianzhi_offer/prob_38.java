package jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 统计一个数字在排序数组中出现的次数。
 * @Author: zf
 * @Date: 2020/1/12 17:12
 */
public class prob_38 {
    public int GetNumberOfK(int [] array , int k) {
        // 1.二分查找找到第一个出现的位置
        int start = 0, end = array.length - 1, index = -1;
        // 先特殊判断
        if (array.length == 0) return 0;
        while (start != end) {
            int mid = (end + start) / 2;
            if (array[mid] > k){
                end = mid - 1;
            }else if (array[mid] < k) {
                start = mid + 1;
            }else {
                index = mid;
                break;
            }
        }
        int count = count_all(array, index, k);
        return count;
    }
    public int count_all(int[] array, int index, int k) {
        int count = 0;
        for (int i = index; i >=0 ; i--) {
            if (array[index] == k) {
                count++;
            }else {
                break;
            }
        }
        for (int i = index + 1; i < array.length; i++) {
            if (array.length > i && array[index] == k){
                count ++;
            }else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        prob_38 solution = new prob_38();
        int[] array = {1,2,2,3,3,3};
        solution.GetNumberOfK(array, 3);
    }
}
