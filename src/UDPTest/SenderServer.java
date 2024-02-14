package UDPTest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class SenderServer {
    public static void main(String[] args) throws Exception {

        // UDP 소켓 생성
        DatagramSocket socket = new DatagramSocket();

        // HTTP 요청 생성 및 UDP 패킷으로 캡슐화
        String httpRequest = "GET / HTTP/1.1\r\nHost: example.com\r\n\r\n";
        byte[] requestData = httpRequest.getBytes();
        InetAddress destinationAddress = InetAddress.getByName("localhost");
        int destinationPort = 8888;
        DatagramPacket requestPacket = new DatagramPacket(requestData, requestData.length, destinationAddress, destinationPort);

        // UDP 패킷 전송
        socket.send(requestPacket);

        // 응답 패킷 수신
        byte[] responseData = new byte[1024];
        DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length);
        socket.receive(responsePacket);

        // 응답 추출
        String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
        System.out.println("Received response: " + response);

        socket.close();
    }
}
