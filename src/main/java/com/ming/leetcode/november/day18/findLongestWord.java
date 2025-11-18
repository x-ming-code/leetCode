package com.ming.leetcode.november.day18;

import java.util.List;

/**
 * @author ming
 * @description 524. 通过删除字母匹配到字典里最长单词
 * https://leetcode.cn/problems/longest-word-in-dictionary-through-deleting/description/
 * @date 2025/11/18 11:33
 */

public class findLongestWord {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String word : dictionary) {
            if (isSubsequence(word, s)) {
                //如果 word 的长度严格大于当前结果 res 的长度更新结果（因为题目要求优先选最长的）。
                //当前单词和已有结果长度相等并且word 的字典序小于 res（即字母顺序更靠前）
                if (word.length() > res.length() ||
                        (word.length() == res.length() && word.compareTo(res) < 0)) {
                    res = word;
                }
            }
        }
        return res;
    }

    // 判断 t 是否是 s 的子序列 t是字典 s是输入的字符串
    private boolean isSubsequence(String t, String s) {
        //功能：判断 t 是否是 s 的子序列。
        //i：指向 t（目标单词）
        //j：指向 s（原字符串）
        //只有字符相等时 i++，j 每次都 ++
        //返回 i == t.length()：表示 t 的每个字符都被按顺序匹配到了。
        int i = 0, j = 0;
        while (i < t.length() && j < s.length()) {
            if (t.charAt(i) == s.charAt(j)) {
                i++; // 匹配成功，t 的指针前进
            }
            j++; // s 的指针 always 前进
        }
        return i == t.length(); // t 是否全部匹配完
    }
}
