package com.ming.leetcode.code.ten.day22;



/**
 * @author ming
 * @description
 * @date 2025/10/22 12:36
 */

public class ListNodeText {
    public static ListNode22 reverseList(ListNode22 head) {
        ListNode22 prev = null;
        ListNode22 curr = head;
        while (curr != null) {
            ListNode22 next = curr.next; // 1. 先保存下一个节点（防止断链）
            curr.next = prev;          // 2. 反转当前节点的指针
            prev = curr;               // 3. prev 前进一步
            curr = next;               // 4. curr 前进一步
        }

        return prev; // 循环结束时，prev 指向原链表最后一个节点，即新链表的头
    }
}

class ListNode22 {
    int val;
    ListNode22 next;

    ListNode22() {
    }

    ListNode22(int val) {
        this.val = val;
    }

    ListNode22(int val, ListNode22 next) {
        this.val = val;
        this.next = next;
    }
}
