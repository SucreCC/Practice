package DataStructures.Tree.HuffmanCode;

/**
 * @program: Node
 * @Description: TODO
 * @Author: sucre1136@gmail.com
 */

//实现comparable接口便于在集合中进行比较
public class Node implements Comparable<Node> {

//   存储信息
    Byte data;
//    存储data信息的权值
    int weight;
    
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }


    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                ", weight=" + weight +
                '}';
    }


//表示由小到大排列
    @Override
    public int compareTo(Node o) {
        return this.weight-o.weight;
    }


//    前序遍历方法
    public void preOder(){
        if(this.left!=null){
            this.left.preOder();
        }
        if (this.right!=null){
            this.right.preOder();
        }
    }
}
