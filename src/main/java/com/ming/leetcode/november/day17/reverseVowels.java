package com.ming.leetcode.november.day17;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ming
 * @description 反转字符串中的元音字母 https://leetcode.cn/problems/reverse-vowels-of-a-string/description/
 * @date 2025/11/17 11:43
 */

public class reverseVowels {

    public String reverseVowels(String s) {
        if (s.length() == 0 || s == null) {
            return null;
        }
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        int left = 0;
        int right = s.length() - 1;

        char[] chars = s.toCharArray();
        while (left < right) {
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
