package com.ming.leetcode.november.day21.day20;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ming
 * @description 回顾20 数组中第K大元素
 * @date 2025/11/21 9:14
 */

public class findKthLargest {

    public Integer findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < 0) {
            return 0;
        }
        Arrays.sort(nums);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
