package DataStructures.Caculator;
/**
 * @program: Caculator
 * @Description: TODO
 * @Author: sucre1136@gmail.com
 */


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class Caculator {
    public static void main(String[] args) {

        System.out.print("请输入要计算的公式：");
        Scanner scanner = new Scanner(System.in);
        String expresion = scanner.next();

//        给输入的表达式加"#"便于把最后的一个多位数加入数字栈中
        String express = trandform(expresion+ "#");


        caculate(express);


    }


    //中缀表达式转后缀表达式
    private static String trandform(String expresion) {
        //接收运算符的栈
        Stack<String> stringStack = new Stack<>();
        //接收数字的栈
        Stack<String> intStack = new Stack<>();

        char[] chars = expresion.toCharArray();

//        建立一个list数组用于接受表达式
        ArrayList<String> list = new ArrayList<>();

        for (char c : chars ){
            list.add(String.valueOf(c));
        }

//        用于拼接多位数
        String help = "";

        for ( String s : list){
//            如果是数字就拼接到help后面
            if (s.matches("\\d+")){
                help +=s;
            }else {
//                如果help不为空或者s为"#"就把help放入数栈中，在把help变为空
                if(help!=null||"#"==s){
                    intStack.push(help);
                    help="";
                }

//              如果s是运算符
                if(isOper(s)){

//                    如果操作符栈为空或者栈顶元素是"("  直接入操作符栈
                    if(stringStack.empty()||"(".equals(stringStack.lastElement())){
                        stringStack.push(s);

//                        如果栈顶元素不是"("且先级低于将要入栈的元素的优先级那么s直接入操作符栈
                    }else if ((!"(".equals(stringStack.lastElement()))&&priority(stringStack.lastElement()) < priority(s)) {
                        stringStack.push(s);

//                        如果栈顶元素不是"("且优先级大于等于s的优先级那么从操作符栈弹出一个符号至数栈后s再入栈
                    } else if ((!"(".equals(stringStack.lastElement()))&&priority(stringStack.lastElement()) >= priority(s)) {
                        intStack.push(stringStack.pop());
                        stringStack.push(s);
                    }

//                    如果s是"("那么直接压入符号栈
                }else if("(".equals(s)){
                    stringStack.push(s);

//                    如果s是")"把操作符栈的元素弹出至数栈中知道栈顶元素是"("后再弹出"("但不入数栈
                }else if(")".equals(s)){
                    while (true){
                        if(!"(".equals(stringStack.lastElement())){
                            intStack.push(stringStack.pop());

                        }else {
                            stringStack.pop();
                            break;
                        }
                    }
                }
            }
        }




//把符号栈中的元素放到数栈中
        while (!stringStack.empty()){
            intStack.push(stringStack.pop());
        }


//反转栈中的元素
        while (!intStack.empty()){
            stringStack.push(intStack.pop());
        }





//用String拼接符号栈中弹出的元素且每个元素间插入空格
        String express = "";
        while (!stringStack.empty()){
            if("".equals(stringStack.lastElement())){
                stringStack.pop();}else {
                express= express  + "#"+stringStack.pop() ; }
        }

//        去除字符串首的""(""占用express 1个位置)
        String substring = express.substring(1);

        return substring;

    }


    //用于后缀表达式的计算
    public static void caculate(String express){
//        按空格分割后缀表达式然后放入String数组中
        String[] split1 = express.split("#");

        ArrayList<String> split = new ArrayList<>();


//        把Strting数组中的元素放入ArrayList集合中
        for (String s : split1){
            split.add(s);
        }
        split.remove(" ");

        Stack<String> strings = new Stack<>();
        int ras=0;
//        便利集合中的元素
        for (String s : split){
//            如果是数字就入栈
            if(s.matches("\\d+")){
                strings.push(s);
            }else {
//              如果是运算符就从栈中弹出两个数字
                int num2 = Integer.parseInt(strings.pop());
                int num1 = Integer.parseInt(strings.pop());

//判断是什么类型的运算符并做相应的运算
                if("-".equals(s)){
                    ras = num1 - num2;
                }else if("+".equals(s)){
                    ras = num1 + num2;
                }else if("*".equals(s)){
                    ras = num1 * num2;
                }else if("/".equals(s)){
                    ras = num1 / num2;
                }
                strings.push(""+ras);
            }
        }
        System.out.println(Integer.parseInt(strings.pop()));

    }


    //判断是否是运算符
    public static boolean isOper(String s){
        return "+".equals(s)||"-".equals(s)||"*".equals(s)||"/".equals(s);
    }


    //判断运算符的优先级
    public static int priority(String s){
        int ras = -1 ;
        if("-"==s||"+"==s){
            ras=1;
        }
        if ("*"==s||"/"==s){
            ras=2;
        }
        return ras;
    }
}