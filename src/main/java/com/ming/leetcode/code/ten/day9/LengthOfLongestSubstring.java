package com.ming.leetcode.code.ten.day9;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ming
 * @description 无重复字符的最长子串
 * @date 2025/10/9 12:25
 */

public class LengthOfLongestSubstring {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
     * 示例 1:
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
     * <p>
     * 示例 2:
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     */
    public static void main(String[] args) {
        lengthOfLongestSubstring("abba");
    }

    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> charIndexMap = new HashMap<>();
        int left = 0;           // 滑动窗口左边界
        int maxLength = 0;      // 最长无重复子串长度

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // 如果当前字符在窗口中已出现过
            if (charIndexMap.containsKey(c)) {
                // 关键：left 只能向右移动，不能回退！
                left = Math.max(left, charIndexMap.get(c) + 1);
            }

            // 更新当前字符的最新位置
            charIndexMap.put(c, right);

            // 更新最大长度（窗口大小 = right - left + 1）
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }



}
