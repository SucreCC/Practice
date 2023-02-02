package DataStructures.Stack_By_DoubleLinkedList;

/**
 * @program: Test
 * @Description: TODO
 * @Author: sucre1136@gmail.com
 */
public class Test {
    public static void main(String[] args) {
        LinkedStack ls = new LinkedStack();
        LinkedStack ls2 = new LinkedStack();

        System.out.println(ls);
        System.out.println(ls2);

        Node n1 = new Node("赵信",1);
        Node n2 = new Node("盖伦",2);
        Node n3 = new Node("寒冰",3);
        Node n4 = new Node("拉克丝",4);


        ls.push(n1);
        ls.push(n2);
        ls.push(n3);
        ls.push(n4);

        ls.show();
        System.out.println("==============");
        System.out.println(ls.pop());
        ls.show();


    }
}
