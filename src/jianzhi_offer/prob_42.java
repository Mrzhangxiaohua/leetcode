package jianzhi_offer;

import java.util.ArrayList;

/**
 * @Description: 小明很喜欢数学, 有一天他在做数学作业时, 要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * @Author: zf
 * @Date: 2020/1/13 11:50
 */
public class prob_42 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int low = 1, high = 2;
        while (high > low) {
            int cur = (low + high) * (high - low + 1) / 2;
            if (cur == sum){
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i = low; i < high + 1; i++) {
                    arrayList.add(i);
                }
                result.add(arrayList);
                low = low + 1;
            }
            else if (cur < sum) {
                high = high + 1;
            }
            else {
                low = low + 1;
            }
        }
        return result;
    }
}
