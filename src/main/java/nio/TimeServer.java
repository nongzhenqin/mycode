package nio;

/**
 * NIO测试：时间服务器服务端
 */
public class TimeServer {

    public static void main(String[] args){
        MultiplexerTimeServer multiplexerTimeServer = new MultiplexerTimeServer(8080);
        new Thread(multiplexerTimeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
