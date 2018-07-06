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
        if(head == null)
            return null;
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode pre = helper;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while(p1!=null && p2!=null)
        {
            if(p1.val != p2.val)
            {
                pre = p1;
                p1 = p2;
                p2 = p2.next;
            }
            else
            {
                int val = p1.val;
                while(p2.next!=null && val == p2.next.val)
                {
                    p2 = p2.next;
                }
                //p2此时移动到重复元素的最后一个，删除重复元素，让pre的next指向拍p2.next
                pre.next = p2.next;

                p1 = p2.next;
                if(p1 != null)
                {
                    p2 = p1.next;
                }
            }
        }
        return helper.next;
    }

    //


}
