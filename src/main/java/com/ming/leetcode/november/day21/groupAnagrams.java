package com.ming.leetcode.november.day21;

import java.util.*;

/**
 * @author ming
 * @description 字母异位词分组
 * https://leetcode.cn/problems/group-anagrams/?envType=study-plan-v2&envId=top-100-liked
 * @date 2025/11/21 15:43
 */

public class groupAnagrams {
    // strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    //输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
    public List<List<String>> groupAnagrams(String[] strs) {
        // 1. 创建一个哈希表：key 是排序后的字符串，value 是该组的所有原字符串
        Map<String, List<String>> map = new HashMap<>();

        // 2. 遍历输入的每个字符串
        for (String s : strs) {
            // 3. 将当前字符串转为字符数组，以便排序
            char[] charArray = s.toCharArray();

            // 4. 对字符数组进行排序（按字母顺序）
            Arrays.sort(charArray);
            // 5. 将排序后的字符数组转回字符串，作为“分组标识符”（key）
            String sortedStr = new String(charArray);
            // 6. 检查 map 中是否已有这个 key
            if (map.containsKey(sortedStr)) {
                // 6.1 如果有，获取对应的列表，并把当前字符串 s 加进去
                List<String> list = map.get(sortedStr);
                list.add(s);
            } else {
                // 6.2 如果没有，创建一个新的列表，加入 s，再 put 到 map 中
                List<String> newList = new ArrayList<>();
                newList.add(s);
                map.put(sortedStr, newList);
            }
        }

        // 7. 返回结果
        return new ArrayList<>(map.values());
    }
}
