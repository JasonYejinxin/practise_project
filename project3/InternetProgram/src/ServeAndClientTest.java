import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServeAndClientTest {

    //客户端
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.创建socket对象，知名服务器ip地址和端口号
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8899);

            //2.获取一个输出流，用来获取数据
            os = socket.getOutputStream();
            //3.写出数据
            os.write("hello 我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            try {
                if(os != null)
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(socket != null)
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

    //服务端
    @Test
    public void server(){
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
            //1.创建服务器端的serveSocket，指明自己的端口号
            ServerSocket serverSocket = new ServerSocket(8899);

            //2.调用accept()，表面接受客户端的socket
            socket = serverSocket.accept();

            //3.获取输入流
            is = socket.getInputStream();


            //不建议这么写，可能有乱码
//        int len;
//        byte[] buffer = new byte[1024];
//        while((len = is.read(buffer)) != -1){
//                String str = new String(buffer,0,len);
//            System.out.print(str);
//        }
            //4.读取输入流的数据
            baos = new ByteArrayOutputStream();
            int len;
            byte[] buffer = new byte[10];
            while((len = is.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }

            System.out.print(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            try {
                if(baos != null)
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(is != null)
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(socket != null)
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
