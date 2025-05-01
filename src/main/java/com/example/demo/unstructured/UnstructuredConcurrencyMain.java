package com.example.demo.unstructured;

import com.example.demo.framework.Framework;
import com.example.demo.framework.Request;
import com.example.demo.framework.Response;

public class UnstructuredConcurrencyMain {

    public static void main( String[] args ) {
        Framework framework = Framework.withApplication(new UnstructuredConcurrencyApplication());
        framework.serve(new Request(), new Response());
    }
}
