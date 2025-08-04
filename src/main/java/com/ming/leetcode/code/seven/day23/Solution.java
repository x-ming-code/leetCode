package com.ming.leetcode.code.seven.day23;

import javax.swing.text.ViewFactory;
import java.util.HashSet;
import java.util.Set;

class Solution {
    /**
     * 最长连续序列
     * 示例 1：
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * <p>
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * 示例 2：
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     * <p>
     * 示例 3：
     * 输入：nums = [1,0,1,2]
     * 输出：3
     */


    public static int longestConsecutive(int[] nums) {
        // 将数组添加到HashSet集合中 天然去重
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        // 用于记录最大的连续值
        int longest = 0;

        for (int num : numSet) {

            // 只有当数组中的前一个数字不存在才开始计数
            // set.contains(num - 1) 前一个数字存在 取反 不存在
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                // 记录当前的最大连续值  计数器
                int currentStreak = 1;

                // 向后查找连续的数字 如果值存在则当前数加一 计数器加一
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                // 只获取当前最大的连续值
                longest = Math.max(longest, currentStreak);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2})); // 输出: 4
    }
}