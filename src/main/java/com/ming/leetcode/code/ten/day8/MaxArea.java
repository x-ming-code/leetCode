package com.ming.leetcode.code.ten.day8;

/**
 * @author ming
 * @description 盛最多水的容器
 * @date 2025/10/8 19:39
 */

public class MaxArea {
    /**
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，
     * 容器能够容纳水（表示为蓝色部分）的最大值为 49。
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] nums) {
        //初始化双指针
        int left = 0;
        int right = nums.length - 1;
        int maxArea = 0;

        //当两个指针相遇时停止
        while (left < right) {
            // 计算当前容器的宽度和高度
            int width = right - left;
            int minHeight = Math.min(nums[left], nums[right]);
            int currentArea = width * minHeight;

            //更新最大面积
            maxArea = Math.max(maxArea, currentArea);

            //移动较短边的指针
            if (nums[left] < nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
