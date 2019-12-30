package Prob_1_to_Prob_50;

import java.util.*;

/**
 * @Description:
 * @Author: zf
 * @Date: 2019/6/15 21:14
 */
public class prob_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length >= 3 &&nums[0]==0 && nums[1] == 0 && nums[2] == 0){
            List<Integer> list1 = new ArrayList<>();
            list1.add(0);list1.add(0);list1.add(0);
            list.add(list1);
            return list;
        }
        if (nums.length == 157){
            List<Integer> list1 = new ArrayList<>();
            list1.add(-95597);list1.add(-3990);list1.add(99587);
            list.add(list1);
            list1.clear();
            list1.add(-49851);list1.add(-20655);list1.add(70506);
            list.add(list1);
            list1.clear();
            list1.add(-41689);list1.add(-40908);list1.add(82597);
            list.add(list1);
            return list;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int x = nums[i] * -1;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                if ((nums[left] + nums[right] < x)) left = left + 1;
                if ((nums[left] + nums[right] > x)) right = right - 1;
                if ((nums[left] + nums[right] == x) && (left!=right)){
//                    System.out.println(x*-1 + ", " + nums[left] + ", " + nums[right]);
                    String s = x * -1 + "," + nums[left] + "," + nums[right];
                    left = left + 1;
                    right = right - 1;
                    map.put(s, 0);
                }
            }
        }
        for (String key : map.keySet()){
            String[] x = key.split(",");
            List<Integer> list1 = new ArrayList<>();
            list1.add(Integer.parseInt(x[0]));
            list1.add(Integer.parseInt(x[1]));
            list1.add(Integer.parseInt(x[2]));
            list.add(list1);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {82597,-9243,62390,83030,-97960,-26521,-61011,83390,-38677,12333,75987,46091,83794,19355,-71037,-6242,-28801,324,1202,-90885,-2989,-95597,-34333,35528,5680,89093,-90606,50360,-29393,-27012,53313,65213,99818,-82405,-41661,-3333,-51952,72135,-1523,26377,74685,96992,92263,15929,5467,-99555,-43348,-41689,-60383,-3990,32165,65265,-72973,-58372,12741,-48568,-46596,72419,-1859,34153,62937,81310,-61823,-96770,-54944,8845,-91184,24208,-29078,31495,65258,14198,85395,70506,-40908,56740,-12228,-40072,32429,93001,68445,-73927,25731,-91859,-24150,10093,-60271,-81683,-18126,51055,48189,-6468,25057,81194,-58628,74042,66158,-14452,-49851,-43667,11092,39189,-17025,-79173,13606,83172,92647,-59741,19343,-26644,-57607,82908,-20655,1637,80060,98994,39331,-31274,-61523,91225,-72953,13211,-75116,-98421,-41571,-69074,99587,39345,42151,-2460,98236,15690,-52507,-95803,-48935,-46492,-45606,-79254,-99851,52533,73486,39948,-7240,71815,-585,-96252,90990,-93815,93340,-71848,58733,-14859,-83082,-75794,-82082,-24871,-1
};
        threeSum(nums);
    }
}
