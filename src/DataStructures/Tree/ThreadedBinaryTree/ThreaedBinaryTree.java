package DataStructures.Tree.ThreadedBinaryTree;

/**
 * @program: ThreaedBinaryTree
 * @Description: TODO
 * @Author: sucre1136@gmail.com
 */
public class ThreaedBinaryTree {

    private Node root;

    private Node pre=null;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }


    /**
     * 中序线索化二叉树
     * @param node
     */


//    中序线索化二叉树
    public void threadedNode(Node node){
        if(node==null){
            return;
        }

//线索化当前节点的左子树
        threadedNode(node.getLeft());


//如果当前节点的左子树为空是把pre赋值给当前节点的左子树
        if(node.getLeft()==null){
            node.setLeft(pre);

            node.setLeftType(1);
        }
//如果当前节点的前一个节点pre不为空，且pre的右节点为空那么把node节点赋值给当前节点右子树
        if(pre!=null&&pre.getRight()==null){
            pre.setRight(node);
            pre.setLeftType(1);

        }
//节点后移
        pre=node;


//线索化当前节点的右子树
        threadedNode(node.getLeft());


    }


    /**
     * 中序遍历线索化二叉树
     * @param node
     */
    public void threaedList(Node node){

//        如果当前节点不是空那么就一直执行循环
        while (node!=null){

//            如果当前节点左节点的leftType为0就一直往左遍历直到找到左节点为1时停止
            while (node.getLeftType()==0){
                node=node.getLeft();
            }

//            打印当前节点
            System.out.println(node);

//            如果当前节点的RightType为1那么就一直往前遍历且打印
            while (node.getRightType()==1){
                System.out.println(node.getRight());
                node=node.getRight();
            }

//如果当前节点的RightType不为1那么就从新定义右节点(右节点原来就存在不是通过线索化得到的)
            node=node.getRight();




        }








    }

}
