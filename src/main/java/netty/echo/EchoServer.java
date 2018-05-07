package netty.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class EchoServer {

    private int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args){
        new EchoServer(8080).start();
    }

    public void start(){
        // 在netty的模型中，acceptorGroup用于处理连接
        EventLoopGroup acceptorGroup = new NioEventLoopGroup();
        // 在netty的模型中，handleGroup用于处理Handler的I/O操作
        EventLoopGroup handleGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(acceptorGroup, handleGroup)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    // 添加一个EchoServerHandlerd到子Channel的ChannelPipeline
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            // EchoServerHandler被添加@Shareable，所以我们总是可以使用同一个实例
                            // 注册两个InboundHandler，执行顺序为注册顺序，所以应该是InboundHandler1 InboundHandler2
                            // 注册两个OutboundHandler，执行顺序为注册顺序的逆序，所以应该是OutboundHandler2 OutboundHandler1
                            socketChannel.pipeline().addLast(new EchoServerHandler());
                            socketChannel.pipeline().addLast(new EchoServerHandler2());
                        }
                    });

            // 异步的绑定服务器，调用sync方法阻塞等待直到绑定完成
            ChannelFuture sync = serverBootstrap.bind().sync();
            System.out.println("开始监听，端口为：" + sync.channel().localAddress());
            // 获取Channel的closeFuture，并且阻塞当前线程直到它完成
            sync.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                // 关闭eventLoopGroup释放所有资源
                acceptorGroup.shutdownGracefully().sync();
                handleGroup.shutdownGracefully().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
