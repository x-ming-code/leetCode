package com.ming.leetcode.code.eight.day4;

/**
 * @author ming
 * @description: 盛最多水的容器
 * @date 2023-08-04 14:01
 */
public class Solution {
    public int maxArea(int[] height) {
        // 初始化左右指针
        int left = 0;
        int right = height.length - 1;
        
        // 记录最大面积
        int maxArea = 0;

        // 双指针向中间移动
        while (left < right) {
            // 计算当前宽度
            int width = right - left;
            
            // 计算当前高度（由较短的边决定）
            int currentHeight = Math.min(height[left], height[right]);
            
            // 计算当前面积
            int area = width * currentHeight;
            
            // 更新最大面积
            maxArea = Math.max(maxArea, area);
            
            // 移动较短边的指针
            if (height[left] < height[right]) {
                left++;  // 左边短，移动左指针向右
            } else {
                right--; // 右边短或相等，移动右指针向左
            }
        }

        return maxArea;
    }

    // 测试方法
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = solution.maxArea(height);
        System.out.println("最大水量为: " + result);  // 输出: 56
    }
}