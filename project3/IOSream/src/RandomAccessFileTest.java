import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

    @Test
    public void randomAccessFileTest1(){
        RandomAccessFile raf = null;
        RandomAccessFile raf1 = null;
        try {
            raf = new RandomAccessFile(new File("hello"),"r");
            raf1 = new RandomAccessFile(new File("hello1.txt"),"rw");

            int len;
            byte []buffer = new byte[1024];
            raf1.seek("hello".length() * 2);
            while((len = raf.read(buffer)) != -1){
                raf1.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf != null){
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void randomAccessFileTest2(){

        RandomAccessFile raf = null;
        RandomAccessFile raf1 = null;
        try {
            raf = new RandomAccessFile(new File("hello1.txt"),"rw");
            raf1 = new RandomAccessFile(new File("hello2.txt"),"rw");

            int len;
            byte[] buffer = new byte[10];

            while((len = raf.read(buffer)) != -1){
                raf1.write(buffer,0,len);
            }

            raf1.seek(5);
            raf1.write("olleh".getBytes());

            raf.write(raf1.read());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(raf != null)
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(raf1 != null)
                raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }
}
