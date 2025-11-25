package com.ming.leetcode.november.day25;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ming
 * @description 无重复字符的最长字串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-100-liked
 * @date 2025/11/24 17:54
 */

public class lengthOfLongestSubstring {
    //详细解释 https://www.qianwen.com/share?shareId=3171f380-9d10-4c25-befa-8c959bce71b3
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        // 记录每个字符最后一次出现的索引
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            //获取当前第一个字符
            char currentChar = s.charAt(right);
            // 如果当前字符之前出现过，并且在当前窗口 [left, right) 内
            if (map.containsKey(currentChar)) {
                //获取字符对应的下标
                Integer prevIndex = map.get(currentChar);
                //若下标大于等于left，表明是重复字符 跳过
                if (prevIndex >= left) {
                    left = prevIndex + 1; // 跳过重复字符
                }
            }
            // 没有在map出现过则更新当前字符的最新位置 key为字符 值为字符对应的下标
            map.put(currentChar, right);

            // 计算当前窗口长度并更新最大值
            int currentLength = right - left + 1;
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }
        return maxLength;
    }
}
