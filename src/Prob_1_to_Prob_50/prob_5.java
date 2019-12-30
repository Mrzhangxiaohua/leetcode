package Prob_1_to_Prob_50;

/**
 * @Description:给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * @Author: zf
 * @Date: 2019/6/12 21:01
 */
public class prob_5 {
    // 1，暴力法
    public static String longestPalindrome1(String s) {
        if (s.equals("")) return "";
        int maxlength = 0;
        String palindrome = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String s1 = s.substring(i, j);
                if (palindrome.length() > s1.length()) break;
                boolean flag = judge(s1);
//                System.out.println(s1);
//                System.out.println(flag);
                if (flag) {
                    if (maxlength < s1.length()) {
                        maxlength = s1.length();
                        palindrome = s1;
                    }else {
                        continue;
                    }
                }
            }
        }
        return palindrome;
    }
    public static boolean judge(String s1){
        boolean flag = true;
        for (int i = 0; i < s1.length()/2 ; i++) {
            if (s1.charAt(i) == s1.charAt(s1.length() - 1 - i)){
                continue;
            }else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static String longestPalindrome(String s) {
        if(s==null||s.length()<2)return s;
        String ns = INIT(s);
        int[] Len = new int[ns.length()];
        int mx = 0,ans = 0,po = 0,jj = 0;
        for(int i = 0;i<ns.length();i++){
            if(mx > i){ Len[i] = Math.min(mx-i,Len[2*po-i]);}
            else Len[i] = 1;
            while((i-Len[i]>0) && (i+Len[i]<ns.length()) && ns.charAt(i-Len[i])==ns.charAt(i+Len[i])){
                Len[i]++;
            }
            if(Len[i]+i>mx){
                mx = Len[i]+i;
                po = i;
            }
            if(Len[i]>ans){
                ans = Len[i];
                jj = i;
            }
        }
        int start = jj - (ans - 1) ;
        int end = jj + (ans - 1);
        return ns.substring(start, end + 1).replace("#", "");
    }
    public static String INIT(String s){
        char[] output = new char[s.length()*2+1];
        for(int i = 0;i<=2*s.length();i+=2){
            output[i] = '#';
            if(i!=2*s.length())output[i+1] = s.charAt(i/2);
        }
        return new String(output);
    }
    public static void main(String[] args) {
        longestPalindrome("abba");
    }
}
