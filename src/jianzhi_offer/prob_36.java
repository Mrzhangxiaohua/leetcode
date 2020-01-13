package jianzhi_offer;

/**
 * @Description: 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * @Author: zf
 * @Date: 2020/1/10 17:08
 */
public class prob_36 {
    // 方法1，暴力破解
    public int InversePairs(int[] array) {
        int count = 0;
        if (array.length == 0 || array.length == 1) return 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j])
                    count++;
            }
        }
        return count;
    }

    // 方法2，归并
    public int InversePairs1(int[] array) {
        if (array == null || array.length == 0) return 0;
        int length = array.length;
        int[] copy = new int[length];
        for (int i = 0; i < length; i++) {
            copy[i] = array[i];
        }
        int count = InversePairsCore(array, copy, 0, array.length - 1);
        return count;
    }

    public int InversePairsCore(int[] array, int[] copy, int start, int end) {
        if (start == end) return 0;
        int count = 0, length = (end - start) / 2;
        int left = InversePairsCore(copy, array, start, start + length);
        int right = InversePairsCore(copy, array, start + length + 1, end);
        int p1 = start + length, p2 = end;
        int copyIdx = end;
        while (p1 >= start && p2 >= start + length + 1) {
            if (array[p1] > array[p2]) {
                count += p2 -start - length;
                if (count > 1000000007)
                    count = count%1000000007;
                copy[copyIdx--] = array[p1--];
            }
            else {
                copy[copyIdx--] = array[p2--];
            }
        }
        while (p1 >= start) {
            copy[copyIdx--] = array[p1--];
        }
        while(p2 >= start+length+1){
            copy[copyIdx--] = array[p2--];
        }
        return (count+left+right)%1000000007;
    }

    public static void main(String[] args) {
        prob_36 solution = new prob_36();
        int[] array = {7,5,6,4};
        solution.InversePairs1(array);
    }
}
