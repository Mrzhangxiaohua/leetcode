package Prob_1_to_Prob_50;

/**
 * @Description:
 * @Author: zf
 * @Date: 2019/6/9 9:22
 */
public class prob_8 {
    public static int myAtoi(String str) {
        String str_with_no_space = str.trim();
        int len = str_with_no_space.length();
        if (len==0)return 0;
        char c = '-';
        char symbol = str_with_no_space.charAt(0);
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        // 判断首位是否为正负号
        if (symbol == c) {
            int flag = -1;
            if (len == 1) return 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < len; i++) {
                if ((int)str_with_no_space.charAt(i) >= '0' && (int)str_with_no_space.charAt(i)<='9'){
                    sb.append(str_with_no_space.charAt(i));
                }else {
                    break;
                }
            }
//            System.out.println(sb);
            if (sb.length() == 0) return 0;
            try {
                if (Integer.parseInt(String.valueOf(sb)) * -1 >= min) return Integer.parseInt(String.valueOf(sb)) * -1;
            }catch (Exception e){
                return min;
            }
        }else if (symbol == '+'){
            int flag = 1;
            if (len == 1) return 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < len; i++) {
                if ((int)str_with_no_space.charAt(i) >= '0' && (int)str_with_no_space.charAt(i)<='9'){
                    sb.append(str_with_no_space.charAt(i));
                }else {
                    break;
                }
            }
            System.out.println(Integer.parseInt(String.valueOf(sb)));
            if (sb.length() == 0) return 0;
            try {
                if (Integer.parseInt(String.valueOf(sb)) <= max) return Integer.parseInt(String.valueOf(sb));
            }catch (Exception e){
                return max;
            }
        }else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                if ((int)str_with_no_space.charAt(i) >= '0' && (int)str_with_no_space.charAt(i)<='9'){
                    sb.append(str_with_no_space.charAt(i));
                }else {
                    break;
                }
            }
            if (sb.length() == 0) return 0;
//            System.out.println(Integer.parseInt(String.valueOf(sb)));
            try {
                if (Integer.parseInt(String.valueOf(sb)) <= max) return Integer.parseInt(String.valueOf(sb));
            }catch (Exception e){
                return max;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        myAtoi("   +0 123");
    }
}
