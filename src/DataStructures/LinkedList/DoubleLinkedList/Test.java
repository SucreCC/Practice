package DataStructures.LinkedList.DoubleLinkedList;

public class Test {
    public static void main(String[] args) {
        Node n1 = new Node(1,"a");
        Node n2 = new Node(2,"b");
        Node n3 = new Node(3,"c");
        Node n4 = new Node(4,"d");

        DoubleLinkedList s1 =new DoubleLinkedList();
        s1.add2(n1);

        s1.add2(n2);

        s1.add2(n4);

        s1.add2(n3);

        s1.showList();




    }
}
