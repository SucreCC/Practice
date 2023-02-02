package DataStructures.Graph;

/**
 * @program: Test
 * @Description: TODO
 * @Author: sucre1136@gmail.com
 */
public class Test {
    public static void main(String[] args) {
        Graph graph = new Graph(8);

        String Vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};


        for (String vertex : Vertexs) {
            graph.insertVertex(vertex);
        }
        //更新边的关系
        graph.setEdge(0, 1, 1);
        graph.setEdge(0, 2, 1);
        graph.setEdge(1, 3, 1);
        graph.setEdge(1, 4, 1);
        graph.setEdge(3, 7, 1);
        graph.setEdge(4, 7, 1);
        graph.setEdge(2, 5, 1);
        graph.setEdge(2, 6, 1);
        graph.setEdge(5, 6, 1);



//        graph.dfs();
//        System.out.println();
//        System.out.println("===================");
        graph.bfs();
        System.out.println();

        graph.showEdges();
    }
}
