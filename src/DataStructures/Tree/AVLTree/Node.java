package DataStructures.Tree.AVLTree;

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
     * 返回当前的左旋树
     * 这个方法不用对象点的方式调用
     *   直接  leftRound();  就行
     */
    private void leftRound() {

//        新建一个当前结点的复制结点
        Node newNode = new Node(value);

//        新建结点的左结点为当前结点的左结点
        newNode.left = left;

//        新建结点的右结点为当前结点右结点的左结点
        newNode.right = right.left;

//        把当前结点的右结点的value值赋给当前结点
        value = right.value;

//        当前结点的左结点为新建结点
        left = newNode;

//        当前结点的右结点为当前结点右结点的右结点
        right = right.right;

    }

    /**
     * 返回当前结点右旋树
     */
    private void rightRound() {

//        新建一个当前结点的复制结点
        Node newNode = new Node(value);

//        新建结点的左结点为当前结点的左结点的右结点
        newNode.left = left.right;

//        新建结点的右结点为当前结点右结点的左结点
        newNode.right = right;

//        把当前结点的左结点的value值赋给当前结点
        value = left.value;

//        当前结点的右结点为新建结点
        right = newNode;

//        当前结点的左结点为当前结点左结点的左结点
        left = left.left;
    }


    /**
     * 返回当前结点左子树的高度
     *
     * @return
     */
    public int leftHight() {
        if (left != null) {
            return left.height();
        } else {
            return 0;
        }
    }

    //返回当前结点右子树的高度
    public int rightHight() {
        if (right != null) {
            return right.height();
        } else {
            return 0;
        }
    }


    /**
     * @return 返回当前结点的高度
     */
    private int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }


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


//        如果当前结点的左子树的高度大于右子树
        if (leftHight() - rightHight() > 1) {
//            如果左结点的右子树的高度大于左结点左子树的高度
            if (left != null && left.rightHight() > left.leftHight()) {
//                左结点先左旋 然后当前结点右旋
                left.leftRound();
                rightRound();
            } else {
//                当前结点直接右旋
//               如果用 node.rightRound() 调用rightRound()方法 会导致rightRound()方法中太多this太麻烦
               rightRound();
            }
//返回避免出问题
            return;
        }


//        如果当前结点的右子树的高度大于左子树
        if (rightHight() - leftHight() > 1) {
            if (right != null && right.leftHight() > right.rightHight()) {
                right.rightRound();
                leftRound();
            } else {
                leftRound();
            }
            return;
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
     *
     * @param value 要删除的值
     * @return 要删除结点的父结点
     */


    public Node searchParentNode(int value) {

        if ((null != this.left && this.left.value == value) || (null != this.right && this.right.value == value)) {
            return this;
        }


        if (null != this.left && this.left.value > value) {
            return this.left.searchParentNode(value);
        }

        if (null != this.right && this.right.value < value) {
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

    public Node() {
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
