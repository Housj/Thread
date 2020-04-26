package fileIo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author sergei
 * @create 2020-04-22
 */
public class ByteArratytTest {

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        bo.write("test".getBytes());
        byte[] temp = bo.toByteArray();
        System.out.println(new String(temp,0,temp.length));

        byte[] buffer = new byte[10];
        ByteArrayInputStream bi = new ByteArrayInputStream(temp);
        int len;
        while((len = bi.read(buffer))!=-1){
            System.out.println(new String(buffer,0,len));
        }

        bo.close();
        bi.close();


    }
}
