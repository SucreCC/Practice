package DataStructures.LinkedList.SingleLInkedList;

public class Test {
    public static void main(String[] args) {
        Node n1 = new Node(1,"a");
        Node n2 = new Node(2,"b");
        Node n3 = new Node(3,"c");
        Node n4 = new Node(4,"d");

        SingleLinkedList s1 =new SingleLinkedList();
        s1.add(n1);
        s1.add(n2);
        s1.add(n3);
        s1.add(n4);
        s1.showList();
        s1.reverseList();
        System.out.println("--------------------------");
        s1.showList();
        s1.length();


    }
}
