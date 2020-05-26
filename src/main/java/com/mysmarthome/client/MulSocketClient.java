package com.mysmarthome.client;

import java.io.IOException;



public class MulSocketClient {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        int id=10;
        while((id++)<11) {
            new Thread(new ThreadClientSocket(id)).start();;
        }

    }

}
