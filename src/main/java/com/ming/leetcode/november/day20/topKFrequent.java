package com.ming.leetcode.november.day20;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author ming
 * @description 前K个高频元素
 * https://leetcode.cn/problems/top-k-frequent-elements/
 * @date 2025/11/20 10:43
 */

public class topKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //先将每个数字出现的频率统计出来
        for (int num : nums) {
            //map.getOrDefault(num, 0) + 1 根据key获取对应的值，key不存在则为零，存在则加1
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 2. 用最小堆维护前 k 个高频元素 堆里不能只存数字，因为我们要按频率比较！
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) ->
                //堆中元素 a 和 b 比较时，按它们在 Map 中的频率从小到大排 → 最小堆！
                map.get(a) - map.get(b));

        // 然后遍历所有数字
        for (Integer num : map.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // 弹出频率最低的
            }
        }
        // 去除结果
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }
}
