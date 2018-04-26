package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * 多路复用类，独立线程，负责轮询多路复用器Selector
 * @author nong
 */
public class MultiplexerTimeServer implements Runnable {

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    private volatile boolean stop;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public MultiplexerTimeServer(int port) {
        try {
            this.selector = Selector.open();
            this.serverSocketChannel = ServerSocketChannel.open();
            // 非阻塞
            this.serverSocketChannel.configureBlocking(false);
            // 绑定端口，最大连接数
            this.serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);
            this.serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The time server is start in port:" + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop(){
        this.stop = true;
    }

    @Override
    public void run() {
        while (!stop){
            try {
                // 休眠时间为1秒，每秒唤醒一次selector
                selector.select(1000);
                // 当有处于就绪状态的channel时，selector将返回该channel的SelectionKey集合
//                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();

                SelectionKey key = null;

                while (iterator.hasNext()){
                    key = iterator.next();
                    iterator.remove();
                    try {
                        this.handleInput(key);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 处理客户端请求
     * @param key
     * @throws IOException
     */
    private void handleInput(SelectionKey key) throws IOException {
        if(!key.isValid()){
            return;
        }

        // 处理新接入的请求消息
        if(key.isAcceptable()){
            ServerSocketChannel channel = (ServerSocketChannel) key.channel();
            SocketChannel accept = channel.accept();
            // 非阻塞
            accept.configureBlocking(false);
            accept.register(this.selector, SelectionKey.OP_READ);
        }

        if(key.isReadable()){
            SocketChannel socketChannel = (SocketChannel) key.channel();
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            int read = socketChannel.read(readBuffer);

            // 读操作是非阻塞的，使用返回值进行判断
            // 1、返回值大于0：读到了字节，对字节进行编解码
            // 2、返回值等于0：没有读取到字节，属于正常现在，忽略
            // 3、返回值为-1：链路已经关闭，需要关闭SocketChannel，释放资源
            if(read > 0){
                // socketChannel.read(readBuffer)写模式完成后，position指针位于缓冲区的有效字节的最后一位，通过flip()将position调转到第一位后开始读操作
                // buffer中的flip方法涉及到bufer中的Capacity,Position和Limit三个概念。
                // 其中Capacity在读写模式下都是固定的，就是我们分配的缓冲大小,Position类似于读写指针，
                // 表示当前读(写)到什么位置,Limit在写模式下表示最多能写入多少数据，此时和Capacity相同，
                // 在读模式下表示最多能读多少数据，此时和缓存中的实际数据大小相同。在写模式下调用flip方法，
                // 那么limit就设置为了position当前的值(即当前写了多少数据),postion会被置为0，
                // 以表示读操作从缓存的头开始读。也就是说调用flip之后，读写指针指到缓存头部，
                // 并且设置了最多只能读出之前写入的数据长度(而不是整个缓存的容量大小)。
                readBuffer.flip();
                // 根据缓冲区可读的字节个数创建对应大小的字节数组
                byte[] bytes = new byte[readBuffer.remaining()];
                readBuffer.get(bytes);

                String body = new String(bytes, "UTF-8");
                body = body == null ? null : body.replaceAll("\r\n", "");
                System.out.println("The time server receive order:" + body);

                String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? simpleDateFormat.format(new Date())+"\n" : "BAD ORDER\n";

                this.doWrite(socketChannel, currentTime);
            }else if(read < 0){
                // 对端链路关闭
                key.cancel();
                socketChannel.close();
            }else {
                // 读到0字节，忽略
            }
        }
    }

    /**
     * 写出到客户端
     * @param socketChannel
     * @param res
     * @throws IOException
     */
    private void doWrite(SocketChannel socketChannel, String res) throws IOException {
        if(res == null || res.trim().length() == 0){
            return;
        }

        byte[] bytes = res.getBytes();
        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
        writeBuffer.put(bytes);
        writeBuffer.flip();
        socketChannel.write(writeBuffer);
    }
}
