package DataStructures.LinkedList.SingleLInkedList;

public class SingleLinkedList {

    //private表示且不设置set/get方法，用来保证head不会变
   private Node head = new Node(0,null);

   //无序的增加链表
   public void add(Node node){
       Node temp=head;
       while(true){
           if(temp.next==null){
               temp.next=node;
               break;
           }
           temp=temp.next;
       }
   }
   //有序的增加列表
   public void add2(Node node){
       boolean flag = false;    //false表示插入节点，true表示编号已经存在不能再插入了
       Node temp = head;
       while(true){
           if(temp.next==null){
               break;
           }
           if(temp.next.no >node.no ){
              break;
           }else  if(temp.next.no==node.no){
               flag=true;
               break;
           }
           temp=temp.next;
       }
       if(flag){
           System.out.println("编号"+node.no+"已存在不能在添加了");
       }else {
           node.next=temp.next;
           temp.next=node;
       }
   }
   //修改链表内的数据
    public void upDate(int no,String name){
       Node temp = head;
       boolean flag=false;
       if(head.next==null){
           System.out.println("链表为空");
           return;
       }
       while (true){
           if(temp.next==null){
               flag=true;
               break;
           }
           if(temp.next.no==no){
               break;
           }
           temp=temp.next;
       }
       if(flag==true){
           System.out.println("链表中没有该编号");
       }else {
           temp.next.name=name;
       }
    }

    //删除一个节点
    public void del(int no){
       boolean flag = false;
       Node temp = head;
       while (true){
           if(temp.next==null){
               break;
           }
           if(temp.next.no==no){
               flag = true;
               break;
           }
           temp=temp.next;
       }
       if(flag){
           System.out.printf("要删除的%d节点不存在\n",no);
       }else {
            temp.next=temp.next.next;
       }
    }


   //显示整个链表
   public void showList(){
       Node temp =head;
       if(temp.next==null){
           System.out.println("链表为空，请添加数据");
           return;
       }else{
           while(true){
               if(temp.next==null){
                   break;
               }
               System.out.println(temp.next);
               temp=temp.next;
           }
       }

   }

   //反转链表
    public void reverseList(){
       //先排除第一个节点（非头节点）为空，和只有第一个节点这两种情况
        if(head.next==null||head.next.next==null){
            return ;
        }

        Node cur = head.next;
        Node next = null;
        Node reverseHead = new Node(0,null);

        //把旧的头节点后的第一个节点插入到新的头节点后，直到旧的头节点后没有节点
        while (cur!=null){
            next = cur.next;
            cur.next=reverseHead.next;
            reverseHead.next=cur;
            cur=next;
        }
        //把新的头节点换成旧的头节点
        head.next=reverseHead.next;

    }
    //显示链表的长度
    public int length(){
       int sum=0;
        Node temp =head;
        if(temp.next==null){
            System.out.println("链表为空，请添加数据");
            return -1;
        }else{
            while(true){
                if(temp.next==null){
                    return sum;
                }
                sum++;
                temp=temp.next;

            }
        }

    }




}
