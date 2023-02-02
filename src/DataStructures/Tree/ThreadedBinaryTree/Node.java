package DataStructures.Tree.ThreadedBinaryTree;

/**
 * @program: Node
 * @Description: TODO
 * @Author: sucre1136@gmail.com
 */
public class Node {
    private int no;
    private String name;
    private Node left;
    private Node right;


    private int leftType;
    private int rightType;


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

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }


    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }


//    删除结点
    public void delNode(int no){
        if(this.left!=null&&this.left.no==no){
            this.left=null;
            return;

        }


        if(this.right!=null&&this.right.no==no){
            this.right=null;
            return;

        }


        if (this.left!=null){
            this.left.delNode(no);
        }


        if (this.right!=null){
            this.right.delNode(no);
        }


    }


//    前序遍历
    public void preOder(){
        System.out.println(this);

        if(this.left!=null){
            this.left.preOder();
        }

        if(this.right!=null){
            this.right.preOder();
        }
    }

    //    中序遍历
    public void infixOder(){


        if(this.left!=null){
            this.left.infixOder();
        }

        System.out.println(this);

        if(this.right!=null){
            this.right.infixOder();
        }
    }
    //    后序遍历
    public void postOder(){


        if(this.left!=null){
            this.left.postOder();
        }

        if(this.right!=null){
            this.right.postOder();
        }

        System.out.println(this);
    }



//    前序查找
    public Node preSerach(int no){
        if(this.no==no){
            return this;
        }

        Node node=null;

        if(this.left!=null){
            return node=this.left.preSerach(no);
        }

        if (node!=null){
            return node;
        }

        if(this.right!=null){
            return node=this.right.preSerach(no);

        }
        return node;

    }


    //    中序查找
    public Node infixSerach(int no){


        Node node=null;

        if(this.left!=null){
            return node=this.left.preSerach(no);
        }

        if (node!=null){
            return node;
        }


        if(this.no==no){
            return this;
        }


        if(this.right!=null){
            return node=this.right.preSerach(no);

        }
        return node;

    }


    //    后序查找
    public Node postSerach(int no){

        Node node=null;

        if(this.left!=null){
            return node=this.left.preSerach(no);
        }

        if (node!=null){
            return node;
        }

        if(this.right!=null){
            return node=this.right.preSerach(no);

        }


        if(this.no==no){
            return this;
        }

        return node;

    }


}
