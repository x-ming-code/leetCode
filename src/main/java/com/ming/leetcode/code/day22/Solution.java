package com.ming.leetcode.code.day22;

import java.util.*;

/**
 * @author ming
 * @description 把字母数量相同的字符串分到一组
 * @date 2025/7/22 16:37
 */

public class Solution {
    /**
     * 示例：["nat","tan"]都是一个a，一个n，一个t，所以分到一组。
     * ["ate","eat","tea"]都是一个a，一个e，一个t，所以分到一组。
     * String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
     */
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    /**
     * 思路
     * 创建一个map key是新排序好的字符串 值是符合这个key顺序的集合
     *   {"aet": ["eat","tea"]}
     * for循环
     * 先对字符串集合进行排序 把有序的字符串做为map的key
     *    判断这个key是否在map中，
     *      在就添加一个新元素到map的values（list集合）中
     *      不在就根据这个key添加一个新list集合
     *      最后返回这个map的所有值
     */
    public static List<List<String>> groupAnagrams(String[] str) {
        if (str.length == 0 || str == null) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        //遍历每一个字符串集合并排序
        for (String s : str) {
            // 将当前字符串 s 转换为字符数组
            // "eat" → ['e', 'a', 't']
            // "tea" → ['t', 'e', 'a']
            char[] charArray = s.toCharArray();
            // Arrays.sort() 会对字符数组按字母顺序排序 ['e', 'a', 't'] → ['a', 'e', 't']
            Arrays.sort(charArray);
            // 将排序后的字符数组转为字符串 ['a', 'e', 't'] → "aet"
            String key = new String(charArray);
            // 如果 map 中还没有这个 key，新建一个 List
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            // 如果有这个key 根据key获得value，将新的符合的字符串放到集合中
            List<String> list = map.get(key);
            list.add(s);
        }
        //最后返回自己所有的map的值的集合即可
        return new ArrayList<>(map.values());
    }
}
