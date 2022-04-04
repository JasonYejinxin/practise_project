import org.junit.Test;

import java.io.*;

public class BufferedTest {
    @Test
    public void BufferedTest1() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcfile = new File("psb.jpg");
            File destfile = new File("psb3.jpg");

            //造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream(srcfile);
            FileOutputStream fos = new FileOutputStream(destfile);

            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            int len;
            byte[] buffer = new byte[10];
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    @Test
    public void BufferedTest2() {
        copyFileWithBuffered("psb.jpg", "psb4.jpg");
    }


    public void copyFileWithBuffered(String src, String dest) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcfile = new File(src);
            File destfile = new File(dest);

            //造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream(srcfile);
            FileOutputStream fos = new FileOutputStream(destfile);

            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            int len;
            byte[] buffer = new byte[10];
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void BufferedReaderWriterTest() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("hello")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("hello3")));



    }



}