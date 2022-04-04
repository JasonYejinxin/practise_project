import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    @Test
    public void testFileReader() {
        FileReader fr = null;
        try {
            //1.实例化File对象，说明读取的文件
            File file = new File("hello");
            //2.提供具体的流
            fr = new FileReader(file);
            //3.返回一个字符，如果达到文件末尾，返回-1
//        int data = fr.read();
//        while(data != -1){
//            System.out.print((char)data);
//            data = fr.read();
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.流的关闭操作
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testFileReader1() {
        FileReader fr = null;
        try {
            File file = new File("hello");

            fr = new FileReader(file);

            char[] cbuf = new char[3];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                //方式一
                //错误写法
//                for (int i = 0; i < cbuf.length; i++) {
//                    System.out.print(cbuf[i]);
//                }
                //正确写法
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuf[i]);
//                }
                //方式二
                //错误写法，对应方式一的错误写法
//                String str = new String(cbuf);
//                System.out.print(str);
                //正确写法
                String str = new String(cbuf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
