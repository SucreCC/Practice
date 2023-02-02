package DataStructures.LinkedList.DoubleLinkedList;

public class Node {
    public int no;
    public String name;
    public Node pre;
    public Node next;

    //Node的构造方法


    public Node(int no, String name) {
        this.no = no;
        this.name = name;

    }

    public Node() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
