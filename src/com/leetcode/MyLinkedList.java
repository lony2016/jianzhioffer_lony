package com.leetcode;

/**
 * Created by lony on 2018/7/4.
 *
 */
public class MyLinkedList {
    //单链表结点，结合leetcode写法
    class ListNode{
        int val;
        ListNode next;
        public ListNode(int x)
        {
            val = x;
            next = null;
        }
    }

    //83. Remove Duplicates from Sorted List
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while(node != null && node.next != null)
        {
            /**if(node.val == node.next.val)
             {
             node.next = node.next.next;
             }
             node = node.next;*///代码问题少考虑了[1,1,1]通过不了
            if(node.val == node.next.val)
                node.next = node.next.next;
            else
                node = node.next;
        }
        return head;
    }

    //82. Remove Duplicates from Sorted List II
    public ListNode deleteDuplicates2(ListNode head) {
        return null;
    }

    //


}
