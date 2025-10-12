package com.ming.leetcode.code.ten.day12;


import java.util.Arrays;

/**
 * @author ming
 * @description 除自身以外数组的乘积
 * @date 2025/10/12 20:17
 */
public class ProductExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: 计算左侧乘积（存入 answer）
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        // Step 2: 从右往左，乘上右侧乘积
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return answer;
    }
}