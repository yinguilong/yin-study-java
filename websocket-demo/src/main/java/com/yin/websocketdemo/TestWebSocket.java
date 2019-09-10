package com.yin.websocketdemo;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 服务端
 *
 * @author yinguilong
 * @Time 2019-09-10 10:34
 **/
@ServerEndpoint("/testWebSocket/{name}")
@Component
public class TestWebSocket {
    // 用来记录当前连接数的变量
    private static volatile int onlineCount = 0;

    // concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象
    private static CopyOnWriteArraySet<TestWebSocket> webSocketSet = new CopyOnWriteArraySet<TestWebSocket>();

    // 与某个客户端的连接会话，需要通过它来与客户端进行数据收发
    private Session session;
    /**
     * mingcheg
     */
    private String name;

    @OnOpen
    public void onOpen(Session session, @PathParam("name") String name) throws Exception {
        this.session = session;
        System.out.println(this.session.getId());
        this.name = name;
        webSocketSet.add(this);
//        LOGGER.info("Open a websocket. id={}, name={}", id, name);
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
//        System.out.printf("Receive a message from client: " + message);
        try {
            this.sendMessage(String.format("%s:%s",this.name,message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.printf("Error while websocket. ", error);
    }

    public void sendMessage(String message) throws Exception {
        if(webSocketSet!=null&&!webSocketSet.isEmpty()){
            for (TestWebSocket item : webSocketSet) {
                item.session.getBasicRemote().sendText(message);
            }

        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        onlineCount--;
    }
}

