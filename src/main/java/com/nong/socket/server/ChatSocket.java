package com.nong.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 内容输出
 * @author nong
 */
public class ChatSocket implements Runnable {

    private Socket socket;

    public ChatSocket(Socket socket) {
        this.socket = socket;
    }

    public boolean socketIsClosed(){
        return socket.isClosed();
    }

    public void outMsg(String msg){
        try {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write((msg+"\n").getBytes("UTF-8"));
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
//        try {
//            int count = 0;
//            while (true){
//                count++;
//                outMsg("Loop" + count + "\n");
//                Thread.sleep(500);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

            String line;

            while ((line = bufferedReader.readLine()) != null){
                ChatManager.getInstance().publish(this, line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
