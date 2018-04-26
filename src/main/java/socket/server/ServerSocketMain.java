package socket.server;

/**
 * @author nong
 */
public class ServerSocketMain {

    public static void main(String[] args){
        Thread thread = new Thread(new ServerSocketListener());
        thread.start();
    }
}
