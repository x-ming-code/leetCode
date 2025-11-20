package com.ming.leetcode.november.day20;

import java.util.*;

/**
 * @author ming
 * @description 根据字符出现频率排序
 * https://leetcode.cn/problems/sort-characters-by-frequency/description/
 * @date 2025/11/20 14:24
 */

public class frequencySort {
    public String frequencySort(String s) {
        //将字符串转为char类型统计出现频率
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //将所有的key转为list集合加到集合中
        List<Character> list = new ArrayList<>(map.keySet());
        //排序 从小打到排序
        list.sort((a, b) -> map.get(b) - map.get(a));

        //追加拼接字符串
        //在这段代码之前，已经完成了两件事：
        //统计了每个字符的出现频率（例如 'e' → 2, 't' → 1）
        //将所有唯一字符按频率从高到低排序，存入列表 chars（例如 ['e', 't', 'r']）
        StringBuilder stringBuilder = new StringBuilder();

        for (Character c : list) {
            Integer count = map.get(c);
            for (Integer i = 0; i < count; i++) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
