package com.example.demo.serial;

import com.example.demo.framework.*;

public class SerialApplication implements Application {

    @Override
    public void handle(Request request, Response response) {
        String a = getA(request);
        String b = getB(request);
        writeToResponse(a, b, response);
    }

    private String getA(Request request) {
        return Framework.readKey("a");
    }

    private String getB(Request request) {
        return Framework.readKey("b");
    }

    private void writeToResponse(String a, String b, Response response) {
    }

}
