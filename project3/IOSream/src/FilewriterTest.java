import org.junit.Test;

import java.io.*;

public class FilewriterTest {

    @Test
    public void FileWriterTest1() {
        FileWriter fw = null;
        try {
            File file = new File("hello1");

            fw = new FileWriter(file,true);

            fw.write("asdfg\n");
            fw.write("qwert");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
@Test
public void FileReaderWriterTest() {
    FileReader fr = null;
    FileWriter fw = null;
    try {
        File srcFile = new File("hello");
        File srcFile1 = new File("hello2");

        fr = new FileReader(srcFile);
        fw = new FileWriter(srcFile1,true);

        int len;
        char[] cbuf = new char[5];
        while((len = fr.read(cbuf)) != -1){
            fw.write(cbuf,0,len);
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if(fr != null && fw != null){
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}


}
