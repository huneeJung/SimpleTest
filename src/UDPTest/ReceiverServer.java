package UDPTest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiverServer {
    public static void main(String[] args) throws Exception{

        // UDP 소켓 생성
        DatagramSocket socket = new DatagramSocket(8888);

        // UDP 패킷 수신
        byte[] requestData = new byte[1024];
        DatagramPacket requestPacket = new DatagramPacket(requestData, requestData.length);
        socket.receive(requestPacket);

        // HTTP 요청 추출
        String httpRequest = new String(requestPacket.getData(), 0, requestPacket.getLength());
        System.out.println("Received request: " + httpRequest);

        // HTTP 응답 생성
        String httpResponse = "HTTP/1.1 200 OK\r\nContent-Type: text/plain\r\n\r\nHello, World!";
        byte[] responseData = httpResponse.getBytes();

        // 응답 패킷 생성 및 송신 서버로 전송
        InetAddress senderAddress = requestPacket.getAddress();
        int senderPort = requestPacket.getPort();
        DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, senderAddress, senderPort);
        socket.send(responsePacket);

        socket.close();
    }
}
