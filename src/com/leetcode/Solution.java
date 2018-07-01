package com.leetcode;

import java.util.*;

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
        while(j>=0)//如果剩下的i>=0,无需调整，因为nums1就是目标数组
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

    //15. 3Sum
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length <= 2)
        {
            return new ArrayList<>();//return null又没通过，当是一个[]集合时，也应该return一个[]
        }
        int len = nums.length;
        //为了方便后面的j,k指针的移动
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<len-2; ++i)
        {
            int j=i+1;
            int k=len-1;
            while(j < k)
            {
                if(nums[i] + nums[j] + nums[k] == 0)
                {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    ++j;
                    --k;

                    //this two while loop is used to skip duplication solution
                    while(j < k && nums[j] == nums[j-1]) ++j;
                    while(j < k && nums[k] == nums[k+1]) --k;

                }
                else if(nums[i] + nums[j] + nums[k] < 0)
                {
                    //if the sum less than 0,move j to forward
                    ++j;
                }
                else
                {
                    --k;
                }

                //this while loop is used to skip duplication solution(i)
                while(i<len-2 && nums[i] == nums[i+1])
                {
                    ++i;
                }
            }
        }
        return res;
    }

    //153. Find Minimum in Rotated Sorted Array(轮转后的有序数组)
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            throw new IllegalArgumentException("Array is null or Array's length is 0");
        }
        int len = nums.length;
        if(len == 1)
            return nums[0];
        else if(len == 2)
            return nums[0] < nums[1]?nums[0]:nums[1];

        int low = 0;
        int high = len - 1;
        while(low < high - 1)//
        {
            //判断分片是否有序，要是nums[low]<nums[high],说明此分片上是个有序的片段，最小就是nums[low]
            if(nums[low] < nums[high])
                return nums[low];

            int mid = (low + high)/2;
            //最小的数肯定存在于分片上的nums[low]>nums[high]
            if(nums[low] > nums[mid])
                high = mid;
            else if(nums[mid] > nums[high])
                low = mid;
        }
        return nums[low] < nums[high]?nums[low]:nums[high];
    }
    //153. Find Minimum in Rotated Sorted Array(轮转后的有序数组)
    //上述代码的优化
    public int findMin2(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            throw new IllegalArgumentException("Array is null or Array's length is 0");
        }
        int len = nums.length;

        int low = 0;
        int high = len - 1;
        //判断数组是否被轮转，没有轮转的话，直接返回最小值
        if(nums[low] < nums[high])
            return nums[low];
        while(low < high - 1)//
        {


            int mid = (low + high)/2;
            //最小的数肯定存在于分片上的nums[low]>nums[high]
            if(nums[low] > nums[mid])
                high = mid;
            else if(nums[mid] > nums[high])
                low = mid;
        }
        return nums[high];//循环结束时，最终nums[low]一定大于nums[high]
    }

    //154. Find Minimum in Rotated Sorted Array II（数组中可以有重复元素）
    public int findMin3(int[] nums) {
        if(nums == null || nums.length == 0)
            throw new IllegalArgumentException("Array is null or Array's length is 0");

        int len = nums.length;
        int low = 0;
        int high = len - 1;

        if(len == 2)
            return nums[0] < nums[1]?nums[0]:nums[1];
        while(low < high-1)
        {
            //数组可能没有轮转
//            System.out.println("aa");
            if(nums[low] < nums[high])
            {
//                System.out.println("a");
                return nums[low];
            }
            int mid = (low + high)/2;
            if(nums[low] < nums[mid])
                low = mid;
            else if(nums[mid] < nums[low])
                high = mid;
            else {
                low++;
            }
        }
        return nums[high];
    }

    //9. Palindrome Number
    public boolean isPalindrome(int x) {

        if(x <0)
            return false;
        else if(x<10)
            return true;
        else
        {
            int tempX = x;
            int reverse = 0;
            while(x != 0)
            {
                reverse = reverse*10 + x%10;//从低位到高位顺序，取出x的每一位，通过循环一次乘以10，就可以将其转换到对应的高位，实现反转
                x /= 10;//为取出每一位做准备
            }
            if(tempX == reverse)
                return true;
        }
        return false;
    }

    //74. Search a 2D Matrix(我写的)
    public boolean searchMatrix(int[][] matrix, int target) {

        int len = 0, width = 0;
        if(matrix == null || (len = matrix.length) == 0 || (width = matrix[0].length) == 0)
            return false;
        for(int i=0; i<len; ++i)
        {
            for(int j=width-1; j>=0; --j)
            {
                if(matrix[i][j] < target)
                {
                    break;
                }
                else if(matrix[i][j] == target)
                {
                    return true;
                }
            }
        }
        return false;
    }

    //74. Search a 2D Matrix(上述修改版)leetcode击败率提升了一倍
    public boolean searchMatrix2(int[][] matrix, int target) {

        int row = 0, col = 0;
        if(matrix == null || (row = matrix.length) == 0 || (col = matrix[0].length) == 0)
            return false;

        int rowNum = 0;
        int colNum = col - 1;
        while(rowNum < row && colNum >=0)
        {
            if(target < matrix[rowNum][colNum])
                --colNum;
            else if(target > matrix[rowNum][colNum])
                ++rowNum;
            else
                return true;
        }
        return false;
    }
    //74. Search a 2D Matrix
    //由于二维数组实际上完全递增的，可以将其看成有序的一维数组进行二分查找
    public boolean searchMatrix3(int[][] matrix, int target) {
        int row = 0, col = 0;
        if(matrix == null || (row = matrix.length) == 0 || (col = matrix[0].length) == 0)
            return false;
        int start = 0;
        int end = row*col - 1;//元素总个数
        while(start <= end)
        {
            int mid = (start + end)/2;
            if(target < matrix[mid/col][mid%col])
                end = mid - 1;
            else if(target > matrix[mid/col][mid%col])
                start = mid + 1;
            else
                return true;
        }
        return false;
    }

    //84. Largest Rectangle in Histogram
    public int largestRectangleArea(int[] heights) {

        /**
         * 使用栈来解决的
         */
        int len = -1;
        if (heights == null || (len = heights.length) == 0)
            return 0;
        else if(len == 1)
            return heights[0];
        Stack<Integer> st = new Stack<>();
        /**
         * 为了更好的处理最后一个元素的情况，我们在实际中会插入一个高度为0的bar，这
         * 样就能pop出最后一个bar并计算了。

         int modHeights[] = new int[len+1];
         System.arraycopy(heights, 0, modHeights, 0, len);
         len = len + 1;*/
        int i = 0;
        int sum = 0;
        while(i < len)
        {
            if(st.empty() || heights[i] >= heights[st.peek()])
            {
                st.push(i);
                i++;
            }
            else
            {
                int temp = st.peek();
                st.pop();
                //这里还需要考虑stack为空的情况
                int tempSum = heights[temp]*(st.empty()?i:i-st.peek()-1);
                sum = sum > tempSum? sum : tempSum;
            }
        }
        while(!st.empty())
        {
            int temp = st.peek();
            st.pop();
            int tempSum = heights[temp]*(st.empty()?i:i-st.peek()-1);
            sum = sum> tempSum?sum:tempSum;
        }
        return sum;
    }

    //240. Search a 2D Matrix II
    public boolean searchMatrixII(int[][] matrix, int target) {
        int row , col;
        if(matrix == null || (row = matrix.length) == 0 || (col = matrix[0].length) == 0)
            return false;
        int i=0, j=col-1;//从矩阵的右上角开始遍历
        while(i<row && j>=0)
        {
            if(target > matrix[i][j])
                ++i;
            else if(target < matrix[i][j])
                --j;
            else
            {
                return true;
            }
        }
        return false;
    }

    //34. Search for a Range
    public int[] searchRange(int[] nums, int target) {
        int len;
        if(nums == null || (len=nums.length) == 0)
            return new int[]{-1,-1};
        int start = -1, end = -1;
        int res[] = new int[]{-1, -1};
        int low = 0, high = len -1;
        while(low <= high)
        {
            int mid = (low + high)/2;
            System.out.println(11);
            if(target > nums[mid])
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        //循环结束时，low>high的，说明此时low位置左边的数都小于target;
        //
        if(low < len && nums[low] == target)
            res[0] = low;
        else//如果low的位置数都不等于target,那其右边位置的数更大于target
        {
            res[0] = res[1] = -1;
            return res;
        }

        high = len - 1;
        while(low <= high)
        {
            int mid = (low + high)/2;
            if(target >= nums[mid])
                low = mid+1;
            else
                high = mid-1;//当low=high时，target<nums[mid],high会减一
        }
        res[1] = high;
        return res;
    }

    //35. Search Insert Position
    public int searchInsert(int[] nums, int target) {
        if(nums == null)
            throw new IllegalArgumentException("Array is null");
        int len;
        if((len=nums.length) == 0)
            return 0;
        int low = 0;
        int high = len - 1;

        while(low <= high)
        {
            int mid = (low + high)/2;
            if(nums[mid] < target)
                low = mid + 1;
            else if(nums[mid] > target)
                high = mid -1;
            else
            {
                return mid;
            }
        }
        return low;
    }

    //162. Find Peak Element
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0)
            throw new IllegalArgumentException("Array is null or Array's length is o");
        int len = nums.length;
        if(len == 1)
            return 0;
        int low=0,high=len-1;
        int mid=0;
        while(low <= high)
        {
            mid = (low+high)/2;
            //if((mid==0 && nums[mid]>nums[mid+1]) ||(mid == len-1 && nums[mid]>nums[mid-1]) ||(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]))
            //这种判断对于[1,2]会出现数组越界的出错
            //mid == 0同时
            if((mid==0 || nums[mid]>nums[mid-1]) &&(mid==len-1 || nums[mid]>nums[mid+1]))
            {
                return mid;
            }
            else if(mid>0 && nums[mid-1]>nums[mid])
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return mid;
    }

    //268. Missing Number
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            throw new IllegalArgumentException("array is null or length is 0");
        int len = nums.length;
        /*if(len == 1)
        {
            return 0;
        }*/
        //[0]返回出错，是因为应该有0，1两个数，少了1，应该返回1

        int bitmap[] = new int[len+1];
        int i;
        int bLen = len + 1;
        for(i=0;i<len; ++i)
        {
            bitmap[nums[i]] = 1;
        }
        for(i=0;i<bLen;++i)
        {
            if(bitmap[i] == 0)
                return i;
        }
        return 0;
    }
    //268. Missing Number
    public int missingNumber2(int[] nums) {
        /**
         * 一种可行的具有线性时间复杂度的算法是求和。
         * 比加法更高效率的运算是异或(XOR)运算
         * 异或运算的一个重要性质是，相同的数异或得0，不同的数异或不为0
         * 首先将0到n这些数进行异或运算， 然后对输入的数组进行异或运算，
         * 最后将两个结果进行异或运算，结果便是漏掉的 数字，因为其他数字
         * 在两个数组中都是成对出现的，异或运算会得到0
         */
        if(nums == null || nums.length == 0)
            throw new IllegalArgumentException("array is null or length is 0");
        int len = nums.length;
        int n = len+1;
        int res = 0;
        for(int i=0; i<n; ++i)
        {
            res ^= i;
        }
        for(int num:nums)
        {
            res ^= num;
        }
        return res;
    }

    //231. Power of Two
    public boolean isPowerOfTwo(int n) {
        if(n<1)
            return false;
        // boolean hasOne = true;
        while(n>1)
        {
            if((n&1) == 1)
            {
                return false;
            }
            else
            {
                n = n>>1;
            }
        }
        return true;
    }
    //231. Power of Two
    public boolean isPowerOfTwo2(int n) {
        if(n<1)
            return false;
        return (n&(n-1)) == 0;//2的n次幂只有最高位为1，减去1之后，除去最高位，都是0，做&运算为0
    }


    //104. Maximum Depth of Binary Tree
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int treeDepth = leftDepth>rightDepth?(leftDepth+1):(rightDepth+1);
        return treeDepth;
    }

    //111. Minimum Depth of Binary Tree
    public int minDepth(TreeNode root) {
        /**if(root == null)
            return 0;

        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);
        int treeHeight = leftHeight<rightHeight?leftHeight:rightHeight;
        return treeHeight;*/
        //当一个节点只有一个自节点时，左子树的高度为1，右子树的高度为0，
        // 但其最小树的高度是从叶子节点到根节点，右子树没有叶子节点，所以，树的高度还是2，而不是1，所以上述代码就不对了
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
        {
            return 1;
        }

        int left = root.left != null?minDepth(root.left):Integer.MAX_VALUE;//当左结点为空时，将其高度设置成最大值，这样右子树不为零时，就可以取右子树的高度了
        int right = root.right != null?minDepth(root.right):Integer.MAX_VALUE;

        int minHeigt = left<right?left:right;
        return minHeigt + 1;
    }

    //105. Construct Binary Tree from Preorder and Inorder Traversal（前序和中序）
    Map<Integer, Integer> inMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null )
            return null;
        int preLen = preorder.length;
        int inLen = inorder.length;
        //将inorder数组映射到map中，方便查找根节点所在的索引
        for(int i=0; i<inLen; ++i)
        {
            inMap.put(inorder[i], i);
        }
        return build(preorder, 0, preLen-1, inorder, 0, inLen-1);
    }

    public TreeNode build(int[] preorder, int sPre, int ePre, int[] inorder, int sIn, int eIn)
    {
        //结束条件
        if(sPre > ePre || sIn > eIn)
            return null;

        //构建当前结点
        TreeNode node = new TreeNode(preorder[sPre]);
        //找到当前根节点在inorder中的索引
        int mid = inMap.get(preorder[sPre]);
        //计算左子树或者选择计算右子树长度，以备接下来使用
        int left = mid - sIn;
        //构建左子树
        node.left = build(preorder, sPre+1, sPre+left, inorder, sIn, mid-1);
        //构建右子树
        node.right = build(preorder,sPre+left+1, ePre, inorder, mid+1, eIn);

        return node;
    }



    public static void main(String[] args) {
        Solution su = new Solution();
        int nums1[] = {2, 1, 5, 6, 7 ,8};
        int nums2[] = {2, 8, 8, 8, 8 ,9};
        System.out.println(su.searchRange(nums2,8));

    }
}
