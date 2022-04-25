package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/4/23 16:20
 */
public class 根据身高重建队列{
    //从高到低考虑
    public static int[][] reconstructQueue(int[][] people) {
        /*身高从大到小排（身高相同k小的站前面）
        按照身高为第一关键字降序，个数为第二关键字升序进行排序
        第 0,⋯,i−1 个人已经在队列中被安排了位置，他们只要站在第i个人的前面，就会对第i个人产生影响，因为他们都比第i个人高
        而第i+1,⋯,n−1 个人还没有被放入队列中，并且他们无论站在哪里，对第i个人都没有任何影响，因为他们都比第i个人矮。*/
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });//sort第二个参数是比较器
      /*  Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });*/

        LinkedList<int[]> que = new LinkedList<>();

        for (int[] p : people) {
            que.add(p[1],p);//插在索引值为p[1]的位置，后面的往后移
        }

        return que.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        System.out.println("输入二维数组的行列数：");
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();

        int[][] a = new int [r][c];
        System.out.println("输入二维数组的值：");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] =scanner.nextInt();
                //Integer.parseInt(String.valueOf(ch[i])) //这是char数组转换成int数组
            }
        }
        System.out.println(Arrays.deepToString(reconstructQueue(a)));
    }
}
