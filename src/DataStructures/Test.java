package DataStructures;

public class Test {
    public static void main(String[] args) {
        CircleArray arr1 = new CircleArray(10);
        for(int i = 0;i<5;i++){
            arr1.addQueue(i);

        }

        System.out.println(arr1.getQueue());
        System.out.println(arr1.headQueue());




    }

}
