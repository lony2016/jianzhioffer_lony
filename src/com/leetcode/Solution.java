package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 12038 on 2018/6/15.
 */
public class Solution {

    //27. Remove Element
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if(nums == null || len == 0)
            return 0;
        int j = 0;
        for(int i=0; i<len; ++i)
        {
            if(nums[i] == val)
                continue;
            nums[j] = nums[i];
            ++j;

        }

        return j;
    }
    //Remove Duplicates	from Sorted	Array
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0)
            return 0;
        int i=0;
        for(int j=1;j<len;j++)
        {
            if(nums[i] != nums[j])//多加个j-i判断是不行的，因为对于数组[1, 2]就有问题
            {
                ++i;
                nums[i] = nums[j];
            }
        }
        return i+1;//返回的数组长度，别忘记+1
    }

    //66. Plus One
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if(digits == null || len == 0)
            return null;
        int i = len-1;
        while(i>=0)
        {
            if(digits[i] < 9)
            {
                digits[i] += 1;
                return digits;
            }
            else
            {
                digits[i--] = 0;
            }
        }
        int[] newArr = new int[len+1];
        newArr[0] = 1;
        return newArr;

    }
    //118. Pascal's Triangle
    public List<List<Integer>> generate(int numRows) {

        if(numRows < 0)
            return null;
        List<List<Integer>> list = new ArrayList<>(numRows);
        if(numRows==0)//numRows等于0时，要求输出的时空集合（[]）
            return list;


        for(int i=0; i<numRows; ++i)
        {
            List<Integer> intList = new ArrayList<>(i+1);
            for (int j=0; j<=i; ++j)
            {
                List<Integer> preList;
                if(j==0 || j==i)
                {
                    intList.add(1);
                }
                else
                {
                    preList = list.get(i-1);
                    int num = preList.get(j) + preList.get(j-1);
                    intList.add(num);
                }

            }

            list.add(intList);//也可以利用二维数组来做，然后将二维数组转换成list利用Array.asList方法
        }
        return list;
    }

    //119. Pascal's Triangle II
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex < 0)
        {
            return null;
        }
        List<Integer> list = new ArrayList<>(rowIndex+1);
        for(int i=0; i<=rowIndex; ++i)
        {
            int num;
            if(i == 0 || i == 1)
                list.add(1);
            else
            {
                for(int j=i; j>=1; --j)//从前往后遍历的话，会导致前面的可能需要用的数字可能会被改变了
                {
                    if(j<i)
                    {
                        num = list.get(j-1) + list.get(j);
                        list.set(j, num);//此时不能用add了，是用set才是替换原位置上的值
                    }
                    else
                    {
                        list.add(i, 1);
                    }
                }
            }
        }
        return list;
    }
    //119. Pascal's Triangle II
    public List<Integer> getRow2(int rowIndex)
    {
        if(rowIndex < 0)
        {
            return null;
        }
        Integer[] arr = new Integer[rowIndex+1];
        for(int i=0; i<=rowIndex; ++i)
        {
            if(i == 0 || i == 1)
            {
                arr[i] = 1;
            }
            else
            {
                for(int j=i-1; j>=1; --j)//从前往后遍历的话，会导致前面的可能需要用的数字可能会被改变了
                {
                    arr[j] += arr[j-1];
                }
                arr[i] = 1;
            }
        }
        return Arrays.asList(arr);
    }

    public static void main(String[] args) {
        Solution su = new Solution();

        int nums[] = {1, 1, 2};
//        int i = su.removeDuplicates(nums);
//
//        System.out.println(i);
        int[] newArr = su.plusOne(nums);
//        for(int i=0;i<newArr.length; ++i)
//        {
//            System.out.println(nums[i]);
//        }
        List<Integer> list = su.getRow2(3);
        System.out.println(list.get(2));

    }
}
