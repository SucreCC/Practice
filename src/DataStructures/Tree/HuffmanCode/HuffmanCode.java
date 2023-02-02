package DataStructures.Tree.HuffmanCode;

import java.io.*;
import java.util.*;

/**
 * @Description: TODO
 * @Author: sucre1136@gmail.com
 */
public class HuffmanCode {

    private static StringBuilder stringBuilder = new StringBuilder();
    //    用于存储huffman编码表
    private static Map<Byte, String> huffmanCodes = new HashMap<>();
    //    用于存放压缩码
    private static Map<Byte, String> codes = new HashMap<Byte, String>();


    /**
     * 用huffman编码进行文件压缩
     *
     * @param srcFile 需要压缩的文件的路径
     * @param dstFile 压缩后文件放置的路径
     */
    public void FileZip(String srcFile, String dstFile) {

//        文件输入流
        InputStream inputStream = null;
//        文件输出流
        OutputStream outputStream = null;
//        对象输出流
        ObjectOutputStream objectOutputStream = null;

        try {

            inputStream = new FileInputStream(srcFile);

//按照输入文件的大小创建一个字节数组
            byte[] bytes = new byte[inputStream.available()];

//            文件中的数据读到betes数组中
            inputStream.read(bytes);
//用hffman编码进行压缩
            byte[] huffmanZip = BytesZip(bytes);

//            把文件输出流改为对象输出流
            outputStream = new FileOutputStream(dstFile);
            objectOutputStream = new ObjectOutputStream(outputStream);

//            把huffman编码后的字节数组和huffman编码表通过对象输出流输出
            objectOutputStream.writeObject(huffmanZip);
            objectOutputStream.writeObject(huffmanCodes);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
//                关闭流
                objectOutputStream.close();
                inputStream.close();
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * 解压文件
     *
     * @param srcFile 解压文件的路径
     * @param dstFile 解压后文件存放的路径
     */

    public void unFileZip(String srcFile, String dstFile) {

//        文件输入流
        InputStream inputStream = null;
//        对象输入流
        ObjectInputStream objectIutputStream = null;
//        文件输出流
        OutputStream outputStream = null;


        try {
//            创建对象输入流
            inputStream = new FileInputStream(srcFile);
            objectIutputStream = new ObjectInputStream(inputStream);

//          获取huffman压缩码 和huffman编码表
            byte[] huffmanBytes =(byte[]) objectIutputStream.readObject();
            Map<Byte,String> huffmanCodes = (Map<Byte, String>) objectIutputStream.readObject();

//            解压缩
            byte[] bytes = unBytesZip(huffmanBytes, huffmanCodes);

//            输出
            outputStream = new FileOutputStream(dstFile);
            outputStream.write(bytes);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
//                关闭流
                inputStream.close();
                objectIutputStream.close();
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }


    /**
     * 解压缩
     *
     * @param BytesZip 传入压缩后的十进制字符数组
     * @param huffmanCodes huffman编码表
     * @return 压缩前的语句
     * <p>
     * 计算机中存储的是二进制数的补码
     * <p>
     * 正数的原码  反码  和补码相同
     * 负数的补码负数的反码为对该数的原码除符号位外各位取反。
     * 负数的补码为对该数的原码除符号位外各位取反，然后在最后一位加1
     * <p>
     * 由于byte是每8位截取一段转换位十进制数的  所以需要对正数不足的位进行补0操作
     */


    public byte[] unBytesZip(byte[] BytesZip, Map<Byte,String> huffmanCodes) {

        //把压缩后的十进制转换为二进制码   计算机存储的是二进制补码


//        用于拼接二进制码
        StringBuilder strCodes = new StringBuilder();

//        遍历huffmanBytesZip把十进制数转换为二进制机器码
        for (int i = 0; i < BytesZip.length; ++i) {

//            byet类型转换为int类型   然后使用Interger类把int转换为二进制的机器码
            int temp = BytesZip[i];

//            判断是不是最后一个数字  最后一个数字不管是正数还是负数都直接转换为二进制补码
            boolean flag = (i != BytesZip.length - 1);

//            按位或  两个数有一个1  那么生成的第三分数的那一位就是1
//            负数和256按位与不变  正数会补足前面不足的0 成为
            if (flag) {
                temp |= 256;  //按位或 256  1 0000 0000  | 0000 0001 => 1 0000 0001
            }

//            把十进制数转换位二进制数
            String string = Integer.toBinaryString(temp);

//            如果不是数组的最后一个数 就截取最后8位
            if (flag) {
                String substring = string.substring(string.length() - 8);
                strCodes.append(substring);
//如果是数组的最后一个数 就直接拼接就可以了
            } else {
                strCodes.append(string);
            }
        }


//       反转huffman编码表 把key 和value对调  方便下面通过二进制码找到对应的字符
        Map<String, Byte> reverseHuffmanCodes = new HashMap<>();
        Set<Map.Entry<Byte, String>> entries = huffmanCodes.entrySet();

        for (Map.Entry<Byte, String> entry : entries) {
            reverseHuffmanCodes.put(entry.getValue(), entry.getKey());
//            System.out.println(entry.getValue()  +"   " + (char)(int)entry.getKey() );
        }


//        对照huffman编码表 用StringBuilder对字符进行拼接
        StringBuilder res = new StringBuilder();

//        for循环遍历二进制码
        for (int i = 0; i < strCodes.length(); ) {

//            i不动用count来进行移动
            int count = 1;
            boolean flag = true;
//            用于接收查询后的字符
            Byte b = null;

            while (flag) {
//                subctring进行截取
                String substring = strCodes.substring(i, i + count);
//                用huffman编码表进行查询
                b = reverseHuffmanCodes.get(substring);
//                如果查询到了就退出循环  没有count自增后再查询
                if (null != b) {
                    flag = false;
                } else {
                    ++count;
                }
            }
//            把查询到的byte转换成char字符进行拼接
            res.append((char) (int) b);
//            把count赋值给i  进行下一次截取  循环开始时count被重新赋值为1
            i += count;
        }


//    返回bytes数组
        return  res.toString().getBytes();
    }


    /**
     * 封装好的huffman压缩方法
     *
     * @param bytes 需要压缩的字节数组
     * @return 压缩后的十进制字节数组
     */


    public byte[] BytesZip(byte[] bytes) {
//        把字符串转换为权值结点的集合
        List<Node> nodes = creatList(bytes);

//      把集合转换为huffman树
        Node root = creatHuffmanTree(nodes);

//      按照路径把每一个字符转换为huffman编码
        Map<Byte, String> huffmanCodes = getHuffmanCode(root);

        //        打印每个字符所对应的huffman码
//        Set<Map.Entry<Byte, String>> entries = huffmanCodes.entrySet();
//        for(Map.Entry<Byte, String> e : entries){
//            int key = e.getKey();
//            System.out.println((char) key + "  " +  e.getValue() );
//        }

//压缩
        byte[] BytesZip = zip(bytes, huffmanCodes);

//        返回Huffman编码的map集合
        return BytesZip;
    }


    /**
     * 输入字符串转化为List集合
     *
     * @param bytes 要编码的字节数组
     * @return 返回由Node结点组成的List集合
     */
    private List<Node> creatList(byte[] bytes) {

//      创建一个hashMap用来存放每一个字符，和该字符出现的次数即权值
        Map<Byte, Integer> hashMap = new HashMap<Byte, Integer>();
//        用于存储Node结点
        ArrayList<Node> nodeList = new ArrayList<>();


//        遍历bytes数组 并统计字符出现的次数  且加入到map集合中
        for (byte b : bytes) {
            Integer count = hashMap.get(b);
            if (count == null) {
                hashMap.put(b, 1);
            } else {

//                此处用count++ 是错误的  它的意思是先添加进hashMap后再自增
//                可以用++count   和count+1
                hashMap.put(b, count + 1);
            }
        }

//        遍历map集合并根据字符和字符出现的次数创建Node结点，并且加入到list集合中
        Set<Map.Entry<Byte, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<Byte, Integer> entry : entries) {
            nodeList.add(new Node(entry.getKey(), entry.getValue().intValue()));
        }

        return nodeList;
    }


    /**
     * 生成huffman树的方法
     *
     * @param nodeList 存放Node结点的List集合
     * @return huffman树的根结点
     */
    private Node creatHuffmanTree(List<Node> nodeList) {

//        一直循环直至集合中只剩下一个Node结点
        while (nodeList.size() > 1) {

//            先对集合进行排序
            Collections.sort(nodeList);

//            取出集合中权值最小的两个结点

            Node leftNode = nodeList.get(0);
            Node rightNode = nodeList.get(1);

//            生成一个父结点  其data值为空   权值为取出的两个结点的权值之和
            Node parentNode = new Node(null, leftNode.weight + rightNode.weight);

//            把这两个结点添加到父结点的左右两边
            parentNode.setLeft(leftNode);
            parentNode.setRight(rightNode);

//从list集合中移除这两个结点
            nodeList.remove(leftNode);
            nodeList.remove(rightNode);

//            把父结点添加到list集合中
            nodeList.add(parentNode);
        }
        nodeList.get(0).preOder();
//        返回根结点
        return nodeList.get(0);
    }


    /**
     * 下面方法的重载方法，实际用这个方法即可
     *
     * @param root huffman树的根结点
     * @return 返回huffman树中所有子叶结点的路径拼接值
     */

    private Map<Byte, String> getHuffmanCode(Node root) {
        if (null == root) {
            return null;
        }
        getHuffmanCode(root.getLeft(), "0", stringBuilder);
        getHuffmanCode(root.getRight(), "1", stringBuilder);

        return huffmanCodes;
    }


    /**
     * 生成huffman编码的map格式的原始方法
     *
     * @param node          传入的结点
     * @param code          路径的值  左边为0  右边为1
     * @param stringBuilder 用于拼接路径
     */

    private void getHuffmanCode(Node node, String code, StringBuilder stringBuilder) {

//        用于拼接路径
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);

//        结点不为空的情况  可能是子叶结点  也可能是非子叶结点
        if (null != node) {

//            如果data值为空的话是非子叶结点 继续向下遍历
            if (node.data == null) {
                getHuffmanCode(node.getLeft(), "0", stringBuilder1);
                getHuffmanCode(node.getRight(), "1", stringBuilder1);
            } else {
//                huffman树的子叶结点都在树的最底端  说明已经遍历到头了
//                此时把该结点的 data 和  拼接完全的路径加入map中
                huffmanCodes.put(node.data, stringBuilder1.toString());
            }
        }
    }


    /**
     * 把字符串压缩为十进制byte数组
     *
     * @param bytes        需要压缩的字节数组
     * @param huffmanCodes huffman编码表
     * @return 压缩后的压缩码
     */


    private byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {


//        用于拼接经过huffman编码表转换后的机器码
        StringBuilder strCodes = new StringBuilder();

//        遍历bytes数组，把每个字符转换为huffman编码，然后拼接到StringBuild上变成 由0 1构成的机器码
        for (byte b : bytes) {
            strCodes.append(huffmanCodes.get(b));
        }


//       把机器码的长度+7 除以8 得到压缩数组的长度
        int size = (strCodes.length() + 7) / 8;

//        用于存储要生成的huffman压缩码的byte数组
        byte[] huffmanBystes = new byte[size];

//        用于计数
        int count = 0;

//        把机器码按照每八位一组转换成十进制数
        for (int i = 0; i < strCodes.length(); i += 8) {
            String substring;

            if (i + 8 > strCodes.length()) {
//                如果最后一段长度不够那么从那一段的i索引处开始 直到最后一个  取出
                substring = strCodes.substring(i);
            } else {
                substring = strCodes.substring(i, i + 8);
            }

//            radix：2  代表2进制   输入二进制而后转换为十进制
            huffmanBystes[count] = (byte) Integer.parseInt(substring, 2);
            count++;
        }
        return huffmanBystes;
    }


    /**
     * 前序遍历huffman树
     *
     * @param root huffman树的根结点
     */
    private void preOder(Node root) {
        if (root != null) {
            root.preOder();
        } else {
            System.out.println("huffman树为空，不能进行遍历");
        }
    }


}
