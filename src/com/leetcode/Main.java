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

        i = 0;
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
            System.out.println(false);
//        if(left == n-1)
//            System.out.println(false);
//        if(left )
        if()
    }
}
