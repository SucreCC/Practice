package DataStructures.Sort;

import java.util.Random;

public class ShellSort {
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

        shellSort(arr);

        for (int i :arr){
            System.out.print(i+"\t");
        }
    }

    private static void shellSort(int[] arr) {
//        gap为步长  步长由（arr.length/2）减小到1
        for (int gap = arr.length/2; gap >0 ;gap/=2 ) {
//            从gap开始对后续的数据采用插入排序一直到arr.length
            for (int i =gap; i <arr.length ; i++) {
//存储第i个位置上的索引和值
                int index=i;
                int indexValue=arr[index];
//如果第index个位置上的值小于第 index-gap 位置上的值就进行插入排序
                if(arr[index]<arr[index-gap]){
                    while (index-gap>=0 &&arr[index]<arr[index-gap]){
                        arr[index]=arr[index-gap];
                        index=index-gap;
                    }
//                    替换
                    arr[index+gap]=indexValue;
                }
            }

        }

    }
}
