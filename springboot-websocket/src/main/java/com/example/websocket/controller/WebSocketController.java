package com.example.websocket.controller;

import com.example.websocket.server.WebSocketServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;


@RestController
public class WebSocketController {

    @RequestMapping(value = "/pushMsgToHtml")
    public String pushMsgToHtml() throws IOException {
        CopyOnWriteArraySet<WebSocketServer> webSocketSet = WebSocketServer.webSocketSet;
        for(WebSocketServer webSocketServer : webSocketSet){
            webSocketServer.sendMessage("你好客户端.....我是服务端");
        }

        return "200";
    }

}
