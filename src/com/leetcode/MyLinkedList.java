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

    //92.Reverse Linked List II
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if(head == null)
            return null;
        int start = 0;
        int end = 0;
        ListNode reverse = head;
        //反转开始的结点，也是反转部分的尾节点
        ListNode endReverse = head;

        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode p = helper;//遍历指针
        ListNode revHead = helper;//翻转时的头指针
        if(m < n)
        {
            while(p!=null && start<m)
            {
                revHead = p;
                p = p.next;
                ++start;
            }
            //找到了反转开始的结点
            reverse = p;
            endReverse = p;
            end = start;
            while(p!=null && end<=n)
            {
                reverse = p;//先记录下要反转的结点
                p = p.next;//p指向下一节点
                //头插法反转
                reverse.next = revHead.next;
                revHead.next = reverse;
                //将反转部分的尾节点指向链表的剩余部分
                endReverse.next = p;
                ++end;
            }
        }
        return helper.next;
    }


}
