package netty.echo;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

public class EchoServer {

    private final int port;

    public EchoServer(int port){
        this.port = port;
    }

    public static void main(String[] args){
        new EchoServer(8080).start();
    }

    public void start(){
        final EchoServerHandler echoServerHandler = new EchoServerHandler();

        EventLoopGroup group = new NioEventLoopGroup();
        try {

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            group.shutdownGracefully().sync();
        }
    }
}
