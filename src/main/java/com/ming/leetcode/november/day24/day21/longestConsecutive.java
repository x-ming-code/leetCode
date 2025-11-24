package com.ming.leetcode.november.day24.day21;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ming
 * @description 回顾最长连续子序列
 * @date 2025/11/24 9:39
 */

public class longestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int maxLength = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (Integer s : set) {
            if (!set.contains(s - 1)) {
                int currentNum = s;
                int currentLength = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
}
