package com.ming.leetcode.november.day17;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ming
 * @description 两数之和 https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/
 * @date 2025/11/17 10:00
 */

public class towSum {
    //两数之和，数组有序的情况下
    public int[] toSum(int[] numbers, int target) {
        if (numbers == null) {
            return null;
        }
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }

    //两数之和，数组无序的情况下
    public int[] toSum1(int[] numbers, int target) {
        if (numbers == null) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int sum = target - numbers[i];
            if (map.containsKey(sum)) {
                return new int[]{map.get(sum), i};
            }
            map.put(numbers[i], i);
        }
        return null;
    }
}
