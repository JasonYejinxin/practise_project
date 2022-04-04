import org.junit.Test;

import java.net.*;

public class SenderAndReceiverTest {
    @Test
    public void sender() throws UnknownHostException, SocketException {

        DatagramSocket socket = new DatagramSocket();

        String str = new String("我是被射出来的那个东西");
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getByName("172.0.0.1");
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,9090);
        socket.send(packet);

        socket.close();

    }
    @Test
    public void receiver() throws SocketException {
        DatagramSocket socket = new DatagramSocket(9900);

        byte[] buffer = new byte[20];

        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);
        socket.receive();

        System.out.println(new String(packet.getData(),0,packet.getLength()));

        socket.close();
    }
}
