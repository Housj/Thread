package fileIo;

import java.io.*;

/**
 * @author sergei
 * @create 2020-04-22
 */
public class Data {
    public static void main(String[] args) throws Exception {
        File file = new File("a.txt");
        DataOutputStream dop = new DataOutputStream(new FileOutputStream(file));
        //写入三种类型的数据
        dop.write(65);
        dop.writeChar('哥');
        dop.writeUTF("帅锅");
        dop.close();

        //数据输入流
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        System.out.println(dis.read());  //65
        System.out.println(dis.readChar()); //哥
        System.out.println(dis.readUTF());  //帅锅
        dis.close();
    }
}
