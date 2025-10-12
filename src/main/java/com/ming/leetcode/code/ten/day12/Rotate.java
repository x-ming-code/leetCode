package com.ming.leetcode.code.ten.day12;

import java.util.Arrays;

/**
 * @author ming
 * @description 转轮数组
 * @date 2025/10/12 16:23
 */

public class Rotate {
    /**
     * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     * 示例 1:
     * 输入：nums = [-1,-100,3,99], k = 2
     * 输出：[3,99,-1,-100]
     * 解释:
     * 向右轮转 1 步: [99,-1,-100,3]
     * 向右轮转 2 步: [3,99,-1,-100]
     */

    public static void main(String[] args) {
        rotate(new int[]{-1, -100, 3, 99}, 2);
    }

    public static void rotate(int[] nums, int k) {
        if (k > nums.length || k == 0) {
            return;
        }
        int n = nums.length;
        k = k % n;
        //反转全部
        reverse(nums, 0, n - 1);
        //反转前k个
        reverse(nums, 0, k - 1);
        //反转后 n - k 个元素
        reverse(nums, k, n - 1);
        System.out.println(Arrays.toString(nums));
        return;
    }

    /**
     * 例演示（示例 1）
     * 输入：nums = [1,2,3,4,5,6,7], k = 3
     * k = 3 % 7 = 3
     * 反转全部：[7,6,5,4,3,2,1]
     * 反转前 3 个：[5,6,7,4,3,2,1]
     * 反转后 4 个（索引 3~6）：[5,6,7,1,2,3,4]
     */
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            //用临时变量 temp 保存 nums[start]
            int temp = nums[start];
            //把 nums[end] 放到 nums[start] 位置
            nums[start] = nums[end];
            //把temp（原 nums[start]）放到 nums[end] 位置
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
