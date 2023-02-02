package DataStructures.Sort;

/**
 * @program: InsertSort
 * @Description: TODO
 * @Author: sucre1136@gmail.com
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {-1,8,1,10,6};

        for(int i : arr){

            System.out.print(i+"\t");
        }
        System.out.println();

        Insertsort(arr);

        for(int i : arr){

            System.out.print(i+"\t");
        }


    }

    private static void Insertsort(int[] arr) {
        for (int i = 1; i < arr.length;  i++) {
            int insertValue = arr[i];
            int insertIndex=i-1;


            while (0<insertIndex && insertValue< arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;

            }

            arr[insertIndex+1]=insertValue;

        }
    }
}
