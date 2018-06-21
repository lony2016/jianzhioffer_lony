package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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

    //88. Merge Sorted Array 我写的
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int len = nums1.length;
        if(nums1 == null || nums2 == null || m < 0 || n < 0 || nums1.length < m+n)
        {
            return;
        }
        int i, j=0;
        while(j<n)
        {
            i=m-1;
            for(;i>=0;--i)
            {
                if(nums1[i] > nums2[j])
                {
                    nums1[i+1] = nums1[i];
                }
                else
                    break;
            }
            if(i<m-1)
            {
                nums1[i+1] = nums2[j++];
                ++m;
            }
            else
                break;
        }
        for(;j<n;++j)
        {
            nums1[m++] = nums2[j];
        }


    }
    //88. Merge Sorted Array
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums2 == null || nums1.length < m + n )
            return;
        int i = m-1, j = n-1, k = m + n -1;
        while(i>=0 && j>=0)
        {
            if(nums1[i] < nums2[j])
                nums1[k--] = nums2[j--];
            else
                nums1[k--] = nums1[i--];
        }
        while(j>=0)
            nums1[k--] = nums2[j--];
    }

    //1. Two Sum 我的解法
    public int[] twoSum(int[] nums, int target) {

        if(nums == null || nums.length <= 1)
            return null;
        int len = nums.length;
        int res[] = new int[2];
        for(int i=0; i<len; ++i)
        {
            int temp = target - nums[i];
            boolean flag = false;
            for(int j=i+1; j<len;++j)
            {
                if(temp == nums[j])
                {
                    res[0] = i;
                    res[1] = j;
                    flag = true;
                    break;
                }
            }
            if(flag)
            {
                break;
            }
        }
        return res;

    }
    //1. Two Sum
    public int[] twoSum2(int[] nums, int target) {
        if(nums == null || nums.length <= 1)
            return null;
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<len; ++i)
        {
            map.put(nums[i], i);
        }
        for(int i=0; i<len; ++i)
        {
            Integer j;
            /**
             * 必须做i != j判断，因为3+3=6时，
             * 如果数组中只有一个3时，6减去num[i]=3时，找到的其实还是num[i]的3,而此时3其实是自己，并没有两个3，
             * 就算有两个3，下表分别是i，j;put进hashmap时，虽然第二个3会覆盖掉第一个3的i下标,始终时j下标的3存在map中（此时假设i<j）
             * 此时还是可以找出两个3的下标i和j的，i是通过数组，j是通过map
             */
            if((j=map.get(target - nums[i])) != null && i != j)
            {
                if(i < j)
                {
                    return new int[]{i, j};
                }
                else
                {
                    return new int[]{j, i};
                }
            }

        }
        throw new IllegalArgumentException("not find two nums");
    }

    public static void main(String[] args) {
        Solution su = new Solution();

//        int nums[] = {1, 1, 2};
//        int i = su.removeDuplicates(nums);
//
//        System.out.println(i);
//        int[] newArr = su.plusOne(nums);
//        for(int i=0;i<newArr.length; ++i)
//        {
//            System.out.println(nums[i]);
//        }
//        List<Integer> list = su.getRow2(3);
        int nums1[] = {3, 4, 3, 4};
//        int nums2[] = {1};
//        su.merge(nums1, 0, nums2, 1);
//        for(int i=0;i<nums1.length; ++i)
//        {
//            System.out.println(nums1[i]);
//        }
//        System.out.println(list.get(2));

        HashMap<Integer, Integer> map = new HashMap<>();
        int res[] = new int[2];
        for(int i=0; i<nums1.length; ++i)
        {
            map.put(nums1[i], i);
        }
        System.out.println(map.size());


    }
}
