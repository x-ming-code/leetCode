package com.ming.leetcode.code.ten.day8;

import java.util.Arrays;

/**
 * @author ming
 * @description 两数之和
 * @date 2025/10/8 16:08
 */

public class sum {
    //输入：nums = [2,7,11,15], target = 9
    //输出：[0,1]
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return nums;
    }

}
