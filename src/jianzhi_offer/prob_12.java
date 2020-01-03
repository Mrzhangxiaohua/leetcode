package jianzhi_offer;

/**
 * @Description: 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @Author: zf
 * @Date: 2020/1/3 15:34
 */
public class prob_12 {
    // 1.使用内置函数进行转换成二进制再计算
    public int NumberOf1(int n) {
        // 1. 将整数转成二进制字符串
        String binary = Integer.toBinaryString(n);
        // 2. 转成字符串数组
        char[] binaryArray = binary.toCharArray();
        // 3. 进行统计
        int count = 0;
        for (int i = 0; i < binaryArray.length; i++) {
            if (binaryArray[i] == '1'){
                count ++;
            }
        }
//        System.out.println(count);
        return count;
    }
    // 2.使用逻辑移位法
    public int NumberOf2(int n) {
        int count = 0;
        // 移位操作，>>表示有符号右移动，>>>表示无符号右移，& 表示
        while (n != 0){
            count += n&1;
            n = n>>>1;
        }
        return count;
    }
    public static void main(String[] args) {
        prob_12 solution = new prob_12();
        System.out.println(-2 >>> 1);
        System.out.println((long)Math.pow(2, 31));
        System.out.println(solution.NumberOf2(11));
    }
}
