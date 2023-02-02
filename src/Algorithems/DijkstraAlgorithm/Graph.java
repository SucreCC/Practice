package Algorithems.DijkstraAlgorithm;

/**
 * @program: DijkstraAlgorithm
 * @Description: TODO
 * @Author: sucre1136@gmail.com
 */
public class Graph {
    private int[][] matrix;
    private char[] vertex;
    private VisitedVertexs vv;


    /**
     * 构造方法
     *
     * @param matrix
     * @param vertex
     */

    public Graph(int[][] matrix, char[] vertex) {
        this.matrix = matrix;
        this.vertex = vertex;
    }


    /**
     * 迪杰斯特拉算法
     *
     * @param index 出发顶点对应的下标
     */
    public void Dijkstra(int index) {

        vv = new VisitedVertexs(vertex.length, index, matrix);
//        单独拿出来 表明所有结点都是直接或者间接以  index结点为起点访问到的
//        先遍历index能够达到的结点   再遍历index能达到的结点  能达到的结点     即bfs
        update(index);

//        防止出现断点 即
        for (int i = 0; i < vertex.length; i++) {
            int nextIndex = vv.getNextVertex();
            update(nextIndex);
        }
    }


    /**
     * 更新下标顶点到周围其它顶点的距离   和   其它顶点的前驱结点
     *
     * @param index
     */

    public void update(int index) {
        int[] dis = vv.dis;
        boolean[] isVisited = vv.isVisited;
        for (int i = 0; i < vertex.length; i++) {

//          起点到索引为i的结点的距离 = 起点到当前结点的距离加上当前结点到索引为i的结点的距离
            int len = vv.getDis(index) + matrix[index][i];
//            如果索引为i的结点没有被访问，且当前路径到索引为i的结点路径 小于之前某一个结点到i结点的路径
//            就更新起点到i结点的距离和i的前驱结点
            if ((!isVisited[i]) && len < dis[i]) {
                vv.setDis(len, i);
                vv.setPre_Visited(index, i);
            }
        }

    }


    public void show(int index) {
        int[] dis = vv.show();
        for (int i = 0; i < vertex.length; i++) {
            if (i == index) {
                continue;
            }
            System.out.print(vertex[index] + "->" + vertex[i] + "\t");
            System.out.println(dis[i]);

        }


    }
}
