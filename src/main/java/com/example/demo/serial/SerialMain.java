package com.example.demo.serial;

import com.example.demo.framework.Framework;

public class SerialMain {

    public static void main( String[] args ) {
        Framework framework = Framework.withApplication(new SerialApplication());
        framework.serve(null, null);
    }
}
