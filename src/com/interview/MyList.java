package com.interview;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by lony on 2018/7/3.
 * 本部分是结合自己和从别人口中得知的面试时被问到的算法题List相关的总结总结
 *
 */
public class MyList {

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
    //判断链表是否有环
    //leetcode上：141. Linked List Cycle
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;//每次前进一步
        ListNode fast = head;//每次前进两步

        while(fast != null && fast.next != null)//第二次提交错误，是因为把&&符号弄成了||
        {
            slow = slow.next;
            fast = fast.next.next;//只有保证fast和fast.next都不为空，才可以避免空指针异常
            if(slow == fast)
            {
                return true;
            }
        }
        return false;
    }

    //求有环链表的环的长度:leetcode上没有
    public int cycleLength(ListNode head)
    {
        if(head == null || head.next == null)
            return 0;
        //先要判断是否有环
        ListNode slow = head;
        ListNode fast = head;
        boolean first = false;
        boolean second = false;

        int length = 0;
        while(fast != null || fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(second == true && fast == slow)//第二次相遇，结束循环，计算长度
            {
                break;
            }
            if(fast == slow && first == false)//第一次相遇证明有环，再让其循环一次就可以找到
            {
                first = true;
                second = true;
            }
            //计数
            if(first == true)
            {
                ++length;
            }
        }
        return length;
    }
    //


}
