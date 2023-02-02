package DataStructures.Sort;

import java.util.Random;

/**
 * @program: RadixSort
 * @Description: TODO  基数排序会耗费额外的内存空间（java的堆内存） 比快排更快  基数 > 快排 > 希尔
 * @Author: sucre1136@gmail.com
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[8];
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            arr[i] = (random.nextInt(10) * 10);
        }
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
        radixSort(arr);

        for (int i : arr) {
            System.out.print(i + "\t");
        }

    }


    private static void radixSort(int[] arr) {

//      假设第一个数组中第一个数为最大的一个数
        int max = arr[0];

//      找出数组中的最大数
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }

//        求出最大数是几位数
        int maxLength = (max + "").length();


//      定义一个二维数组，表示10个桶，每个桶就是一个一维数组
//        二维数组包含10个一维数组
//        为了防止数据溢出，每个桶的大小为arr.length
        int[][] bucket = new int[10][arr.length];


//        创建10个计数桶用来记录各个桶中存放数据的个数
//        如  bucketElementCounts[0]=5  表示第0号桶中存放了5个数
        int[] bucketElementCounts = new int[10];


//控制循环次数为数组中最大数的位数
        for (int t = 0, n = 1; t < maxLength; t++, n *= 10) {

//把arr数组中所有的元素放入桶中
            int digitOfElement = 0;
            for (int i = 0; i < arr.length; i++) {
                digitOfElement = arr[i] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];

//              表示第 digitOfElement 号桶内的数字的个数
                bucketElementCounts[digitOfElement]++;
            }

        }

        //把桶中的元素放入到arr数组中
        int index = 0;
        for (int j = 0; j < bucket.length; j++) {
            if (bucketElementCounts[j] > 0) {
                for (int k = 0; k < bucketElementCounts[j]; k++) {
                    arr[index++] = bucket[j][k];
                }
            }
            bucketElementCounts[j] = 0;
        }

    }


}
