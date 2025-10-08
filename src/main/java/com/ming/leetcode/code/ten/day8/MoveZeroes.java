package com.ming.leetcode.code.ten.day8;

import java.util.Arrays;

/**
 * @author ming
 * @description 移动零
 * @date 2025/10/8 18:46
 */

public class MoveZeroes {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * 示例 1:
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 示例 2:
     * 输入: nums = [0]
     * 输出: [0]
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZeroes(new int[]{0, 1, 0, 3, 12})));
    }

    public static int[] moveZeroes(int[] nums) {
        int left = 0; // 用于放置非零元素的位置
        // 第一步：把所有非零元素移动到前面
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[left] = nums[i]; // 把非零元素放到前面
                left++; // 指向下一个应放置非零的位置
            }
        }

        // 第二步：从 left 开始，把剩下的位置填上 0
        for (int i = left; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }
}
