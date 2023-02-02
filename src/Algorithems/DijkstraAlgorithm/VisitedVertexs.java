package Algorithems.DijkstraAlgorithm;

import java.util.Arrays;

/**
 * @program: VertexsVisited
 * @Description: TODO
 * @Author: sucre1136@gmail.com
 */
public class VisitedVertexs {

    //    存储顶点是否被访问的信息，被访问为true  没有就是false 动态更新
    public boolean[] isVisited;
    //   j=pre_Visited[i]   表示i结点前一个结点的下标是j
    public int[] pre_Visited;

    //    保存出发点至终点的距离   如A-B-C  表示从出发到C的距离  动态更新
    public int[] dis;


    /**
     * 构造方法
     *
     * @param length 图中顶点的个数
     * @param index  定义的出发点
     */

    public VisitedVertexs(int length, int index, int[][] edges) {
        isVisited = new boolean[length];
        pre_Visited = new int[length];
        dis = new int[length];

//        把index顶点对应的这一行的权值全部赋予最大值
        Arrays.fill(dis, 65535);


        isVisited[index] = true;
        this.dis[index] = 0;
    }


    /**
     * 判断顶点是否被访问
     *
     * @param index 需要判断的顶点的下标
     * @return 被访问返回true  没有返回false
     */
    public boolean isVisited(int index) {
        return isVisited[index];
    }

    /**
     * 把顶点的状态设置为被访问
     *
     * @param index 需要设置的顶点的下标
     */
    public void setIsVisited(int index) {
        isVisited[index] = true;
    }


    /**
     * 获取某个顶点到起点的距离
     *
     * @param index 需要查询顶点的下标
     * @return 返回该顶点到起点的距离
     */
    public int getDis(int index) {
        return dis[index];
    }


    /**
     * 更新某个顶点到起点的距离
     *
     * @param len   需要更新的距离
     * @param index 要更新的顶点的下标
     */
    public void setDis(int len, int index) {
        dis[index] = len;
    }

    public void setPre_Visited(int per ,int index){
        pre_Visited[index]=per;

    }




    /**
     * 获取下一个没有被访问的结点
     *
     * @return  返回该结点的下标
     */

    public int getNextVertex() {
        int index = 0;

        for (int i = 0; i < isVisited.length; i++) {
//           没有被访问  又可以被连接的结点   如果dis[i]=65536 说明这个点不可以
            if ((!isVisited[i])&& dis[i] < 65535) {
                index = i;
//                该点被访问了
                isVisited[i] = true;
            }
        }
        return index;
    }


    public int[] show(){

        return dis;
    }


}
