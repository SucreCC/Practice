package DataStructures.Sort;

import java.util.Random;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[8];
        Random random = new Random();
        for (int i=0;i<8;i++){
            arr[i]=(random.nextInt(10)*10);
        }

        System.out.println();
        sort(arr);

        for (int i :arr){
            System.out.print(i+"\t");
        }

    }

    private static void sort(int[] arr) {


        for (int i = 0; i <arr.length-1 ; i++) {
//            每一次循环标记 下标和值
            int minIndex=i;
            int min=arr[i];

            for (int j = i+1; j < arr.length; j++) {
                if(min>arr[j]){
                    min=arr[j];
                    minIndex=j;
                }
            }
//优化
//如果某一次排序后i的索引和minindex的索引相同  即arr[i]就是最小值那么就不需要交换了
            if(i!=minIndex){
                arr[minIndex]=arr[i];
                arr[i]=min;


            }



        }
    }
}
