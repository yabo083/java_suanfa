package com.leetcode;

import java.util.PriorityQueue;

class lc295_MedianFinder {

    private PriorityQueue<Integer> maxHeap, minHeap;

    public lc295_MedianFinder() {
        // 1. 一个大根堆，存较小的那半堆数
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // 2. 一个小根堆，存较大的那半堆数（默认）
        minHeap = new PriorityQueue<>();

    }

    public void addNum(int num) {
        // 1. 如果大根堆为空，直接先加大根堆；
        //     或者如果新值比大根堆堆顶还小，那也给我进来！
        if (maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.offer(num);
        else
            minHeap.offer(num);
        balance();
        // 2. 除此之外，就去小根堆吧
        // 3. 平衡一下（辅助函数）
    }

    private void balance() {
        // 1. 如果两堆的数量差值达到2（不可能跃升，因为是一个一个进来的），
        //      那么谁的多，就匀给少的一个（啊，一个就够了，差值不超过一就行）
        if (Math.abs(maxHeap.size() - minHeap.size()) == 2){
            if (maxHeap.size() > minHeap.size())
                minHeap.offer(maxHeap.poll());
            else
                maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        // 1. 如果两堆数量相等，说明此时总数为偶数，中位数将由两堆堆顶求平均产生
        //      如果不等，那谁的数量多，中位数就是谁的堆顶
        if (maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else
            return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
    }
}
