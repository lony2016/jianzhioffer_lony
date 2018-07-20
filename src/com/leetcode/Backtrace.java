package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 12038 on 2018/7/19.
 * 回溯算法
 */
public class Backtrace {
    //77. Combinations
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        if(n<=0 || n<k)
            return results;
        List<Integer> result = new ArrayList<>();
        backtracing(results, result, n, k, 1);
        return results;
    }
    public void backtracing(List<List<Integer>> results, List<Integer> result, int n, int k, int start)
    {
        if(k < 0)
        {
            return;
        }
        else if(k == 0)//
        {
//            results.add(result);//这样写，返回的是空集,是错误的
            /**
             * 必须把result copy一份加到结果集合中，因为result的元素在下面后被移除
             * 因为result一直被重复使用
             */
            results.add(new ArrayList<Integer>(result));
        }
        else
        {
            for(int i=start; i<=n; ++i)
            {
                result.add(i);
                backtracing(results, result, n, k-1, i+1);
                result.remove(result.size() - 1);//这儿会移除result中的元素，所以，
                // 将满足条件的result应该copy一份给一个新的元素加入到结果集合中
            }
        }
    }

    public static void main(String[] args) {

        Backtrace ba = new Backtrace();
        List<List<Integer>> res = ba.combine(2, 1);
        for(int i=0; i<res.size(); ++i)
        {
            List<Integer> list = res.get(i);
            if(list.size() == 0)
                System.out.println("size=0" );
            else
                System.out.println("["+list.get(0) + "]");
        }

    }
}
