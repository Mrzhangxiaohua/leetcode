package Prob_1_to_Prob_50;

/**
 * @Description:给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * @Author: zf
 * @Date: 2019/6/11 10:29
 */
public class prob_11 {
    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int width = j - i;
                int[] twoPoint = {height[i], height[j]};
                int heigh = twoPoint[0] > twoPoint[1] ? twoPoint[1] : twoPoint[0];
                int maxaera = width * heigh;
                if (max < maxaera) max = maxaera;
            }
        }
        System.out.println(max);
        return max;
    }
    public static void main(String[] args) {
        int[] x = {1,8,6,2,5,4,8,3,7};
        maxArea(x);
    }
}


// 注意该语法的适用
//maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i))；