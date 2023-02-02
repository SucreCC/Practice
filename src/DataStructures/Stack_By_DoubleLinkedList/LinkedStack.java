package DataStructures.Stack_By_DoubleLinkedList;

/**
 * @program: LinkedStack
 * @Description: TODO
 * @Author: sucre1136@gmail.com
 */
public class LinkedStack {

        static Node first = new Node();
        static Node last = new Node();

        //使用代码块优先使得头节点和尾节点连接起来
        {first.next=last;
        last.pre=first;}




        public void push(Node node){

            //插入的节点node和尾节点的前一个相连
            node.pre=last.pre;
            last.pre.next=node;

            //插入节点node和尾节点last相连
            last.pre=node;
            node.next=last;

        }

        public Node pop(){
            Node temp =last.pre;
            last.pre=last.pre.pre;
            last.pre.next=last;
            return temp;

        }

        public void show(){
            Node temp=last.pre;
            if(temp==first){
                System.out.println("the LinkedStack is empty");
            }
            while(first!=temp){
                System.out.print(temp);
                temp=temp.pre;

            }

        }


    //运算符的优先级
    public int priority(int oper){

        int priority=0;
        if('+'==oper||'-'==oper){
            priority = 1;
        }else if('*'==oper||'/'==oper){
            priority = 2;
        }
        return priority;
    }

    //判断是否为运算符
    public boolean isOper(int  val){
        return '+'==val || '-'==val || '*'==val || '/'==val;

    }

    //进行计算
    public static int caculte(int num1,int num2,int oper){

        int sum=0;
        if('+'==oper){
            sum= num1+num2;
        }else if('-'==oper){
            sum= num2-num1;
        }else if('*'==oper){
            sum= num1*num2;
        }else if('/'==oper){
            sum= num2/num1;
        }
        return sum;
    }













}
