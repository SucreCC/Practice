package Algorithems.KMP;

/**
 * @program: KMP
 * @Description: TODO
 * @Author: sucre1136@gmail.com
 */
public class KMP {


    public static void main(String[] args) {
        String ts = "BBC ABCDABABCDABCDABDE";
        String ps = "ABCDABD";

        int i = kmpSearch(ts, ps);

        System.out.println(i);

    }


    /**
     * @param ts 原字符串
     * @param ps 模式串
     * @return 匹配上返回模式串在原字符串上面的起点，  没有返回-1
     *
     *
     *    重点：   next[j]的定义，就是当子串的第j位和主串的第i位不一致时，下一次，和主串i位进行比较的子串的j指针的位置
     */

    public static int kmpSearch(String ts, String ps) {


        char[] t = ts.toCharArray();
        char[] p = ps.toCharArray();
        int[] next = getNext(p);
        int i = 0;
        int j = 0;

//next数组的意义  当原字符串和模式串在模式串的 j处不匹配时（ t[i] ！= p[j])）
//        元字符串的i不变  下一次和主串   t[i]相比较的是p[next[j]]   即j向前移动了  next[j]位
        while (i < t.length && j < p.length) {
            if (j == -1 || t[i] == p[j]) {
                ++i;
                ++j;
            } else {
//                当j等于0时     j = next[j]=-1；
                j = next[j];
            }
        }


        if (j == p.length) {
            return i - j + 1;
        } else {
            return -1;
        }
    }


    /**
     * 输入模式串返回next数组
     *
     * @param p 模式串的char数组
     * @return next数组
     *
     * 重点：   next[j]的定义，就是当子串的第j位和主串的第i位不一致时，下一次，和主串i位进行比较的子串的j指针的位置
     *
     */

    public static int[] getNext(char[] p) {


        int[] next = new int[p.length];


//        注意K的初始值为-1
        next[0] = -1;
        int j = 0;
        int k = -1;

////        j从0开始计数肯定是 p.length - 1
        while (j < p.length - 1) {
//     当 p[j] == p[k])不相等时  k回到第 next[k]个位置  与不后退的j  继续比较  直到数组遍历完


//            k不懂 j增加
            if (k == -1 || p[j] == p[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }

        return next;
    }
}
