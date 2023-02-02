package DataStructures.Sort;

import java.util.Random;

/**
 * @program: MergeSort
 * @Description: TODO
 * @Author: sucre1136@gmail.com
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[8];
        Random random = new Random();
        for (int t=0;t<8;t++){
            arr[t]=(random.nextInt(10)*10);
        }



        for (int t :arr){
            System.out.print(t+"\t");
        }
        System.out.println();

//归并排序需要一个额外的空间即temp数组的长度不为arr.length-1 为arr.length

        int[] temp=new int[arr.length];

        mergeSort(arr, 0, arr.length-1, temp);

        for (int h :arr){
            System.out.print(h+"\t");
        }



    }

    /**
     *
     * @param arr   需要排序的数组
     * @param left  该数组的左索引
     * @param right 该数组的右索引
     * @param temp   临时数组
     */


    public static void mergeSort(int[] arr,int left ,int right,int[] temp){
//       如果left和right相等时即分到最后只剩下一个数字时停止分开
        if (left<right){
//            中间索引
            int mid = (left+right)/2;
//            向左递归分解数组直到只剩下一个元素
            mergeSort(arr, left, mid, temp);
//            向右递归分解数组直到只剩下一个元素
            mergeSort(arr, mid+1, right, temp);
//            进行合并并且排序
            merge(arr, left, mid, right, temp);
       }
    }

    /**
     *
     * @param arr 需要进行排序的数组
     * @param left  数组的左索引
     * @param mid   数组的中间索引
     * @param right 数组的右索引
     * @param temp  临时数组
     */

    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int l =left;
        int r =mid+1;
        int t=0;

//左边从左索引开始遍历至mid  右边从mid+1处开始遍历至right处停止
        while (l<=mid && r<=right){
            if(arr[l]<=arr[r]){
                temp[t]=arr[l];
                l+=1;
                t+=1;
            }else {
                temp[t]=arr[r];
                r+=1;
                t+=1;
            }
        }

//右边到达right处左边没到mid   将左边剩余的元素加入到临时数组temp中
        while (l<=mid){
            temp[t] = arr[l];
            l+=1;
            t+=1;
        }
//左边到达mid处右边没到right   将右边剩余的元素加入到临时数组temp中

        while (r<=right){
            temp[t] = arr[r];
            r+=1;
            t+=1;
        }


//将temp排序完的数组按照索引  left至right的顺序加入到arr数组中
        t=0;
        int tempLeft=left;
        while ( tempLeft<=right){
            arr[ tempLeft]=temp[t];
            t+=1;
            tempLeft+=1;
        }
    }
}
