package Prob_1_to_Prob_50;

/**
 * @Description:
 * @Author: zf
 * @Date: 2019/8/28 14:19
 */
public class prob_28 {
    public static int strStr(String haystack, String needle) {
        // my solution
//        if (haystack.length() == 1 && needle.length()!=0 && haystack.charAt(0)==needle.charAt(0)) return 0;
//        if (haystack.length() == 1 && needle.length()==0) return -1;
//        if (haystack.length() < needle.length()) return -1;
//        if (haystack.length() == 0 && needle.length()==0) return 0;
//        int lenNeedle = needle.length();
//        for (int i = 0; i < haystack.length(); i++) {
//            if (haystack.charAt(i) == needle.charAt(0)){
//                if (lenNeedle <= haystack.length() - i){
//                    String ha = haystack.substring(i, i + lenNeedle);
//                    if (ha.equals(needle)) {
//                        System.out.println(i);
//                        return i;
//                    }
//                    continue;
//                }
//            }else {
//                continue;
//            }
//        }
//        return -1;
        // other solution
        int res = -1;
        int len = needle.length();
        int lenhay = haystack.length();
        if (len > lenhay) return -1;
        int star = 0, end = len-1;
        while (end < lenhay){
            if (haystack.substring(star, end+1).equals(needle)) return star;
            end++;
            star++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        strStr(haystack, needle);
    }
}
