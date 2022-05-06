package second;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SenderUPD {
    private DatagramSocket sender;

    SenderUPD(int port) throws SocketException {
        sender = new DatagramSocket(port);
    }

    void SendMessage(String message, int port) throws IOException {
        DatagramPacket msg = new DatagramPacket(message.getBytes(StandardCharsets.UTF_8), message.length(), InetAddress.getLocalHost(), port);
        sender.send(msg);
    }

    public static void main(String[] args) throws IOException {
        SenderUPD sender = new SenderUPD(8191);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String cmd = scanner.nextLine();
            sender.SendMessage(cmd, 8190);
        }

    }
}
