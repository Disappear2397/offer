package com.leetcode.并查集;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/4/15 16:33
 */
public class 省份数量{//也可以用深度优先和广度优先搜索解决
    //在并查集里，每个节点会记录它的父节点
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        int[] parent = new int[cities]; //定义一个
        for (int i = 0; i < cities; i++) {//初始化父节点是自身
            parent[i] = i;
        }
        for (int i = 0; i < cities; i++) {
            for (int j = i + 1; j < cities; j++) {//j = i + 1  j是i的下一个节点
                if (isConnected[i][j] == 1) {//相连则合并节点
                    union(parent, i, j);
                }
            }
        }
        int provinces = 0;
        for (int i = 0; i < cities; i++) {
            if (parent[i] == i) {  //父节点是本身的节点 说明这是一个集合 （同一个集合只有一个节点父节点是其本身）
                provinces++;
            }
        }
        return provinces;
    }

    public void union(int[] parent, int index1, int index2) {//合并有相同父节点的节点
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {//查找父节点
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}
