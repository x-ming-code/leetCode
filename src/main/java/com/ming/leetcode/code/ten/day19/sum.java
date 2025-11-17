package com.ming.leetcode.code.ten.day19;

import java.util.*;

/**
 * @author ming
 * @description 两数之和
 * @date 2025/10/19 16:41
 */

public class sum {
    /**
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * 解释：
     * 在 strs 中没有字符串可以通过重新排列来形成 "bat"。
     * 字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
     * 字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。
     */
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(str(strs));

    }

    public static List<List<String>> str(String[] strs) {
      if (strs.length==0||strs==null){
          return new ArrayList<>();
      }
      //key是排序过的字符 值是对应的字符串
      Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if (!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            List<String> list = map.get(key);
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }
}
