package com.mysmarthome;


import com.mysmarthome.server.MulThreadSocketServer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by pangkunkun on 2017/9/3.
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments var1) throws Exception{

        MulThreadSocketServer mulThreadSocketServer=new MulThreadSocketServer();
        mulThreadSocketServer.Server();
    }

}

