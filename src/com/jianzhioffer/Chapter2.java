package com.jianzhioffer;

import com.test.Test;

import java.util.Vector;

/**
 * Created by lony on 2018/4/26.
 */
public class Chapter2 {
    /**
     * 面试题3：题目一：数组中重复的数字
     */
    public static boolean findRepeatNum (int[] numbers, int length, int[] duplication)
    {
        if(numbers == null && length <= 0)
        {
            return false;
        }
        //题目要求：保证数数组中的数字在0~length-1之间
        for(int k=0; k<length; ++k)
        {
            if(numbers[k] > length -1 || numbers[k] < 0)
                return false;
        }

        int i = 0;
        while(i < length)
        {
            if(i == numbers[i])
            {
                ++i;
            }
            else//note: i！=numbers[i]
            {
                if(numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                //i！= numbers[i]时，是一定要交换的
                /*temp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[numbers[i]] = temp;*///此种写法错误
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }

    /**
     * 面试题3：题目二：不修改数组找出重复的数字
     */
    public static boolean getRepeatNum(int[] numbers, int length, int[] duplication)
    {
        return false;
    }

    /**
     * 面试题4：二位数组的查找
     *
     */
    public static boolean find(int[][] a, int num)
    {
        if(a == null || a.length == 0)
            return false;
        int colLength = a.length;
        int rowLength = a[0].length;
//
        int i=0,j=0;
        while(i<rowLength && j<colLength)
        {
            if(a[i][j] == num)
            {
                return true;
            }
            else if(a[i][j] < num)
            {
                while(j < colLength - 1)//note:当碰到行末尾还是小时
                {
                    if(a[i][j+1] < num)
                        ++j;
                    else
                        break;
                }

            }
        }
        return false;

    }

    /**
     * 面试题5：替换空格
     *
     */
    public static String replaceBlank1(String oldStr) throws Exception {
        if(oldStr == null || oldStr.length() <= 0)
            throw new Exception("String is null or invalid");
//        String reStr = null;
        String reStr = oldStr.replaceAll(" ", "%20");
        return reStr;

    }


    public static void main(String[] args) throws Exception {
//        int[] nums = {2, 3, 1, 0, 2, 5, 3};
//        int[] duplication = {-1};
//        boolean bool = ((Chapter2)null).findRepeatNum(nums, nums.length, duplication);
//        System.out.println((Chapter2)null instanceof  Chapter2);

//        String s = null;
//        System.out.println(s instanceof  String);
//        System.out.println(s instanceof Object);
//        s = new String("a");
//        boolean bool = (s instanceof String);
////        boolean bool2 = (s instanceof String[]);
////        System.out.println(s instanceof null);
//        System.out.println(s instanceof  String);
//        System.out.println(s instanceof Object);
//        Test te = (Test) new Object();
        String str = "we are happy";
        String reStr = replaceBlank1(str);
        System.out.println(reStr);


    }
}
