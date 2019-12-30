package Prob_1_to_Prob_50;

/**
 * @Description: 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * @Author: zf
 * @Date: 2019/6/4 14:54
 */
public class prob_7 {
    public static int reverse(int x) {
        try {
            if (x < Integer.MIN_VALUE || x > Integer.MAX_VALUE) return 0;
            int flag = x>0?1:-1;
            int xx = Math.abs(x);
            String string = String.valueOf(xx);
            int len = string.length();
            char[] chars = new char[len];
            for (int i = len-1; i >= 0; i--) {
                chars[len - i - 1] = string.charAt(i);
            }

            int index = 0;
            for (int i = 0; i < len; i++) {
                if ('0'==chars[i]){
                    continue;
                }else {
                    index = i;
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = index; i < len; i++) {
                sb.append(chars[i]);
            }
            System.out.println(sb);
            int fin = Integer.parseInt(String.valueOf(sb)) * flag;
            return fin;
        }catch (Exception e){
            return 0;
        }

    }

    public static int reverse1(int x){
        int rev = 0;
        while (x!=0){
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))return 0;
            rev = rev* 10 + pop;
        }
        System.out.println(rev);
        return rev;
    }
    public static void main(String[] args) {
        reverse(321);
    }
}
