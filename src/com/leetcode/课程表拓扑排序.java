package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/2/28 16:05
 */
public class 课程表拓扑排序{
    List<List<Integer>> edges;// 存储有向图
    int[] visited;// 标记每个节点的状态：0=未搜索，1=搜索中，2=已完成
    boolean valid = true;//判断有向图中是否有环
    //深度遍历 拓扑排序 返回的是是否成功
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            // 给每个课程进行添加后置课程
            // 学习了info[1] 才能学习 info[0]
            edges.get(info[1]).add(info[0]);
            //给拓扑排序赋值 1是先学课程 edges存储的是每个索引值对应的后置课程列表（就是边），指得先学这些课程
        }
        // 每次挑选一个「未搜索」的节点，开始进行深度优先搜索
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {//给未排序的节点进行排序
                dfs(i);
            }
        }
        return valid;
    }
    //0代表未搜索 1代表搜索中 2代表已完成
    public void dfs(int u) {
        // 将节点标记为「搜索中」
        visited[u] = 1;
        // 搜索其相邻节点
        // 只要发现有环，立刻停止搜索
        for (int v: edges.get(u)) {//遍历先学课程列表
            // 如果「未搜索」那么搜索相邻节点
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            }
            // 如果「搜索中」说明找到了环
            else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }
}
