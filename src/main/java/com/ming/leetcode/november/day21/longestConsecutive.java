package com.ming.leetcode.november.day21;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ming
 * @description 最长连续子序列
 * https://leetcode.cn/problems/longest-consecutive-sequence/?envType=study-plan-v2&envId=top-100-liked
 * @date 2025/11/21 16:06
 */

public class longestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        //将数组添加到set集合中天然去重
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        //全局最大连续长度
        int maxLength = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                // 向右扩展连续序列
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                // 更新最大长度
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
}
