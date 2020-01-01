package jianzhi_offer;

/**
 * @Description: 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @Author: zf
 * @Date: 2020/1/1 16:20
 */
public class prob_2 {
    public String replaceSpace(StringBuffer str) {
        // 1.返回的字符
        StringBuffer sb = new StringBuffer();
        // 2.当字符串长度为0或者1
        if (str.length() == 0) return str.toString();
        // 3.当大于1
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
            if (str.charAt(i) != ' '){
                sb.append(str.charAt(i));
            }else {
                sb.append("%20");
            }
        }
//        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        prob_2 solution = new prob_2();
        String s = " ";
        StringBuffer sb = new StringBuffer(s);
        solution.replaceSpace(sb);
    }
}
