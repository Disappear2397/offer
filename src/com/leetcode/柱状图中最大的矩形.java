package com.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/14 11:14
 * 用单调栈实现，题目比较难
 */
public class 柱状图中最大的矩形{
    //双指针超时
    public int largestRectangleArea1(int[] heights) {
        int area = 0;
        // 遍历每个柱子，以当前柱子的高度作为矩形的高 h，
        // 从当前柱子向左右遍历，找到矩形的宽度 width。
        for(int i = 0; i < heights.length; i++){
            int width = 1, j = i;
            // 找左边最后 1 个大于等于 heights[i] 的下标
            while(--j >= 0 && heights[j] >= heights[i]){
                width++;
            }

            j = i;
            // 找右边最后 1 个大于等于 heights[i] 的索引
            while(++j < heights.length && heights[j] >= heights[i]){
                width++;
            }
            area = Math.max(area, width * heights[i]);
        }
        return area;
    }

    //推荐 单调栈 两次遍历
    //堆栈声明：Deque deque = new ArrayDeque()
    /*找出一根柱子的左侧且最近的小于其高度的柱子:
    当我们枚举到第i根柱子时，我们从栈顶不断地移除height[j]≥height[i]的j值。在移除完毕后，栈顶的j值就一定满足 height[j]<height[i]，
    此时j就是i左侧且最近的小于其高度的柱子。当移除所有值，认定此时最近的小于其高度柱子在位置-1上*/
    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> mono_stack = new ArrayDeque<Integer>();//栈中存储下标
        for (int i = 0; i < n; ++i) {//从左往右遍历
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {//比heught[i]大的出栈，此时高度就是heught[i]
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());//存储每个元素的下标
            mono_stack.push(i);
        }

        mono_stack.clear();
        for (int i = n - 1; i >= 0; --i) {//从右往左遍历
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());//存储每个元素的下标
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);//减一：计算的是i左侧的面积
        }
        return ans;
    }

    //推荐 单调栈 常数优化 找出一根柱子的左侧且最近的小于其高度的柱子
    public static int largestRectangleArea3(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);//填充数组right中的每个元素都是n

        Deque<Integer> mono_stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                right[mono_stack.peek()] = i;
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);//减一：计算的是i左侧的面积
        }
        return ans;
    }

    public int largestRectangleArea4(int[] heights) {
        // 这里为了代码简便，在柱体数组的头和尾加了两个高度为 0 的柱体。
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);
        //System.arraycopy（ 原数组，从元数据的起始位置开始，目标数组，目标数组的开始起始位置，要copy的数组的长度）使头尾各加上了一个0
        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        for (int i = 0; i < tmp.length; i++) {
            // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
            // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
            // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int h = tmp[stack.pop()];
                area = Math.max(area, (i - stack.peek() - 1) * h);//减一：计算的是i左侧的面积
            }
            stack.push(i);
        }

        return area;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String[] arr = s.split(",");
        int[] a = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(largestRectangleArea3(a));
    }
}
