package jianzhi_offer;

/**
 * @Description: 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * @Author: zf
 * @Date: 2020/1/15 10:11
 */
public class prob_53 {
    /**
     * @param str     正常的字符串
     * @param pattern 用于匹配的正则表达式
     * @return boolean
     */
    public boolean match(char[] str, char[] pattern) {
        // 特殊条件,当第一个不为空，第二个为空，则false
        if (pattern == null || str == null) return false;
        int strIndex = 0, patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        // 有效性检测，str和pattern都到尾部
        if (strIndex == str.length && patternIndex == pattern.length) return true;
        // 如果pattern先到末尾，那么匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) return false;
        // 当第二个字符是为“*”时候
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            // str保证不越界且当前可匹配上 &&(正好匹配 || 匹配上.)   aaa 与 aa*ac*a, .*ac*a, a.*ac*a, ab*ac*a
            if (strIndex != str.length && ((pattern[patternIndex] == str[strIndex])|| pattern[patternIndex] == '.')){
                // TODO
                return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移两位，str不变
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2) // 匹配上一次字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex);
            }
            else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        // 当第二个字符不是为“*”时候, 正好匹配上 || 匹配上. aaa 与 a.a
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (strIndex != str.length && pattern[patternIndex] == '.')) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
}
