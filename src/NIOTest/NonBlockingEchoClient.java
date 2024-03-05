package NIOTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class NonBlockingEchoClient {
    public static void main(String[] args) throws IOException {
        // 서버에 연결
        InetSocketAddress hostAddress = new InetSocketAddress("localhost", 9000);
        SocketChannel client = SocketChannel.open(hostAddress);

        // 보낼 메시지 준비
        String message = "안녕하세요!";
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());

        // 서버로 메시지 전송
        client.write(buffer);
        buffer.clear();

        // 서버로부터의 응답 읽기
        client.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.print(Charset.forName("UTF-8").decode(buffer));
        }
        buffer.clear();

        // 연결 종료
        client.close();
    }
}
