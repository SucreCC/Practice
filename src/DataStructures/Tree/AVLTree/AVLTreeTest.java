package DataStructures.Tree.AVLTree;


public class AVLTreeTest {

    public static void main(String[] args) {
        int[] arr = {10, 11, 7, 6, 8, 9};

        AVLTree avlTree = new AVLTree();
        for (int i : arr) {
            avlTree.add(new Node(i));
        }
        Node root = avlTree.root;

        System.out.println("左结点的高度" + root.leftHight());
        System.out.println("右结点的高度" + root.rightHight());


    }
}
