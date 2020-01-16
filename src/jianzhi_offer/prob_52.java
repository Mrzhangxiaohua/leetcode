package jianzhi_offer;

/**
 * @Description: 给定一个数组A[0, 1, ..., n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * @Author: zf
 * @Date: 2020/1/15 9:52
 */
public class prob_52 {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        if (A.length == 0) return B;
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1;
        for (int i = A.length - 1; i >= 0 ; i--) {
            B[i] *= temp;
            temp *= A[i];
        }
        return B;
    }

}
