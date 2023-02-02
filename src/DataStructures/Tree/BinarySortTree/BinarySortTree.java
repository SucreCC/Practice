package DataStructures.Tree.BinarySortTree;

/**
 * @program: BinarySortTree
 * @Description: TODO
 * @Author: sucre1136@gmail.com
 */
public class BinarySortTree {
    private Node root;




    /**
     * 删除结点
     * 1.要删除的树不存在 即没有根结点
     * 2.要删除的结点不存在
     * 3.要单独考虑根结点是要删除的结点的情况:
     *   (1).要删除的根结点没有左右子树
     *   (2).要删除的根结点有左子树或右子树
     *   (3).要删除的根结点有左子树和右子树
     * 4.要删除的结点为叶子结点
     * 5.要删除的结点有一个左子结点或右子结点
     * 6.要删除的结点有左子结点和右子结点
     *
     * @param value
     */

    public void delNode(int value) {

        Node node = searchTragetNode(value);
        Node parentNode = searchParentNode(value);

//        先排除root结点为空  或者删除结点不存在的情况

        if (null == root) {
            return;
        }

        if (null == node) {
            return;
        }

//      再排除要删除的结点为根结点
        if (node == root) {
//       1.根结点没有左右子树的情况
            if (root.left == null && root.right == null) {
                root = null;
//        2.根结点有右子树或左子树
            }else {
                if(root.left!=null&&root.right==null){
                    root=root.left;
                }else if(root.left==null&&root.right!=null){
                    root=root.right;
//         3.根结点有右子树和左子树
                }else if(root.left!=null&&root.right!=null){
//          找到要删除节点的右子节点 从这个节点一直向左遍历找到要删除节点右子树的最小值 然后删除这个最小值节点
//           把最小值赋给当前节点  即完成删除当前节点了
                    int i = delRightMin(node.right);
                    node.value = i;
                }
            }
            return;
        }



//        删除子叶结点(左子叶结点或右子叶结点)  如果要删除的

        if (null == node.left && null == node.right) {
            if (parentNode.left == node) {
                parentNode.left = null;
            } else if (parentNode.right == node) {
                parentNode.right = null;
            }

//        删除的结点为带有两个子叶结点

        } else if (null != node.left && null != node.right) {
//          找到要删除节点的右子节点 从这个节点一直向左遍历找到要删除节点右子树的最小值 然后删除这个最小值节点
//           把最小值赋给当前节点  即完成删除当前节点了
            int i = delRightMin(node.right);
            node.value = i;

//        删除的结点带有一个子叶结点

        } else {
//                如果要删除结点是父结点的右子结点
            if (parentNode != null && parentNode.left == node) {
//            要删除的结点的左子结点不为空，右子结点为空
                if (node.left != null && node.right == null) {
                    parentNode.left = node.left;
                }
//            要删除结点的左子结点为空，右子结点不为空

                if (node.right != null && node.left == null) {
                    parentNode.left = node.right;
                }

//                如果要删除结点是父结点的右子结点
            } else if (parentNode != null && parentNode.right == node) {
                //            要删除的结点的左子结点不为空，右子结点为空
                if (node.left != null && node.right == null) {
                    parentNode.right = node.left;
                }
//            要删除结点的左子结点为空，右子结点不为空

                if (node.right != null && node.left == null) {
                    parentNode.right = node.right;
                }
            }
        }
    }


    /**
     * 删除以当前节点作为根节点查找出来的最小值 即最左的子叶节点
     *
     * @param node 当前结点
     * @return 返回要删除的最小值
     */
    private int delRightMin(Node node) {
        Node temp = node;
        while (temp.left != null) {
            temp = temp.left;
        }
        delNode(temp.value);
        return temp.value;
    }

    /**
     * 查找要删除的结点
     *
     * @param value 要删除的结点的值
     * @return 找到返回该结点否者返回空
     */

    private Node searchTragetNode(int value) {
        if (null != root) {
            return root.searchTargetNode(value);
        } else {
            return null;
        }
    }

    /**
     * 返回要删除结点的父结点
     *
     * @param value 要删除结点的值
     * @return 要删除的结点
     */
    private Node searchParentNode(int value) {
        if (root != null) {
            return root.searchParentNode(value);
        } else {
            return null;
        }
    }


    /**
     * 二叉树的添加结点
     *
     * @param node 需要添加的结点
     */

    public void add(Node node) {
        if (null != root) {
            root.addNode(node);
        } else {
            root = node;
        }

    }

    /***
     * 二叉树的中序遍历
     */

    public void infixOder() {
        if (null != root) {
            root.infixOder();
        } else {
            System.out.println("二叉树为空，请添加结点！");
        }
    }


    public BinarySortTree() {
    }


}
