package DataStructures.Sort;

import java.util.Random;

public class QuickSort {
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

        quickSort(arr,0,arr.length-1);

        for (int i :arr){
            System.out.print(i+"\t");
        }
    }


    public static void quickSort(int []arr,int left,int right){
        int l=left; //左索引
        int r=right; //右索引
        int pivot=arr[(left+right)/2];

        //while循环的目的是比pivot小的放他左边，比pivot大的放他右边
        while (l<r){
            while (arr[l]<pivot){
                l+=1;
            }
            while ((arr[r]>pivot)){
                r-=1;
            }
            //如果是这样，说明pivot的左右两的值，已经按照左边全是小等于pivot、右边全是大等于pivot值
            if(l>=r){
                break;
            }

            //交换
            arr[l]^=arr[r];
            arr[r]^=arr[l];
            arr[l]^=arr[r];

            //如果交换完后，发现这个arr【l】==pivot值相等 r-- 前移一下
            if(arr[l]==pivot){
                r-=1;
            }

            //如果交换完后，发现这个arr【r】==pivot值相等 l++ 后移一下
            if(arr[r]==pivot){
                l+=1;
            }
        }
        //如果l==r，必须l++ r-- 否则为出现栈溢出  防止一个数字即当左索引又当右索引
        if(l==r){
            l+=1;
            r-=1;
        }
        //向左递归
        if (left<r) {
            quickSort(arr,left,r);
        }

        //向右递归
        if(right>l){
            quickSort(arr,l,right);
        }

    }

}
