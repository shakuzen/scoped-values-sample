package com.example.demo.structured;

import com.example.demo.framework.Framework;

public class StructuredConcurrencyMain {

    public static void main( String[] args ) {
        Framework framework = Framework.withApplication(new StructuredConcurrencyApplication());
        framework.serve(null, null);
    }
}
