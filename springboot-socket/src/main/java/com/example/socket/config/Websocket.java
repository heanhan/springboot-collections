package com.example.socket.config;


import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket/{name}")
public class Websocket {

    public String name;//记录当前websocket用户是谁
    private Session session;//连接，用于记录当前连接

    /**
     * 作用： 建立连接
     * @param name  代表地址参数中的name,用于区分连接是谁
     * @param session  当前的连接
     */
    @OnOpen
    public void onOpen(@PathParam("name") String name,Session session){

        this.name=name;
        this.session=session;

    }

    /**
     * 作用： 用于处理接受客户端发来的消息，这个地方应该根据自己的业务需求，决定到底写什么
     * 比如两个人的聊天，应该是这里是接受消息，看看这个消息发送给谁，容纳后转发给另一个人
     * 如何判断另一个人接收者是谁，to:张三，message:内容，date：2019-09-09
     * @param session
     * @param message
     */
    @OnMessage//当服务器接受到消息时触发。
    public void onMessage(Session session,String message){

        //首先解析触发过来的内容，找到目标者。
        //

    }

    /**
     * 当出现错误时触发
     */
    @OnError
    public void onError(){

    }

    /**
     * 关闭连接
     */
    @OnClose
    public void onClose(){

    }

}
