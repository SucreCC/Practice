package DataStructures.Stack_By_DoubleLinkedList;

/**
 * @program: Node
 * @Description: TODO
 * @Author: sucre1136@gmail.com
 */
public class Node {
    public String name;
    public int no;
    public Node pre;
    public Node next;

    public Node(String name, int no) {
        this.name = name;
        this.no = no;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }
}
