package DataStructures.Sort;

import java.util.Random;

public class BubboSort {
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
        sort(arr);

        for (int i :arr){
            System.out.print(i+"\t");
        }

    }

    private static void sort(int[] arr) {
        int count=0;
        int temp=0;
        boolean flag=false;
        for (int i=0;i<arr.length-1;i++){
//            从最后一个位置开始往前进行排序
            for (int j =0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=true;


                }
            }
            count++;

//            如果有一次排序的时候没有进行位置交换即（flag==false）时，退出排序。
            if(!flag){
                break;
            }else {
                flag=false;

            }

        }
        System.out.println(count);




//从头到尾进行排序前面的值时最小值
// 当这种排序方式牌序的数组第一个数据是最小值时，优化算法失效，而且不会进行排序
//       0	70	0	40	0	10	40	20  这组第一个数据为最小值0的数据就不行
//
//          for (int j =i;j<arr.length;j++){
//                if(arr[i]>arr[j]){
//                    temp=arr[i];
//                    arr[i]=arr[j];
//                    arr[j]=temp;
//                    flag=true;
//                    count++;
//
//                }
//            }

    }


}
