package com.ming.leetcode.november.day17;

/**
 * @author ming
 * @description 平方数之和 https://leetcode.cn/problems/sum-of-square-numbers/description/
 * @date 2025/11/17 10:56
 */

public class judgeSquareSum {

    public boolean judgeSquareSum(int target) {
        if (target < 0) {
            return false;
        }
        long i = 0;
        long j = (long) Math.sqrt(target);
        while (i <= j) {
            long sum = i * i + j * j;
            if (sum == target) {
                return true;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
