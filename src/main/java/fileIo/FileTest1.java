package fileIo;

import java.io.*;
import java.util.Arrays;

/**
 * @author sergei
 * @create 2020-04-22
 */
public class FileTest1 {

    public static void main(String[] args) throws Exception {
        //File.separator是用来分隔同一个路径字符串中的目录的
//        System.out.println(File.separator); // 输出 \
        //File.pathSeparator指的是分隔连续多个路径字符串的分隔符
//        System.out.println(File.pathSeparatorChar); //输出 ;

        File f = new File("/usr/local/1");
        System.out.println(f.getParentFile());
//        //字节写入文件。true表示追加
//        OutputStream o = new FileOutputStream(f,true);
//        o.write("b".getBytes());
//        o.flush();
//        o.close();

        //字节输出文件
//        InputStream in = new FileInputStream(f);
        // read() 读取一个字节，没有时返回-1
//        int data1 = in.read();
//        System.out.println(data1);
//        byte[] buf = new byte[10];
//        //读取多个字节保存到数组
//        in.read(buf);
//        System.out.println(Arrays.toString(buf).toString());
//        //读取多个字节
//        in.read(buf,0,5);
//        System.out.println(Arrays.toString(buf).toString());
//        in.close();

        File f1 = new File("/usr/local/2");
        //2、创建输入输出流对象
        InputStream in = new FileInputStream(f);
        OutputStream out = new FileOutputStream(f1,true);
        //3、读取和写入操作
        byte[] buffer = new byte[1];//创建一个容量为 10 的字节数组，存储已经读取的数据
        int len;//表示已经读取了多少个字节，如果是 -1，表示已经读取到文件的末尾
        while((len=in.read(buffer))!=-1){
            //打印读取的数据
            System.out.println(new String(buffer,0,len));
            //将 buffer 数组中从 0 开始，长度为 len 的数据读取到 b.txt 文件中
            out.write(buffer, 0, len);
        }
        //4、关闭流资源
        out.close();
        in.close();


        Reader rd = new InputStreamReader(in);
    }
}
