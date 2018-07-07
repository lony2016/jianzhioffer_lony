package com.exam;

import java.util.Scanner;

/**
 * Created by 12038 on 2018/7/6.
 */
public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int g = cin.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; ++i)
        {
            a[i] = cin.nextInt();
        }
        System.out.println(helper(n, g, a));

    }

    public static int helper(int n, int g, int[] a) {
        int maxSum = 0;
        int bound = 0;


        //假设知道总站的人数0-g
        int count = 0;
        boolean flag = false;
        for(int i=0; i<=g;++i)
        {
            int sum = i;
            flag = false;

            for(int j=0; j<n; ++j)
            {
                sum +=a[j];
                if(sum>=0 && sum<=g)
                {
                    flag = true;
                }
                else
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
            {
                ++count;//此趟i满足要求
            }
        }

        return count;
    }
}
