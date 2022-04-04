import org.junit.Test;

import java.io.*;

public class FileInputOutputStream {

    @Test
    public void FileInputStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcfile = new File("psb.jpg");
            File destfile = new File("psb1.jpg");


            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(destfile);

            int len;
            byte[] cbf = new byte[5];
            while((len = fis.read(cbf)) != -1){
                fos.write(cbf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis != null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos != null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
