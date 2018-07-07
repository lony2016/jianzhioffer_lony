package com.leetcode;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] arr = new int[n];
        int i;
        for(i=0; i<n;++i)
        {
            arr[i] = cin.nextInt();
        }
        System.out.println(helper(arr));
    }
    //翻转数组
    public static String helper(int[] arr)
    {
        String res;
        int n = arr.length;
        int i = 0;
        int left = 0, right = 0;
        //找到左边第一个最大的数
        while(i<n-1 && arr[i] < arr[i+1])
            ++i;
        left = i;
        //找到第一个较小的数
        while(i<n-1 && arr[i] > arr[i+1])
            ++i;
        right = i;

        //剩下的位置要是出现降序就不存在了
        i += 1;
        while(i<n-1 && arr[i]>arr[i+1])
            return "no";
        if((left == n-1) || (left == 0 &&right == n-1))//数组整体升序或者降序
            return "no";
        if(left>0 && right<n-1)
        {
            if(left < right && arr[left-1]<arr[right] && arr[left]<arr[right+1])
                return "yes";
            else
                return "no";
        }
        if(left==0 && arr[left] < arr[right+1] )
            return "yes";

        if(right==n-1 && arr[left-1] < arr[right])
            return "yes";
        return "no";
    }

    public static double getRate(String str, int[] a)
    {
        if(str == null || str.length() == 0)
            return 0.00;

        return 0.0;

    }
}
