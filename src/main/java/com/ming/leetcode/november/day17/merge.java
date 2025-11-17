package com.ming.leetcode.november.day17;

/**
 * @author ming
 * @description 合并两个有序数组 https://leetcode.cn/problems/merge-sorted-array/
 * @date 2025/11/17 17:00
 */

public class merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // nums1 有效部分的末尾
        int j = n - 1; // nums2 有效部分的末尾
        int k = m + n - 1; // nums1 整体的末尾（写入位置）

        //从后向前合并
        // 只要 nums1 和 nums2 都还有未处理的元素（i >= 0 且 j >= 0），就继续
        while (i >= 0 && j >= 0) {
            //比较当前两个数组的“最大剩余元素”：
            //如果 nums1[i] > nums2[j] → 把 nums1[i] 放到 nums1[k]
            //否则 → 把 nums2[j] 放到 nums1[k]
            //对应指针前移（i-- 或 j--），写入位置 k--
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        // 如果 nums2 还有剩余元素，复制到 nums1 开头
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
        // 注意：如果 nums1 有剩余，它已经在正确位置，无需操作！
    }
}
