package DataStructures;

public class CircleArray {

    //环形队列的头部指向队列的第一个元素，初始值为0
    private int front ;
    //环形队列的尾部指向队列尾部的后一个元素，初始值为0
    private int rear ;
    //建立一个数组用于存放环形队列
    private int[] arr;
    //所建立数组的最大容量
    private int maxSize;


    //建立一个实现数组arr的构造方法
    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
    }
    //判断队列是否满
    public boolean isFull(){
        return (rear + 1)% maxSize == front;
    }
    //判断队列是否空
    public boolean isEmpty(){
        return rear==front;
    }
    //计算队列的有效数据个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
    //增加一个元素
    public void addQueue(int n){
        if(isFull()){
            System.out.print("队列已满");
            return;
        }
        arr[rear] = n;
        rear=(rear+1) % maxSize;   //取模，保证当rear超过数组长度maxSize时，能够回到原点
    }
    //从队列中取出一个元素
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空不能取数据");
        }
        int value;
        value=arr[front];
        front =(front+1)%maxSize;
        return value;
    }
    //打印整个环形数组
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列中没有元素");
        }
    //数组的长度为front+size();
        for(int i = front;i<front + size();i++){
            System.out.println(arr[i%maxSize]);   //此处取余使得rear有在front的前面的可能
        }
    }
    //求当前对列的头部
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空不能取数据");
        }
        return arr[front];
    }
}
