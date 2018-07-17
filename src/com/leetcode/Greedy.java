package com.leetcode;

/**
 * Created by lony on 2018/7/12.
 * 贪心算法
 */
public class Greedy {

    //55. Jump Game
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return false;
        }
        int len = nums.length;
        int maxStep = nums[0];
        for(int i=1; i<len; ++i)
        {
            //每次向前移动一步
            --maxStep;

            if(maxStep<0){
                return false;
            }

            if(nums[i]>maxStep){
                maxStep = nums[i];
            }
        }
        return true;
    }

    //45. Jump Game II
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }

        //数组中只有一个数时，相当于就在末尾，直接返回0，不需要任何步数
        int countStep = 0;//统计走过的步数
        int lastReach = 0;//上一个位置，所能到达的最远位置
        int cur = 0;//当前i位置能达到的最远
        int len = nums.length;
        for(int i=0; i<len; ++i)
        {
            if(i>cur)//如果当前位置大于上一步所能达到的最远位置
                return -1;
            if(i > 0 && cur >= len - 1 )//i>0是为了防止数组中只有一个数时
            {
                return ++countStep;
            }
            if(i > lastReach)//超出上一步所能走出的范围，步数+1
            {
                lastReach = cur;
                ++countStep;
            }
            cur = cur > (i + nums[i])?cur:(i+nums[i]);
        }
        return countStep;
    }

    //134. Gas Station
    public int canCompleteCircuit(int[] gas, int[] cost) {//题目保证给出的数组不为空且有唯一解，我感觉才可以这样做的
        int len = gas.length;
        int curSum = 0;
        int total = 0;
        //int resIndex = -1;//初始值不能为-1，当第一个位置0就满足时resIndex = 0而不是-1
        int resIndex = 0;
        for(int i=0; i<len; ++i)
        {
            curSum += gas[i] - cost[i];
            //如果当前位置的静油量小于0，肯定开不到下一站，则开始位置一定在此位置之后
            if(curSum < 0){
                resIndex = i + 1;
                curSum = 0;
            }

            total += gas[i] - cost[i];//统计总的油量
        }

        if(total < 0)//可以加油的总量一定要大于消耗的总量，才可以返回到出发点
        {
            return -1;
        }
        else
        {
            return resIndex;
        }
    }

    //135. Candy
    public int candy(int[] ratings) {
        int len = -1;
        if(ratings == null || (len = ratings.length) == 0)
            return 0;
        //int candy = len;
        int[] candy = new int[len];
        //每人先发一颗糖
        for(int i=0; i<len; ++i)
        {
            candy[i] = 1;
        }
        //从左往右，i位置比i+1小的，i+1位置糖果加1
        for(int i=0; i<len-1; ++i)
        {
            if(ratings[i] < ratings[i+1])
            {
                candy[i+1] = candy[i] + 1;
            }
        }
        int resCandy = 0;
        //从右向左，i位置比i+1位置大，且candy[i] <= candy[i+1]，i位置糖果加1
        for(int i=len-2; i>=0; --i)
        {
            if(ratings[i] > ratings[i+1] && candy[i] <= candy[i+1])
            {
                candy[i] = candy[i+1] + 1;
            }
            resCandy += candy[i+1];
        }

        resCandy += candy[0];//+ len;//别忘记每人先发了一颗糖，所以要加len

        return resCandy;
    }



}
