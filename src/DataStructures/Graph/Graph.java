package DataStructures.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @program: Graph
 * @Description: TODO
 * @Author: sucre1136@gmail.com
 * 每个顶点A对应一行 表示这一行中每一列代表一个其他的顶点B....   如果不为0表示 A能到B结点
 */
public class Graph {

    //    储存图对应的邻接矩阵
    private int[][] edges;
    //    储存顶点
    private ArrayList<String> vertexList;
    //    储存图中边的个数
    private int numOfEdges;
    //    表示顶点是否被访问
    private boolean[] isVisited;


    /**
     * 深度优先算法
     * for循环的存在是为了在出现断点的时候能够遍历到
     */
    public void dfs() {
        isVisited = new boolean[vertexList.size()];

        for (int i = 0; i < vertexList.size(); i++) {

//            获取这一行的第一个相邻的结点
            int column = getFirstVertex(i);
//            如果这一行有相邻结点那么就进入深度优先的重载方法
            if (!isVisited[i]) {
//                System.out.print(vertexList.get(i) + "->");
//                isVisited[i] = true;
                dfs(i, isVisited);
            }
        }
    }

    /**
     * 广度优先算法
     * for循环的存在是为了在出现断点的时候能够遍历到
     */

    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                bfs(i, isVisited);
            }
        }
    }

    /**
     * 广度优先算法的重载方法
     * 把一行内所有顶点遍历完   再遍历这一行所对应的第一个邻接顶点所对应那一行   重复上述步骤
     * @param row
     * @param isVisited
     */

    private void bfs(int row, boolean[] isVisited) {

//        先输出这一行所对应的顶点
        System.out.print(vertexList.get(row) + "->");
        isVisited[row] = true;


//        用链表创建一个队列 用来储存这一行没有被访问的顶点
        LinkedList<Integer> queue = new LinkedList<>();


//        获取这一行的第一个邻接顶点所对应的列
        int column ;
//        用来表示行
        int nextRow;

//        把传入的行储存在队列中
        queue.addLast(row);

//        如果队列不为空     这一行所有没有遍历的顶点没有没访问完
        while (!queue.isEmpty()) {
//            从队列中取出一个邻接顶点所对应的行   第nextRow行
            nextRow = queue.removeFirst();

//            获取这一行中的第一个邻接顶点
            column = getFirstVertex(row);

//            如果存在就进入循环   把这一行中所有没有被访问的邻接顶点对应的行加入至队列中
            while (column != -1) {
                if (!isVisited[column]) {
                    System.out.print(vertexList.get(column) + "->");
                    isVisited[column] = true;
                    queue.addLast(column);
                }

//                获取 第nextRow行  下一个邻接顶点所对应的列
                column = getNextVertex(nextRow, column);

            }
        }
    }


    /**
     * 深度优先算法的重载方法
     *  在一行中找到它的邻接顶点对应的列   进入这一列所属顶点所在的行  重复上述步骤
     *
     * @param row       要查找的行
     * @param isVisited 用来存储某一个顶点是否被访问
     */

    private void dfs(int row, boolean[] isVisited) {

//        输出这一行所对应的的顶点
        System.out.print(vertexList.get(row) + "->");
//        表示这个顶点已经被访问了
        isVisited[row] = true;

//获取这一行中第一个邻接顶点所对应的列
        int firstColumn = getFirstVertex(row);
//        如果存在邻接顶点
        while (firstColumn != -1) {
//            如果这个邻接顶点没有被访问过  跳到这一列所对应的行进行dfs搜索
            if (!isVisited[firstColumn]) {
                dfs(firstColumn, isVisited);

            }
//            如果有被访问那么就获取下一个邻接顶点 再进入while循环
            firstColumn = getNextVertex(row, firstColumn);

        }
    }


    /**
     * 返回第row行的第一个邻接顶点的下标
     *
     * @param row 第row行的下标
     * @return 有邻接顶点 边的权重不为0   返回列的下标 没有返回-1
     */


    public int getFirstVertex(int row) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[row][i] != 0) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 返回第row行第column列后的下一个邻接顶点的下标
     *
     * @param row    行
     * @param column 列
     * @return 有邻接顶点 边的权重不为0   返回列的下标 没有返回-1
     */
    public int getNextVertex(int row, int column) {
        for (int i = column + 1; i < vertexList.size(); i++) {
            if (edges[row][i] != 0) {
                return i;
            }
        }
        return -1;
    }


    //    创建n个结点的邻接矩阵
    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>();
    }

    //    插入顶点
    public void insertVertex(String s) {
        vertexList.add(s);
    }

    /**
     * 修改顶点
     *
     * @param index 要修改的顶点的索引
     * @param s     要修改顶点的值
     */
    public void setVertex(int index, String s) {
        vertexList.set(index, s);
    }

    /**
     * 设置边
     *
     * @param row    row->column  A->B
     * @param column column->row  B->A
     * @param weight 边的权重
     */

    public void setEdge(int row, int column, int weight) {
        edges[row][column] = weight;
        edges[column][row] = weight;
        ++numOfEdges;
    }


    //    显示邻接矩阵
    public void showEdges() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    public int getEdge(int row, int column) {
        return edges[row][column];
    }

    //显示边的个数
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //    显示顶点的个数
    public int getNumOfVertxs() {
        return vertexList.size();
    }
}
