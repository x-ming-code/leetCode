package com.ming.leetcode.november.day24.day21;

/**
 * @author ming
 * @description 移动零
 * @date 2025/11/24 10:28
 */

public class moveZeroes {
    public void moveZeroes(int[] nums) {
        int slow = 0; // 记录最后一个非零位置的
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[slow] = nums[i];
                slow++;
            }
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
