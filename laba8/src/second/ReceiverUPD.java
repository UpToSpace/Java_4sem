package second;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiverUPD {

    private byte[] msgbytes;
    private final int length = 10;
    private DatagramSocket socket;
    ReceiverUPD(int port) throws SocketException {
        socket = new DatagramSocket(port);
        msgbytes = new byte[length];
    }

    public void ReceiveMessage() throws IOException {
        socket.receive(new DatagramPacket(msgbytes, length));
        System.out.println(new String(msgbytes));
    }

    public static void main(String[] args) throws IOException {
        ReceiverUPD receiver = new ReceiverUPD(8190);
        while(true) {
            receiver.ReceiveMessage();
        }
    }
}
