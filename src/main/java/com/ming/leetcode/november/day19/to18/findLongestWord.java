package com.ming.leetcode.november.day19.to18;

import java.util.List;

/**
 * @author ming
 * @description
 * @date 2025/11/19 9:27
 */

public class findLongestWord {


    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";

        for (String word : dictionary) {
            if (isSubsequence(word, s)) {
                if (word.length() > res.length() ||
                        (word.length() == res.length() && word.compareTo(res) < 0)) {
                    res = word;

                }
            }
        }
        return res;
    }

    private boolean isSubsequence(String word, String s) {
        //i指向word的字典 j指向输入的字符串
        int i = 0, j = 0;
        while (i < word.length() && j < s.length()) {
            if (word.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == word.length();
    }
}
