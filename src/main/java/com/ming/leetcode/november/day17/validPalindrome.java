package com.ming.leetcode.november.day17;

/**
 * @author ming
 * @description 是否是回文数  https://leetcode.cn/problems/valid-palindrome-ii/description/
 * @date 2025/11/17 14:32
 */

public class validPalindrome {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() <= 2) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
