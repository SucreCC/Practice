package DataStructures.EightQueen;

/**
 * @program: EightQueen
 * @Description: TODO
 * @Author: sucre1136@gmail.com
 */
public class EightQueen {
//    定义一个count变量用来统计一共有多少中摆法
     static int count=0;

     int max=8;
//   定义棋盘的行数
     int[] answer = new int[max];

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.check(0);
        System.out.println("一共有"+count+"种情况");
    }



// check方法用来回溯棋盘
    private  void check(int n ) {

//      判断某一种摆放方式是否能放下八个皇后，如果能的话就打印这种摆放方式，然后回溯
        if(max==n){
            print();
            return;
        }

//     遍历8列

        for (int i = 0; i<max  ; i++) {
//            把皇后放在第n行的第i列
            answer[n]=i;
// 调用第judge方法，判断第把皇后放在第n行的第i列是否会和前面的摆好的皇后之间有冲突，
// 如果没冲突的话，就去n+1行放置皇后，如果有冲突的话，就把皇后放置到第n行的第i+1列然后再判断是否冲突。
// 直到放完整个8列
            if (judge(n)){
                check(n+1);
            }
        }
    }


//打印八皇后的放置位置，每一种换一行
    private  void print() {
        for (int i = 0; i <answer.length ; i++) {
            System.out.print(answer[i] + " ");
        }
        count++;
        System.out.println();
    }

//把第n行第i列的皇后和第n行前面放置好的皇后之间进行检查，有冲突返回false,没有返回true
    private  boolean judge(int n ) {
        for (int i = 0; i <n ; i++) {

//            如果第n行第i列的皇后与前面的任意一个皇后再同一列或者在对角线上就不满足摆放要求
            if(answer[i]==answer[n]||Math.abs(i-n)==Math.abs(answer[i]-answer[n])){
                return false;

            }
        }
        return true;
    }

}
