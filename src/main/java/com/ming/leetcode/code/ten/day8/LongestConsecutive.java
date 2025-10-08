package com.ming.leetcode.code.ten.day8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ming
 * @description 最长连续序列
 * @date 2025/10/8 18:29
 */

public class LongestConsecutive {
    /**
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * 示例 2：
     *
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Integer maxLength = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (Integer i : set) {
            if (!set.contains(i - 1)) {
                int currentNum = i;
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
