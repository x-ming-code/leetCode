package com.ming.leetcode.code.day23;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ming
 * @description 移动零
 * @date 2025/7/23 11:22
 */

public class MoveZeroes {
    /**
     * 示例 1:
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * <p>
     * 示例 2:
     * 输入: nums = [0]
     * 输出: [0]
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZeroes(new int[]{2, 0, 1})));
    }

    /**
     * 思路
     * 新建一个变量初始值为0 用于放置非零元素索引
     * 循环遍历数组
     *      遍历的过程中判断数组中的元素是否是0 nums[i] != 0
     *          是就跳过 不是0就将当前的元素赋给当前数组的前一个
     */
    public static int[] moveZeroes(int[] nums) {
        int left = 0; // 用于放置非零元素的位置

        // 第一步：把所有非零元素移动到前面
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[left] = nums[i];
                left++;
            }
        }

        // 第二步：从 left 开始，把剩下的位置填上 0
        for (int i = left; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }


    //练习
    public static int[] move(int[] array) {
        if (array == null || array.length == 0) {
            return new int[]{};
        }
        int left = 0; //用于记录下一个非0的索引
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                array[left] = array[i];
                left++;
            }
        }

        for (int i = left; i < array.length; i++) {
            array[i] = 0;
        }
        return array;


    }
}
