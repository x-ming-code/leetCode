package com.ming.leetcode.code.eight.day4;

public class MaxArea {
    public int maxArea(int[] height) {
        int left = 0; // 左指针，初始指向数组开头
        int right = height.length - 1; // 右指针，初始指向数组结尾
        int maxArea = 0; // 记录最大水量

        while (left < right) {
            // 计算当前左右指针构成的容器水量
            int currentWidth = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = currentWidth * currentHeight;

            // 更新最大水量
            if (currentArea > maxArea) {
                maxArea = currentArea;
            }

            // 移动指针：优先移动较短的边（贪心策略）
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}