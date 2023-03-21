package calculator;

import calculator.domain.Calculator;
import calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CustomWebApplicationServer {

    private final int port;

    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomWebApplicationServer] started {} port.", port);

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client.");

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected");

                /**
                 *  STEP 2 - 사용자 요청이 들어올 때마다 Thread를 새로 생성해서 사용자 요청처리
                 *  STEP 1에서는 Main Thread에서 처리했던 로직을, 새롭게 Thread객체를 만들고 거기에 이양함.
                 *  그런데 쓰레드는 생성 될 때마다 메모리 공간을 할당 받아야 함.
                 *  그럼 한 번에 엄청 많은 요청이 몰리면? 당연히 성능이 무지하게 떨어짐.
                 */

                new Thread(new ClientRequestHandler(clientSocket)).start();
            }
        }
    }
}
