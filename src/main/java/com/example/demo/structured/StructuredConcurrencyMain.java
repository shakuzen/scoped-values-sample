package com.example.demo.structured;

import com.example.demo.framework.Framework;
import com.example.demo.framework.Request;
import com.example.demo.framework.Response;

public class StructuredConcurrencyMain {

    static void main() {
        Framework framework = Framework.withApplication(new StructuredConcurrencyApplication());
        framework.serve(new Request(), new Response());
    }
}
