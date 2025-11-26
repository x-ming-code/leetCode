package com.ming.leetcode.november.day26;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @description 找到所有字符串中的所有字母异位词
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked
 * @date 2025/11/26 17:22
 */

public class findAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] windowCount = new int[26];
        int pLen = p.length();

        // 统计 p 的字符频次
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // 初始化第一个窗口 [0, pLen-1]
        for (int i = 0; i < pLen; i++) {
            char c = s.charAt(i);
            windowCount[c - 'a']++;
        }

        // 计算初始 matches
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (pCount[i] == windowCount[i]) {
                matches++;
            }
        }

        if (matches == 26) {
            result.add(0);
        }

        // 滑动窗口：i 是新加入的右边界
        for (int i = pLen; i < s.length(); i++) {
            char newChar = s.charAt(i);          // 新加入的字符
            char oldChar = s.charAt(i - pLen);   // 要移除的字符

            // 处理新字符
            int idxNew = newChar - 'a';
            windowCount[idxNew]++;
            if (windowCount[idxNew] == pCount[idxNew]) {
                matches++;
            } else if (windowCount[idxNew] == pCount[idxNew] + 1) {
                matches--; // 原来是匹配的，现在多了一个
            }

            // 处理旧字符
            int idxOld = oldChar - 'a';
            windowCount[idxOld]--;
            if (windowCount[idxOld] == pCount[idxOld]) {
                matches++;
            } else if (windowCount[idxOld] == pCount[idxOld] - 1) {
                matches--; // 原来是匹配的，现在少了一个
            }

            // 检查是否完全匹配
            if (matches == 26) {
                result.add(i - pLen + 1);
            }
        }

        return result;
    }
}
