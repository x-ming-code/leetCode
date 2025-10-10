package com.ming.leetcode.code.ten.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ming
 * @description 找到字符串中所有字母异位词
 * @date 2025/10/10 18:15
 */

public class FindAnagrams {
    /**
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * 示例 1:
     * <p>
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
     */
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        //创建两个长度为26的数组，用于统计a-z的字符频次
        int[] pCount = new int[26]; //目标p的字符频次
        int[] windowCount = new int[26]; // 滑动窗口中当前子串的字符频次

        //初始化p的字符频次
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        int pLength = p.length();

        //遍历字符串s，构建滑动窗口
        for (int i = 0; i < s.length(); i++) {
            //将当前字符s[i]加入窗口
            char currentChar = s.charAt(i);
            //将字符s也统计字符频次
            windowCount[currentChar - 'a']++;

            if (i >= pLength) {
                //当前的滑动串口大于目标的长度时，移除最开始的哪一个变为
                //pLen = 3，当 i = 3（第4个字符），窗口是 [1,1,1,0]（4个字符），需移除 s[0]
                char leftChar = s.charAt(i - pLength);
                windowCount[leftChar - 'a']--;
            }
            if (i >= pLength - 1) {
                if (Arrays.equals(pCount, windowCount)) {
                    result.add(i - pLength + 1);
                }
            }
        }
        return result;
    }


}
