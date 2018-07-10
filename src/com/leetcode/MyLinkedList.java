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
    //147. Insertion Sort List
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return null;
        ListNode p = head.next;//用来遍历的结点
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        fakeHead.next.next = null;//插入第一个节点后，将其尾结点设置为空
        while(p!=null)//从第二个节点开始遍历
        {
            //
            ListNode p1 = fakeHead.next;
            ListNode pre = fakeHead;
            while(p1!=null && p.val >= p1.val)
            {
                pre = p1;
                p1 = p1.next;
            }

            ListNode temp = p;//要插入的结点
            p = p.next;
            //将节点插入到已拍好序的链表中
            temp.next = pre.next;
            pre.next = temp;
        }
        return fakeHead.next;
    }
    public ListNode insertionSortList2(ListNode head) {
        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        while(head!=null)
        {
            //加此句是重要的优化
            /**需要新插入的结点没有pre节点大，
             * 才需要将其从头开始遍历寻找需要插入的位置（即插入的节点的位置肯定在当前pre节点之前）,
             *否则直接从pre结点往下开始插入
             */
            if(pre.val > head.val)
                pre = helper;
            while(pre.next!=null && pre.next.val <= head.val)
                pre = pre.next;
            //将p结点插入
            ListNode p = head;//记下要插入的结点
            head = head.next;//结点必须先移动
            p.next = pre.next;
            pre.next = p;
        }
        return helper.next;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        /**
         *由于要求O(nlogN)的复杂度
         *所以，可以找到链表的中间结点，然后采用对两个链表分别排序，然后合并两个有序列表的方式
         */
        //利用快慢指针找到链表的中间结点
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        //将链表切分成两部分
        fast = slow.next;
        slow.next = null;

        /**
         //对两部分链表分别进行排序操作
         ListNode slowHead = sortListNode(head);
         ListNode fastHead = sortListNode(fast);*/
        //此处进行优化，递归调用
        ListNode slowHead = sortList(head);
        ListNode fastHead = sortList(fast);

        return mergeList(slowHead, fastHead);
    }
    public ListNode mergeList(ListNode l1, ListNode l2)
    {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(l1!=null && l2!=null)
        {
            if(l1.val < l2.val)
            {
                p.next = l1;
                l1 = l1.next;
            }
            else
            {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if(l1!=null)
            p.next = l1;
        if(l2!=null)
            p.next = l2;

        return dummy.next;
    }

}
