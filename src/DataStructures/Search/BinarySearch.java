package DataStructures.Search;

import java.util.ArrayList;

/**
 * @program: BinarySearch
 * @Description: TODO
 * @Author: sucre1136@gmail.com
 */
public class BinarySearch {
    public static void main(String[] args) {

        int[] arr={1,200,300,500,500,500,600};
        ArrayList<Integer> arrayList = new ArrayList<>();

        ArrayList<Integer> integers = binarySearch(arr, 0, arr.length - 1, 500);
        System.out.println(integers.toString());


    }


    /**
     *   第一种二分查找 只返回一个要查找的值
     * @param arr   要查找的数组
     * @param left  要查找数组的左索引
     * @param right 要查找数组的右索引
     * @param findValue 要查找的值
     * @return int 返回一个int类型的数字
     */

    public static int binarySearch1(int[] arr, int left, int right,int findValue) {

//        如果没有找到就返回-1
        if(left>right){
            return -1;
        }

        int mid = (left+right)/2;
        int midValue=arr[mid];

//如果中间值大于要查找的值从中间左边使用binarySearch方法
        if(midValue > findValue){
            return binarySearch1(arr, left, mid-1, findValue);
//如果中间值小于于要查找的值从中间右边使用binarySearch方法
        }else if(midValue < findValue){
            return binarySearch1(arr, mid+1, right, findValue);
//      如果找到了就返回这个值所对应的下标
        }else {
           return mid;

        }

    }











    /**
     * 第二种二分查找  找出数组中所有等于value的索引
     * @param arr  要查找的数组
     * @param left  要查找数组的左索引
     * @param right 要查找数组的右索引
     * @param findValue  要查找的值
     * @return ArrayList<Integer>  返回一个数组
     */



    public static ArrayList<Integer> binarySearch(int[] arr, int left, int right,int findValue) {

//        如果没有找到就返回一个空的数组
        if(left>right){
            return new ArrayList<Integer>();
        }

        int mid = (left+right)/2;
        int midValue=arr[mid];

//如果中间值大于要查找的值从中间左边使用binarySearch方法
        if(midValue > findValue){
            return binarySearch(arr, left, mid-1, findValue);
//如果中间值小于于要查找的值从中间右边使用binarySearch方法
        }else if(midValue < findValue){
            return binarySearch(arr, mid+1, right, findValue);
//      如果找到了中间值 那么从中间值左右两边再查找有没有符合要求的值
        }else {
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(mid);

            int temp=mid-1;

            while (true){
                if (temp>0 && arr[temp]==findValue){
                    integers.add(temp);
                    temp-=1;
                }else {
                    break;
                }
            }

            temp=mid+1;
            while (true){
                if(temp<right && arr[temp]==findValue){
                    integers.add(temp);
                    temp+=1;
                }else {
                    break;
                }

            }
            return integers;

        }

    }
}