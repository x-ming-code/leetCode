package com.ming.leetcode.november.day21;

/**
 * @author ming
 * @description 移动零
 * https://leetcode.cn/problems/move-zeroes/?envType=study-plan-v2&envId=top-100-liked
 * @date 2025/11/21 17:41
 */

public class moveZeroes {
    //我们用两个指针：
    //slow（慢指针）：指向下一个非零元素应该放置的位置
    //fast（快指针）：遍历整个数组，寻找非零元素
    //把所有非零元素“紧凑”地放到前面，剩下的位置自然就是 0
    public void moveZeroes(int[] nums) {
        int slow = 0; // 下一个非零元素应放的位置
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                //将 nums[fast] 赋值给 nums[slow]
                nums[slow] = nums[fast];
                slow++;
            }
        }
        // 第二步：把 slow 及之后的位置都设为 0
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
            slow++;
        }
    }
}
