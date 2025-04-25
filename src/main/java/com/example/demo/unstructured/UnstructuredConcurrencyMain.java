package com.example.demo.unstructured;

import com.example.demo.framework.Framework;

public class UnstructuredConcurrencyMain {

    public static void main( String[] args ) {
        Framework framework = Framework.withApplication(new UnstructuredConcurrencyApplication());
        framework.serve(null, null);
    }
}
