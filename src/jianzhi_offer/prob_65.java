package jianzhi_offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description: 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * @Author: zf
 * @Date: 2020/1/18 11:27
 */
public class prob_65 {
    // 采用最小堆
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void Insert(Integer num) {
        minHeap.offer(num);
        if (minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
        else {
            maxHeap.offer(minHeap.poll());
            minHeap.offer(maxHeap.poll());
        }
    }

    public Double GetMedian() {
        if (minHeap.size() == 0 && maxHeap.size() == 0)
            return null;
        if (minHeap.size() == maxHeap.size())
            return (double)(minHeap.peek() + maxHeap.peek())/2.0;
        return (double)maxHeap.peek();
    }
}
