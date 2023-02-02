package DataStructures.Tree.BinarySortTree;

/**
 * @program: BinarySortTreeTest
 * @Description: TODO
 * @Author: sucre1136@gmail.com
 */
public class BinarySortTreeTest {


    public static void main(String[] args) {

        int []  arr = {1,3,3,3,5,7,9};
        BinarySortTree binarySortTree = new BinarySortTree();

        for (int i : arr) {
            Node node = new Node(i);
            binarySortTree.add(node);
        }


        System.out.println("删除结点前");
        binarySortTree.infixOder();
        binarySortTree.delNode(1);
        binarySortTree.delNode(3);
        binarySortTree.delNode(9);
        binarySortTree.delNode(5);
        binarySortTree.delNode(7);
        binarySortTree.delNode(3);
        binarySortTree.delNode(3);

        System.out.println("删除结点后");
        binarySortTree.infixOder();


    }


}
