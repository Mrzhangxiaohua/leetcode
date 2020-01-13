package jianzhi_offer;

/**
 * @Description: 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @Author: zf
 * @Date: 2020/1/10 16:13
 */
public class prob_34 {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;
        int mult2_Idx = 0, mult3_Idx = 0, mult5_Idx = 0;
        int[] UglyNumber = new int[index];
        UglyNumber[0] = 1;
        for (int i = 1; i < index; i++) {
            int min = Math.min(Math.min(UglyNumber[mult2_Idx] * 2, UglyNumber[mult3_Idx] * 3), UglyNumber[mult5_Idx] * 5);
            UglyNumber[i] = min;
            while (UglyNumber[mult2_Idx] * 2 <= UglyNumber[i])
                mult2_Idx++;
            while (UglyNumber[mult3_Idx] * 3 <= UglyNumber[i])
                mult3_Idx++;
            while (UglyNumber[mult5_Idx] * 5 <= UglyNumber[i])
                mult5_Idx++;
        }
        return UglyNumber[index-1];
    }

    public static void main(String[] args) {
        prob_34 solution = new prob_34();
        solution.GetUglyNumber_Solution(5);
    }
}
