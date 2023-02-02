package DataStructures.Tree.BinarySortTree;

/**
 * @program: Node
 * @Description: TODO
 * @Author: sucre1136@gmail.com
 */
public class Node {
    int value;
    Node left;
    Node right;


    /**
     * 左子树小于父结点小于右子树
     *
     * @param node 需要添加的结点
     */

    public void addNode(Node node) {

        if (null == node) {
            return;
        }


        if (node.value < this.value) {
            if (null == this.left) {
                this.left = node;
            } else {
                this.left.addNode(node);
            }

        } else {
            if (null == this.right) {
                this.right = node;
            } else {
                this.right.addNode(node);
            }
        }
    }

    /**
     * 查找需要删除的结点
     *
     * @param value 需要删除的结点的值
     */


    public Node searchTargetNode(int value) {
        if (value == this.value) {
            return this;
        } else {
            if (this.value > value) {
                if (null != this.left) {
                    return this.left.searchTargetNode(value);
                } else {
                    return null;

                }
            } else {
                if (null != this.right) {
                    return this.right.searchTargetNode(value);
                } else {
                    return null;
                }
            }
        }
    }


    /**
     * 查找要删除结点的父结点  没有包括传入的第一个root结点
     * @param value  要删除的值
     * @return  要删除结点的父结点
     */


    public Node searchParentNode(int value) {

        if ((null != this.left && this.left.value == value) || (null != this.right && this.right.value == value)) {
            return this;
        }


        if (null != this.left && this.left.value > value) {
            return this.left.searchParentNode(value);
        }

        if(null != this.right && this.right.value < value){
            return this.right.searchParentNode(value);
        }

        return null;

    }








    /**
     * 中序遍历
     */

    public void infixOder() {

        if (null != this.left) {
            this.left.infixOder();
        }

        System.out.println(this);


        if (null != this.right) {
            this.right.infixOder();
        }


    }

    public Node(int value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
