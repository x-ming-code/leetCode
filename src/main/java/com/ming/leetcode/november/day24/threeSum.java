package com.ming.leetcode.november.day24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ming
 * @description 三数之和
 * https://leetcode.cn/problems/3sum/?envType=study-plan-v2&envId=top-100-liked
 * @date 2025/11/24 11:36
 */
public class threeSum {
    /**
     * 将三数之和转化为 “两数之和” 问题！
     * 排序数组 → 便于去重和使用双指针
     * 遍历数组，固定第一个数 nums[i]
     * 在 i+1 到 n-1 范围内，用双指针找两个数，使得三数之和为 0
     * 关键：跳过重复元素，避免重复三元组
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        //先排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 如果第一个数 > 0，后面不可能和为 0
            if (nums[i] > 0) {
                break;
            }
            // 去重：跳过相同的 nums[i]
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //双指针找另外两个数
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // 找到一组解
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 关键：去重！跳过相同的 left 和 right
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    //移动指针
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // 需要更大的数
                } else {
                    right--; // 需要更小的数
                }
            }

        }
        return result;
    }
}
