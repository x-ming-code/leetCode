package com.ming.leetcode.code.ten.day10;

/**
 * @author ming
 * @description 和为 K 的子数组
 * @date 2025/10/10 19:45
 */

public class sum {
    public static void main(String[] args) {
        sum(new int[]{1, 1, 1}, 2);
    }

    public static int sum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
