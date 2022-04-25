package com.leetcode.并查集;

import java.util.*;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/4/15 16:33
 */
public class 除法求值{
    //并查集 看不懂   也可以用深度优先和广度优先搜索解决
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();

        UnionFind unionFind = new UnionFind(2 * equationsSize);
        // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码 在并查集里，每个节点会记录它的父节点
        Map<String, Integer> hashMap = new HashMap<>(2 * equationsSize);
        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if (!hashMap.containsKey(var1)) {
                hashMap.put(var1, id);
                id++;
            }
            if (!hashMap.containsKey(var2)) {
                hashMap.put(var2, id);
                id++;
            }
            unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }

        // 第 2 步：做查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);

            if (id1 == null || id2 == null) {
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }

    private class UnionFind {

        private int[] parent;

        /**
         * 指向的父结点的权值
         */
        private double[] weight;


        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
            // 关系式的推导请见「参考代码」下方的示意图
            weight[rootX] = weight[y] * value / weight[x];
        }

        /**
         * 路径压缩
         *
         * @param x
         * @return 根结点的 id
         */
        public int find(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }




    //深度优先dfs  需要创建邻接表
    Map<String,Integer> map = new HashMap<>();
    public double[] calcEquation1(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //构建有向图的邻接表
        List<double[]>[] graph = buildGraph(equations,values);
        int index = 0;
        double[] answer = new double[queries.size()];
        for(List<String> query : queries) {
            //如果存在未知变量 返回-1
            if(!map.containsKey(query.get(0)) || !map.containsKey(query.get(1))) {
                answer[index++] = -1;
                continue;
            }
            //进行dfs搜索
            answer[index++] = dfs(graph,map.get(query.get(0)),map.get(query.get(1)),new HashSet<Integer>(),1);
        }
        return answer;
    }
    /**
     *
     * @param graph 邻接表
     * @param cur 当前节点
     * @param end 终点
     * @param visited 存储已经访问过的节点
     * @param result 结果
     * @return
     */
    double dfs(List<double[]>[] graph,int cur,int end,HashSet<Integer> visited,double result) {
        //如果已经访问过
        if(visited.contains(cur)) {
            return -1;
        }
        //如果遍历到终点
        if(cur == end) {
            //返回结果
            return result;
        }
        //标记节点已经访问过
        visited.add(cur);
        //遍历其邻接点
        for(double[] next : graph[cur]) {
            double temp = dfs(graph,(int) next[0],end,visited,result * next[1]);
            //如果返回结果不为-1
            if(temp != -1) {
                //说明找到结果 返回即可
                return temp;
            }
        }
        return -1;
    }

    //构建有向图的邻接表
    List<double[]>[] buildGraph(List<List<String>> equations, double[] values) {
        int index = 0;
        //遍历变量对数组
        for(List<String> pair : equations) {
            String a = pair.get(0);
            String b = pair.get(1);
            //为每一个变量映射整数索引
            if(!map.containsKey(a)) {
                map.put(a,index++);
            }
            if(!map.containsKey(b)) {
                map.put(b,index++);
            }
        }
        List<double[]>[] graph = new LinkedList[map.size()];
        for(int i : map.values()) {
            graph[i] = new LinkedList();
        }
        index = 0;
        //构建邻接表
        for(List<String> pair : equations) {
            int a = map.get(pair.get(0));
            int b = map.get(pair.get(1));
            double ans = values[index++];
            graph[a].add(new double[]{(double) b,ans});
            ans = 1 / ans;
            graph[b].add(new double[]{(double) a,ans});
        }
        return graph;
    }


    //纯广度优先 无需显式构建邻接表
//    将整个问题建模成一张图：给定图中的一些点（变量），以及某些边的权值（两个变量的比值），试对任意两点（两个变量）求出其路径长（两个变量的比值）
    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvars = 0;//边数
        Map<String, Integer> variables = new HashMap<String, Integer>();

        int n = equations.size();
        for (int i = 0; i < n; i++) { //初始化每个节点和节点的个数
            if (!variables.containsKey(equations.get(i).get(0))) {
                variables.put(equations.get(i).get(0), nvars++);
            }
            if (!variables.containsKey(equations.get(i).get(1))) {
                variables.put(equations.get(i).get(1), nvars++);
            }
        }

        // 对于每个点，存储其直接连接到的所有点及对应的权值
        List<Pair>[] edges = new List[nvars];
        for (int i = 0; i < nvars; i++) {
            edges[i] = new ArrayList<Pair>();
        }
        for (int i = 0; i < n; i++) {
            int va = variables.get(equations.get(i).get(0)), vb = variables.get(equations.get(i).get(1));
            edges[va].add(new Pair(vb, values[i]));
            edges[vb].add(new Pair(va, 1.0 / values[i]));//存储两个相连节点的权值
        }

        int queriesCount = queries.size();
        double[] ret = new double[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            List<String> query = queries.get(i);
            double result = -1.0;
            if (variables.containsKey(query.get(0)) && variables.containsKey(query.get(1))) {
                int ia = variables.get(query.get(0)), ib = variables.get(query.get(1));
                if (ia == ib) {
                    result = 1.0;
                } else {
                    Queue<Integer> points = new LinkedList<Integer>();
                    points.offer(ia);
                    double[] ratios = new double[nvars];
                    Arrays.fill(ratios, -1.0);
                    ratios[ia] = 1.0;

                    while (!points.isEmpty() && ratios[ib] < 0) {
                        int x = points.poll();
                        for (Pair pair : edges[x]) {
                            int y = pair.index;
                            double val = pair.value;
                            if (ratios[y] < 0) {
                                ratios[y] = ratios[x] * val;
                                points.offer(y);
                            }
                        }
                    }
                    result = ratios[ib];
                }
            }
            ret[i] = result;
        }
        return ret;
    }
    class Pair{
        int index;
        double value;

        Pair(int index, double value) {
            this.index = index;
            this.value = value;
        }
    }
}

