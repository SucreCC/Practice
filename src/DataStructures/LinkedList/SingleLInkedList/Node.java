package DataStructures.LinkedList.SingleLInkedList;

public class Node {
    public int no;
    public String name;
    public Node next;

    //Node的构造方法

    public Node() {
    }

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\''
                +'}';
    }
}
