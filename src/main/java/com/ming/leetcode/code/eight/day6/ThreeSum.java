package com.ming.leetcode.code.eight.day6;

import java.util.*;

public class ThreeSum {

    /**
     * 找到数组中所有和为0的三元组，且不包含重复的三元组。
     * 
     * @param nums 输入的整数数组
     * @return 包含所有满足条件的三元组的列表
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        // 1. 对数组进行排序，这是使用双指针技术的前提
        Arrays.sort(nums);
        
        // 2. 创建一个列表来存储最终结果
        List<List<Integer>> result = new ArrayList<>();
        
        // 3. 获取数组长度
        int n = nums.length;
        
        // 4. 外层循环：遍历数组，固定第一个数 nums[i]
        for (int i = 0; i < n - 2; i++) {
            // 4.1 跳过重复的第一个数，避免产生重复的三元组
            // 因为数组已排序，所以相同的数会相邻
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // 跳过本次循环，进入下一次迭代
            }
            
            // 4.2 优化：如果当前固定的数已经大于0，由于数组已排序，
            // 后面的数都 >= nums[i] > 0，三个正数相加不可能等于0
            if (nums[i] > 0) {
                break; // 直接跳出整个外层循环，因为后面的数都更大
            }
            //
            // 4.3 设置双指针
            // left 指针从 i+1 开始（第二个数）
            int left = i + 1;
            // right 指针从数组末尾开始（第三个数）
            int right = n - 1;
            
            // 目标值：我们需要找到 nums[left] + nums[right] == -nums[i]
            int target = -nums[i];
            
            // 5. 内层循环：使用双指针在 [left, right] 范围内寻找两个数
            while (left < right) {
                int currentSum = nums[left] + nums[right]; // 计算当前两数之和
                
                if (currentSum == target) {
                    // 5.1 找到一个满足条件的三元组
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // 5.2 跳过重复的左指针值，避免重复的三元组
                    // 注意：在找到解后才进行去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++; // left 指针向右移动，跳过重复值
                    }
                    // 5.3 跳过重复的右指针值，避免重复的三元组
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--; // right 指针向左移动，跳过重复值
                    }
                    
                    // 5.4 移动双指针，寻找下一个可能的组合
                    // 因为当前组合已记录，且左右指针指向的值已被使用，
                    // 所以需要移动它们
                    left++;
                    right--;
                    
                } else if (currentSum < target) {
                    // 5.5 当前两数之和小于目标值
                    // 由于数组已排序，需要增大和，所以 left 指针右移
                    left++;
                } else {
                    // 5.6 当前两数之和大于目标值
                    // 由于数组已排序，需要减小和，所以 right 指针左移
                    right--;
                }
            }
            // 5.7 内层 while 循环结束，继续外层 for 循环
        }
        
        // 6. 返回所有找到的三元组
        return result;
    }

    // ==================== 主函数，用于测试 ====================
    public static void main(String[] args) {
        // 测试用例1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("输入: " + Arrays.toString(nums1));
        System.out.println("输出: " + threeSum(nums1));
        System.out.println(); // 换行
        
        // 测试用例2
        int[] nums2 = {0, 1, 1};
        System.out.println("输入: " + Arrays.toString(nums2));
        System.out.println("输出: " + threeSum(nums2));
        System.out.println();
        
        // 测试用例3
        int[] nums3 = {0, 0, 0};
        System.out.println("输入: " + Arrays.toString(nums3));
        System.out.println("输出: " + threeSum(nums3));
        System.out.println();
        
        // 测试用例4：空数组
        int[] nums4 = {};
        System.out.println("输入: " + Arrays.toString(nums4));
        System.out.println("输出: " + threeSum(nums4));
        System.out.println();
        
        // 测试用例5：只有一个元素
        int[] nums5 = {1};
        System.out.println("输入: " + Arrays.toString(nums5));
        System.out.println("输出: " + threeSum(nums5));
    }
}