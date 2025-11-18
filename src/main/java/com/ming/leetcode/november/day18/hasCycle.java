package com.ming.leetcode.november.day18;


/**
 * @author ming
 * @description 环形链表 https://leetcode.cn/problems/linked-list-cycle/
 * @date 2025/11/18 10:59
 */

class hasCycle {
    /**
     使用两个指针：
     慢指针（slow）：每次走 1 步
     快指针（fast）：每次走 2 步
     如果链表有环，快指针最终会追上慢指针（在环内相遇）
     如果链表无环，快指针会先到达 null（链表末尾）
     💡 类比：环形跑道上，跑得快的人一定会追上跑得慢的人。
     */
    public boolean hasCycle(ListNode head) {
        // 如果 head == null 或 head.next == null → 链表为空或只有一个节点 → 无环 → 返回 false
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        //（确保 fast.next.next 不会空指针）
        while (fast != null && fast.next != null) {
            //slow = slow.next（走 1 步）
            //fast = fast.next.next（走 2 步）
            //如果 slow == fast → 相遇 → 有环 → 返回 true
            //循环结束：
            //说明 fast 走到了链表末尾 → 无环 → 返回 false
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}