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
    //2.问题2，找出环的入口点
    //leetcode:142. Linked List Cycle II
    /**
     * 参考：https://www.cnblogs.com/dancingrain/p/3405197.html
     * 从上面的分析知道，当fast和slow相遇时，slow还没有走完链表，假设fast已经在环内循环了n(1<= n)圈。假设slow走了s步，则fast走了2s步，又由于
     fast走过的步数 = s + n*r（s + 在环上多走的n圈），则有下面的等式：
     2*s = s + n  * r ; (1)
     => s = n*r (2)
     如果假设整个链表的长度是L，入口和相遇点的距离是x（如上图所示），起点到入口点的距离是a(如上图所示)，则有：
     a + x = s = n * r; (3)  由（2）推出
     a + x = (n - 1) * r + r  = (n - 1) * r + (L - a) (4) 由环的长度 = 链表总长度 - 起点到入口点的距离求出
     a = (n - 1) * r + (L -a -x) (5)
     集合式子（5）以及上图我们可以看出，从链表起点head开始到入口点的距离a,与从slow和fast的相遇点（如图）到入口点的距离相等。
     因此我们就可以分别用一个指针（ptr1, prt2），同时从head与slow和fast的相遇点出发，每一次操作走一步，直到ptr1 == ptr2，此时的位置也就是入口点！
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        //如果链表有环，先要判断链表是否有环，如果有，定义出两个指针，先计算出两指针相遇的地方
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow)//有环
                break;
        }
        if(fast == null || fast.next == null)
            return null;

        //有环，计算环的入口
        ListNode p1 = head;//p1指针从头开始
        ListNode p2 = slow;//p2指针从之前两指针相遇处开始,此时两指针都是一步一步移动
        while(p1 != p2)
        {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;//p1和p1再次相遇的点就是环的入口

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



}
