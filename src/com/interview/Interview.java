package com.interview;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by lony on 2018/7/3.
 * 本部分是结合自己和从别人口中得知的面试时被问到的算法题总结
 *
 */
public class Interview {

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


}
