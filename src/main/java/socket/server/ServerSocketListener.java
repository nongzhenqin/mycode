package socket.server;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务端socket并监听
 * @author nong
 */
public class ServerSocketListener implements Runnable {

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(12345);

            while (true){
                Socket accept = serverSocket.accept();

                JOptionPane.showMessageDialog(null, "有客户端连接到了本机的12345端口！");

                ChatSocket chatSocket = new ChatSocket(accept);
                Thread thread = new Thread(chatSocket);
                thread.start();

                ChatManager.getInstance().addUsers(chatSocket);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
