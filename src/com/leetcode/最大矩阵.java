package com.leetcode;

import java.util.*;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/15 14:33
 */
//与柱状图中最大的矩阵那题相似
public class 最大矩阵{
    //暴力求解 类似于柱状图中的最大矩阵中的暴力求法
    //枚举以某点为右下角的全1矩阵
    public int maximalRectangle1(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];

        for (int i = 0; i < m; i++) {//把每一行中连续的1标记为长度
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ret = 0;
        for (int i = 0; i < m; i++) {//计算以matrix[i][j]为矩阵右下角的面积
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int width = left[i][j];
                int area = width;
                for (int k = i - 1; k >= 0; k--) {
                    width = Math.min(width, left[k][j]);
                    area = Math.max(area, (i - k + 1) * width);
                }
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }
    //单调栈，类似于柱状图中最大的矩阵这题，方法类似 两次遍历
    public static int maximalRectangle2(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ret = 0;
        //类似于柱状图中最大的矩阵中找出一根柱子的左侧且最近的小于其高度的柱子， 这里是找出每一行一个数左侧且最近的小于其left值的数
        for (int j = 0; j < n; j++) { // 对于每一列，使用基于柱状图的方法
            int[] up = new int[m];
            int[] down = new int[m];

            Deque<Integer> stack = new LinkedList<Integer>();
            for (int i = 0; i < m; i++) {//从矩阵上往下遍历
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {//比left[i][j]大的出栈，此时高度就是left[i][j]
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();//存储每个元素的下标
                stack.push(i);
            }
            stack.clear();
            for (int i = m - 1; i >= 0; i--) {//从矩阵下往上遍历
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? m : stack.peek();//存储每个元素的下标
                stack.push(i);
            }

            for (int i = 0; i < m; i++) {
                int height = down[i] - up[i] - 1;//减一：计算的是i左侧的面积
                int area = height * left[i][j];
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }

    //单调栈优化，类似于柱状图中最大的矩阵这题，方法类似 一次遍历
    public static int maximalRectangle3(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int maxArea = 0;
        int[] heights = new int[n];         // 柱高
        for (int row = 0; row < m; row++) {
            // 一行一行遍历，保存柱高
            // 一层一层遍历，保存柱高，相当于计算柱状图中的最大矩形
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == '1') {
                    heights[col] += 1;
                } else {
                    heights[col] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestArea(heights));
        }
        return maxArea;
    }
    // LeetCode 84 柱状图中最大的矩阵 单调栈 常数优化 找出一根柱子的左侧且最近的小于其高度的柱子
    public static int largestArea(int[] heights) {
        int n = heights.length;
        if (n == 0) {
            return 0;
        }

        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("输入二维数组的行列数：");
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();

        char[][] a = new char [r][c];
        System.out.println("输入二维数组的值：");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = (char)(scanner.nextInt()+'0');//int数组转换成char数组 需要强转前需要 + ’0‘
                //Integer.parseInt(String.valueOf(ch[i])) //这是char数组转换成int数组
            }
        }
        System.out.println(maximalRectangle2(a));
    }
}


