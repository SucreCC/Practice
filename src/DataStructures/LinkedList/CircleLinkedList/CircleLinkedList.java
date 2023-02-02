package DataStructures.LinkedList.CircleLinkedList;

public class CircleLinkedList {

    //private表示且不设置set/get方法，用来保证head不会变
   private Node first = new Node(0,null);


    //创建链表的第一个元素first
    public void setFirst(int no,String name){
        first.setNo(no);
        first.setName(name);
        first.setNext(first);
    }

    //无序的添加元素.
    private Node temp1 = first;
    public void add(Node node){
        temp1.setNext(node);
        node.setNext(first);
        temp1=node;
    }

//

    //计算链表长度
    public int size(){
        if(first.getName()==null){
           return 0;
        }else if(first.getNext()==first){
            return 1;
        }else {
            Node temp = first;
            int sum=0;
            while(temp.getNext()!=first){
                sum++;
                temp=temp.getNext();
            }
            return sum;
        }

    }

//    约瑟夫环，start：从几号节点开始，s：间隔几个
    public void start(int start,int s){
        int temp = start;
        int sum=0;
        Node temp2=first;
        while (true){
            if(start==sum){
                break;
            }
            sum++;
            temp2=temp2.getNext();
        }


    }


}
