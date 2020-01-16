package jianzhi_offer;

/**
 * @Description: 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @Author: zf
 * @Date: 2020/1/15 11:28
 */
public class prob_54 {
    boolean hasInt = false;

    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) return false;
        return scanA(str, 0);
    }

    public boolean scanA(char[] str, int index) {
        // 1.如果A含有符号
        if (str[index] == '+' || str[index] == '-') index ++;
        // 判断当前位数在0-9之间，且保证数组不越界
        while (index < str.length && str[index] - '0' <= 9 && str[index] - '0' >= 0) {
            hasInt = true;
            index ++;
        }
        // 当已经到达边界，则停止
        if (index == str.length) return hasInt;
        // 当遇到小数点
        if (str[index] == '.') {
            //进行判断后面的合法性
            return scanB(str, index + 1);
        }
        // 当遇到'E|e'
        else if (str[index] == 'E' || str[index] == 'e') {
            return scanC(str, index + 1);
        }
        return false;
    }
    // 判断第二个位置
    public boolean scanB(char[] str, int index) {
        boolean hasNum = false;
        if (index == str.length) return hasInt || hasNum;
        while (index < str.length && str[index]-'0' <= 9 && str[index]-'0' >= 0) {
            hasNum = true;
            index ++;
        }
        if(index == str.length) return hasInt || hasNum;
        if(str[index] == 'e' || str[index] == 'E')
            return (hasInt || hasNum) && scanC(str,index+1);
        else
            return false;
    }
    public boolean scanC(char[] str, int index) {
        boolean hasNum = false;
        if(index == str.length) return false;
        if(str[index]=='+'||str[index]=='-') index++;
        while(index < str.length && str[index]-'0' <= 9 && str[index]-'0' >= 0){
            hasNum=true;
            index++;
        }
        if (index == str.length) return hasNum;
        else return false;
    }

    public static void main(String[] args) {
        prob_54 solution = new prob_54();
        String s = "100";
        solution.isNumeric(s.toCharArray());
    }
}
