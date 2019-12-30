package Prob_1_to_Prob_50;

/**
 * @Description:将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * @Author: zf
 * @Date: 2019/6/14 10:52
 */
public class prob_6 {
    public static String convert(String s, int numRows) {
        if (s.length() <= 1) return s;
        if (numRows == 1 ||s.length() <= numRows) return s;
        // 开辟多大的数组?
        int colum1 = s.length() / (numRows - 2 + numRows) * (numRows - 1) == 0?1 : s.length() / (numRows - 2 + numRows) * (numRows - 1);
        int colum2 = s.length() % (numRows - 2 + numRows);
        int restColum = 0;
        if (colum2 == 0){
            restColum = 0;
        }else {
            if (colum2>numRows){
                restColum = colum2 -numRows + 1;
            }else if (colum2 <= numRows){
                restColum = 1;
            }else {
                restColum = colum2 -numRows + 1;
            }
        }
        int colum = colum1 + restColum + 1;
        System.out.printf("开辟的数组大小为 %d * %d", numRows, colum);
        char[][] data = new char[numRows][colum];
//        if (numRows > colum) return s;
        // 扩充
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((i + numRows) > s.length()){
                sb.append(s.substring(i, s.length()));
            }else {
                sb.append(s.substring(i, i + numRows));
            }
            i = i + numRows - 1;
            // 对中间列进行处理
            for (int j = 0; j < numRows - 2; j++) {
                i = i + 1;
                if (i < s.length()){
                    for (int k = 0; k < numRows; k++) {
                        int index = numRows - (i % (numRows - 1) ) - 1;

                        if (k != index){
                            sb.append(" ");
                        }else {
                            sb.append(s.charAt(i));
                        }
                    }
                }else {
                    break;
                }

            }
        }
        if (sb.length() <= numRows * colum){
            for (int i = 0; i < numRows * colum - sb.length() + 2; i++) {
                sb.append(" ");
            }
        }
        sb.append("                                                                                                         ");
        System.out.println(sb.length());
        int idx = 0;
        for (int i = 0; i < colum; i++) {
            for (int j = 0; j < numRows; j++) {
                data[j][i] = sb.charAt(idx++);
            }
        }
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < colum; j++) {
                sb1.append(data[i][j]);
            }
        }
//        System.out.println(sb1.toString().replace(" ",""));
        return sb1.toString().replace(" ","");
    }

    public static void main(String[] args) {
        convert("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.", 4);
    }
}


