import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputOutputStreamReader {

    @Test
    public void InputOutputStreamReaderTest(){
        InputStreamReader isr = null;
        try {
            FileInputStream fis = new FileInputStream("Assignment2.txt");
            //所用字符集，取决于保存时的字符集
            isr = new InputStreamReader(fis,"UTF-8");

            int len;
            char []cbf = new char[10];
            while((len = isr.read(cbf)) != -1){
                String str = new String(cbf,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null)
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

}
