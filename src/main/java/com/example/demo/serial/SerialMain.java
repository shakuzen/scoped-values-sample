package com.example.demo.serial;

import com.example.demo.framework.Framework;
import com.example.demo.framework.Request;
import com.example.demo.framework.Response;

public class SerialMain {

    static void main() {
        Framework framework = Framework.withApplication(new SerialApplication());
        framework.serve(new Request(), new Response());
    }
}
