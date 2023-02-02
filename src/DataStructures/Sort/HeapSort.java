package DataStructures.Sort;

import java.util.Random;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[8];
        Random random = new Random();
        for (int i=0;i<8;i++){
            arr[i]=(random.nextInt(10)*10);
        }
        for (int i :arr){
            System.out.print(i+"\t");
        }
        System.out.println();
        heapSort(arr);

        for (int i :arr){
            System.out.print(i+"\t");
        }

    }

    /**
     * 堆排序  从下至上从左至右
      * @param arr 需要排序的数组
     */

    public static void heapSort(int[] arr) {

//    先从下至上对二叉树进行排序 使二叉树变为大顶堆

//        通过for循环找到二叉树的每一个非叶子节点 所以要减去1
        for(int i =(arr.length/2)-1;i>=0;i--){
//            从数的底部的第一个非叶子节点开始向上调整（当传入第i个非叶子节点时，把i下面的最大值放到i节点处）
            adjustHeap(arr, i, arr.length);
        }

//再从上至下取出堆顶的最大值依次放置再数组的尾部，然后再对剩余的结点进行二叉树调整 变成大顶堆
//        按照从小到大的顺序对数组进行排序，先调整最右边的数
        for(int j=arr.length-1;j>0;j--){
            arr[j]^=arr[0];
            arr[0]^=arr[j];
            arr[j]^=arr[0];
//            当拿掉顶部最大的数后，需要从新调整二叉树并把最大值推到树顶部
//            但是需要调整的数组长度减小1
            adjustHeap(arr, 0, j);
        }

    }

    /**
     * 把数组转换为二叉树并调整二叉树，使得二叉树顶部为最大值
     * @param arr 需要调整的数组
     * @param i 调整i一下（包括i）的节点，找到这部分的最大值，并放到i节点处
     * @param length  转换数组的长度 从o 到 length处
     */

    public static void adjustHeap(int[] arr,int i,int length){

//        保存索引i处的值
        int temp=arr[i];

//      从i节点往下查找其左右节点 直到二叉树的底部
        for(int k =2*i+1;k<length ;k=2*k+1){

//            如果i节点处的左结点的值小于右节点的值那么 就比较右结点的值与i节点值的大小
//            k++ 的意思是从左结点调整到右结点
            if(k+1<length && arr[k]<arr[k+1]){
                k++;
            }
//左结点或右结点的值大于i结点的值那么  把i结点的值替换成左结点或右结点的值
//            知道循环结束后 把底部最大值放到i结点处
            if(arr[k]>arr[i]){
                arr[i]=arr[k];

//                把要交换的k保存到i处  便于最后的交换
                i=k;
            }else {
                break;
            }
        }

//        把原来arr[i]的值temp 放到arr[k]处达成交换
        arr[i]=temp;
    }
}
