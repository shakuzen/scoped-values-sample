package com.example.demo.unstructured;

import com.example.demo.framework.Framework;
import com.example.demo.framework.Request;
import com.example.demo.framework.Response;

public class UnstructuredConcurrencyMain {

    static void main() {
        Framework framework = Framework.withApplication(new UnstructuredConcurrencyApplication());
        framework.serve(new Request(), new Response());
    }
}
