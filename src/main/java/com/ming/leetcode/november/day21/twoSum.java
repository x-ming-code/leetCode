package com.ming.leetcode.november.day21;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ming
 * @description 两数之和
 *  https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-100-liked
 * @date 2025/11/21 15:23
 */

public class twoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = target - nums[i];
            if (map.containsKey(sum)) {
                return new int[]{map.get(sum), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
