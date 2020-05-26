package com.mysmarthome.Controller;

import com.mysmarthome.server.ServerSocket1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServerController {
    @Autowired
    ServerSocket1 serverSocket1;

    @GetMapping("/test1")
    public void test1(){
        serverSocket1.ServerSocketDemo();
    }
}
