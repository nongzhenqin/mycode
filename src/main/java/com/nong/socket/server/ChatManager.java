package com.nong.socket.server;

import java.util.ArrayList;
import java.util.List;

/**
 * 仅有一个聊天室所以建立为单例
 * @author nong
 */
public class ChatManager {
    private static ChatManager ourInstance = new ChatManager();

    public static ChatManager getInstance() {
        return ourInstance;
    }

    private ChatManager() {
    }

    private List<ChatSocket> users = new ArrayList<>();

    public void addUsers(ChatSocket chatSocket){
        users.add(chatSocket);
    }

    public void removeUsers(List<ChatSocket> closeUsers){
        users.removeAll(closeUsers);
    }

    /**
     * 向每个socket输出内容
     * @param chatSocket
     * @param msg
     */
    public void publish(ChatSocket chatSocket, String msg){
        List<ChatSocket> closeUsers = new ArrayList<>();

        for(ChatSocket cs : users){
            if(cs.socketIsClosed()){
                closeUsers.add(cs);
            }
        }

        this.removeUsers(closeUsers);

        for(ChatSocket cs : users) {
            if (cs.equals(chatSocket)) {
                continue;
            }

            cs.outMsg(msg);
        }

    }

}
