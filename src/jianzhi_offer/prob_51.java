package jianzhi_offer;

/**
 * @Description: 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * @Author: zf
 * @Date: 2020/1/14 17:16
 */
public class prob_51 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        // 特殊判断
        if(length<0) return false;
        // 创建一个等长的记录数组
        int[] counts = new int[length];
        // 遍历每个数字
        for (int i = 0; i < length; i++) {
            // 如果每个数在[0, n-1]之间
            if (numbers[i] < length && numbers[i] >=0) {
                // 判断index位置是否为2，不为2则加1
                counts[numbers[i]] += 1;
                if (counts[numbers[i]] != 2) {
                    continue;
                }
                // 否则就是找到，直接返回
                else {
                    duplication[0] = numbers[i];
                    return true;
                }
            }
            // 如果数据有不满足条件的，则进行返回
            else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        prob_51 solution = new prob_51();
        int[] numbers =  {};
        int[] duplication = new int[1];
        solution.duplicate(numbers, numbers.length, duplication);
    }
}
