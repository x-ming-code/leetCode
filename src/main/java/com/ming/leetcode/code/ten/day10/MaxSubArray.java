package com.ming.leetcode.code.ten.day10;

/**
 * @author ming
 * @description 最大子数组和
 * @date 2025/10/10 20:28
 */

public class MaxSubArray {
    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），
     * 返回其最大和。子数组是数组中的一个连续部分。
     * 示例 1：
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * <p>
     * 示例 2：
     * 输入：nums = [1]
     * 输出：1
     */

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }


    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("数组不能为空");
        }
        int currentMax = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);
        }
        return maxSum;
    }
}
