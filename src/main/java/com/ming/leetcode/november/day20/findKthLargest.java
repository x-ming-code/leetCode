package com.ming.leetcode.november.day20;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ming
 * @description 数组中的第K个大的元素
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
 * @date 2025/11/20 9:45
 */

public class findKthLargest {
    //最小堆实现
    //offer(x)：把元素 x 加入堆 → 自动调整结构，保持堆性质
    //poll()：移除并返回 堆顶元素（最小值）
    //peek()：只看堆顶，不移除
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);//遍历数组将数据添加到堆中
            if (minHeap.size() > k) {//排序好的堆的长度大于k，就将堆顶元素移出，也就是最小的元素移出
                minHeap.poll();
            }

        }
        return minHeap.peek();
    }
    //自带函数排序之际返回
/*    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }*/


}
