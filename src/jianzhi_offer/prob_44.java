package jianzhi_offer;

/**
 * @Description: 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * @Author: zf
 * @Date: 2020/1/13 17:27
 */
public class prob_44 {
    public String LeftRotateString(String str,int n) {
        if (str.length() == 0 || n < 0) return str;
        // 进行移位，如果循环的次数大于长度，则取模
        n = n % str.length();
        // 转成String
        StringBuffer sb = new StringBuffer(str);
        // 字符后半段和前半段进行截取
        String before = sb.substring(0, n);
        String after = sb.substring(n, sb.length());
        // 字符串连接
        String s = after + before;
        return s;
    }

    public static void main(String[] args) {
        prob_44 solution = new prob_44();
        String strings = "abcXYZdef";
        int n = 3;
        solution.LeftRotateString(strings, n);
    }
}
