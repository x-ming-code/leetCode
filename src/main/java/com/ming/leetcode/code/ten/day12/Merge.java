package com.ming.leetcode.code.ten.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author ming
 * @description 合并区间
 * @date 2025/10/12 15:35
 */

public class Merge {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(merge(new int[][]{{1, 3}, {2, 6}, {15, 18}, {8, 10}})));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length < 0 || intervals == null) {
            return new int[0][0];
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(
                intervals, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return Integer.compare(o1[0], o2[0]);
                    }
                }
        );
        //先将第一个数组放入集合
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            //获取数组
            int[] current = intervals[i];
            //根据索引获取集合中的第一个数组
            int[] lastMerged = list.get(list.size() - 1);//也就是获取第一个数组
            //判断判断是否重叠 & 合并
            //只需判断当前区间的起点是否 不超过 上一个区间的终点。
            //例如：[1,3] 和 [2,6] → 2 <= 3 → 重叠。
            if (current[0] <= lastMerged[1]) {
                // 合并操作：
                //不需要新建区间，直接修改 lastMerged[1]（因为 List 中存的是引用）。
                //新的结束位置是两者 end 的最大值：Math.max(lastMerged[1], current[1])
                lastMerged[1] = Math.max(lastMerged[1], current[1]);
            } else {
                list.add(current);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}