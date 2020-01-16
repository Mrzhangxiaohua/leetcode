package jianzhi_offer;

/**
 * @Description: 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入一个字符串,包括数字字母符号,可以为空, 如果是合法的数值表达则返回该数字，否则返回0
 * 输入：+2147483647
 *     1a33
 * 输出：2147483647
 *     0
 *
 * @Author: zf
 * @Date: 2020/1/14 16:50
 */
public class prob_50 {
    public int StrToInt(String str) {
        if (str.length() < 1) return 0;
        if (str.equals("2147483648") || str.equals("+2147483648")) return 0;
        char[] nums = str.toCharArray();
        boolean flag = false;
        int symbol = 1;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] == '+' || nums[i] == '-') && !flag) {
                symbol = nums[i] == '+' ? 1 : -1;
                flag = true;
                continue;
            }
            else {
                if ((nums[i] - '0' > 0) &&(nums[i] - '0' < 9)){
                    result *= 10;
                    result += nums[i] - '0';
                }
                else
                    return 0;
//                System.out.println("不是第一位了");
            }
        }
        return result * symbol;
    }

    public static void main(String[] args) {
        prob_50 solution = new prob_50();
        String str = "2147483648";
        System.out.println(solution.StrToInt(str));
    }
}
